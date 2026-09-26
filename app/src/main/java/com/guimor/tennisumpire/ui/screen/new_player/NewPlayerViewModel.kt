package com.guimor.tennisumpire.ui.screen.new_player

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.domain.error.Error
import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.domain.validation.ValidationRules.isNotNumberGreaterThanZero
import com.guimor.tennisumpire.domain.error.FormatError
import com.guimor.tennisumpire.domain.error.OperationResult
import com.guimor.tennisumpire.domain.model.StoredIn
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.room_database.player.PlayerRepositoryImpl
import com.guimor.tennisumpire.ui.model.FormFieldData
import com.guimor.tennisumpire.ui.model.FormFieldDataType
import com.guimor.tennisumpire.ui.model.getValueOrNull
import com.guimor.tennisumpire.view_model.Resettable
import com.guimor.tennisumpire.view_model.UiStateHolder
import com.guimor.tennisumpire.view_model.ValidatableForm
import com.guimor.tennisumpire.view_model.ViewModelHelper
import com.guimor.tennisumpire.view_model.validationDebounce
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

class NewPlayerViewModel(
    override val _uiState: MutableStateFlow<NewPlayerUiState> = MutableStateFlow(NewPlayerUiState()),
    override val uiState: StateFlow<NewPlayerUiState> = _uiState.asStateFlow(),
    private val playerRepository: PlayerRepositoryImpl
) : ViewModel(),
    UiStateHolder<NewPlayerUiState>,
    Resettable,
    ValidatableForm {
    val debounceValidatePlayerFirstName = validationDebounce { validatePlayerFirstName() }
    val debounceValidatePlayerLastName = validationDebounce { validatePlayerLastName() }
    val debounceValidatePlayerHeight = validationDebounce { validatePlayerHeight() }
    val debounceValidatePlayerWeight = validationDebounce { validatePlayerWeight() }

    override fun resetData() {
        _uiState.value = NewPlayerUiState()
    }

    override fun validateForm() {
        //I use null to represent the items from the screen that don't have any type of
        //validation. I think this is the best way to do it, as I don't have to manually
        //assign any type of positional number.
        ViewModelHelper.validateForm(
            null,
            ::validatePlayerFirstName,
            ::validatePlayerLastName,
            null,
            ::validatePlayerHeight,
            ::validatePlayerWeight,
            onNoErrors = {
                viewModelScope.launch {
                    val playerPhotoPersistedUri = uiState.value.playerPhotoUri
                        ?.let { playerPhotoUri ->
                            when (val result =
                                //Here, I should  put imageResolution to a limit
                                // and transform images to that limit before saving them
                                MyApplication.appModule.appFileManager.persistFileAndGetUri(
                                    storedIn = StoredIn.PLAYER_PHOTOS,
                                    tempFileUri = playerPhotoUri
                                )
                            ) {
                                is OperationResult.ErrorResult -> {
                                    _uiState.update { state -> state.copy(operationResult = result.error) }
                                    return@launch
                                }

                                is OperationResult.SuccessResult -> result.value
                            }
                        }
                    val operationResult = playerRepository.insertPlayer(
                        player = createPlayer(playerPhotoPersistedUri = playerPhotoPersistedUri)
                    )
                    if (operationResult is Error) {
                        playerPhotoPersistedUri?.let {
                            MyApplication.appModule.appFileManager.deleteFileIfExists(it)
                        }
                    }
                    _uiState.update { state -> state.copy(operationResult = operationResult) }
                }
            },
            navigateToFirstError = { firstErrorPosition ->
                _uiState.update { state -> state.copy(scrollToErrorSection = firstErrorPosition) }
            }
        )
    }

    fun resetScrollToError() {
        _uiState.update { state -> state.copy(scrollToErrorSection = -1) }
    }

    fun resetOperationResult() {
        _uiState.update { state -> state.copy(operationResult = null) }
    }

    fun setPlayerFirstName(newValue: String) {
        _uiState.update { state ->
            state.copy(
                playerFirstName = FormFieldData(
                    value = newValue,
                    error = null
                )
            )
        }
        debounceValidatePlayerFirstName()
    }

    fun setPlayerLastName(newValue: String) {
        _uiState.update { state ->
            state.copy(
                playerLastName = FormFieldData(
                    value = newValue,
                    error = null
                )
            )
        }
        debounceValidatePlayerLastName()
    }

    fun setPlayerBirthdate(newValue: LocalDate?) {
        _uiState.update { state ->
            state.copy(
                playerBirthdate = FormFieldDataType(
                    value = newValue,
                    error = null
                )
            )
        }
        //Test for type validations
        //validatePlayerBirthdate()
    }

    fun setPlayerHeight(newValue: String) {
        _uiState.update { state ->
            state.copy(
                playerHeight = FormFieldData(
                    value = newValue,
                    error = null
                )
            )
        }
        debounceValidatePlayerHeight()
    }

    fun setPlayerWeight(newValue: String) {
        _uiState.update { state ->
            state.copy(
                playerWeight = FormFieldData(
                    value = newValue,
                    error = null
                )
            )
        }
        debounceValidatePlayerWeight()
    }

    fun setPlayerCountry(newValue: Country?) {
        _uiState.update { state ->
            state.copy(
                playerCountry = newValue
            )
        }
    }

    fun setPlayerGender(newValue: PlayerGender) {
        _uiState.update { state ->
            state.copy(
                playerGender =
                    if (newValue == uiState.value.playerGender) null else newValue
            )
        }
    }

    fun setPlayerDominantHand(newValue: PlayerDominantHand) {
        _uiState.update { state ->
            state.copy(
                playerDominantHand =
                    if (newValue == uiState.value.playerDominantHand) null else newValue
            )
        }
    }

    fun setPlayerBackhand(newValue: PlayerBackhand) {
        _uiState.update { state ->
            state.copy(
                playerBackhand = if (newValue == uiState.value.playerBackhand) null else newValue
            )
        }
    }

    fun setPlayerPhoto(newValue: Uri?) {
        _uiState.update { state ->
            state.copy(
                playerPhotoUri = newValue
            )
        }
    }

    fun validatePlayerFirstName(): Boolean {
        return ViewModelHelper.isFieldError(
            formFieldData = uiState.value.playerFirstName,
            required = true,
            ViewModelHelper.ValidationRule(
                condition = String::isBlank,
                error = FormatError.IS_BLANK
            )
        ) { _uiState.update { state -> state.copy(playerFirstName = it) } }
    }

    fun validatePlayerLastName(): Boolean {
        return ViewModelHelper.isFieldError(
            formFieldData = uiState.value.playerLastName,
            required = true,
            ViewModelHelper.ValidationRule(
                condition = String::isBlank,
                error = FormatError.IS_BLANK
            )
        ) { _uiState.update { state -> state.copy(playerLastName = it) } }
    }

    //Test for type validations
    /*
    fun validatePlayerBirthdate() {
        ViewModelHelper.validateField(
            formFieldData = uiState.value.playerBirthdate,
            required = true,
            ViewModelHelper.ValidationRuleType(
                condition = {it.year == 2026},
                error = FormatError.IS_BLANK
            )
        )?.let { _uiState.update { state -> state.copy(playerBirthdate = it) } }
    }
     */

    fun validatePlayerHeight(): Boolean {
        return ViewModelHelper.isFieldError(
            formFieldData = uiState.value.playerHeight,
            required = false,
            ViewModelHelper.ValidationRule(
                condition = { it.isNotNumberGreaterThanZero() },
                error = FormatError.INVALID_NUMBER
            )
        ) { _uiState.update { state -> state.copy(playerHeight = it) } }
    }

    fun validatePlayerWeight(): Boolean {
        return ViewModelHelper.isFieldError(
            formFieldData = uiState.value.playerWeight,
            required = false,
            ViewModelHelper.ValidationRule(
                condition = { it.isNotNumberGreaterThanZero() },
                error = FormatError.INVALID_NUMBER
            )
        ) { _uiState.update { state -> state.copy(playerWeight = it) } }
    }

    private fun createPlayer(
        playerPhotoPersistedUri: Uri?
    ): Player = Player(
        firstName = uiState.value.playerFirstName.value,
        lastName = uiState.value.playerLastName.value,
        birthdate = uiState.value.playerBirthdate.value,
        height = uiState.value.playerHeight.value.getValueOrNull()
            ?.replace(',', '.')?.toFloat(),
        weight = uiState.value.playerWeight.value.getValueOrNull()
            ?.replace(',', '.')?.toFloat(),
        country = uiState.value.playerCountry,
        gender = uiState.value.playerGender,
        dominantHand = uiState.value.playerDominantHand,
        backhand = uiState.value.playerBackhand,
        photo = playerPhotoPersistedUri
    )

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val playerRepository = MyApplication.appModule.playerRepository
                NewPlayerViewModel(
                    playerRepository = playerRepository,
                )
            }
        }
    }
}