package com.guimor.tennisumpire.ui.screen.new_player

import android.net.Uri
import com.guimor.tennisumpire.domain.error.MessageResult
import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.ui.model.FormFieldData
import com.guimor.tennisumpire.ui.model.FormFieldDataType
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_player.EditOrNewPlayerUiState
import com.guimor.tennisumpire.ui_state.BaseUiState
import java.time.LocalDate

data class NewPlayerUiState(
    override val scrollToErrorSection: Int = -1,
    override val playerFirstName: FormFieldData = FormFieldData(),
    override val playerLastName: FormFieldData = FormFieldData(),
    override val playerBirthdate: FormFieldDataType<LocalDate> = FormFieldDataType(),
    override val playerHeight: FormFieldData = FormFieldData(),
    override val playerWeight: FormFieldData = FormFieldData(),
    override val playerCountry: Country? = null,
    override val playerGender: PlayerGender? = null,
    override val playerDominantHand: PlayerDominantHand? = null,
    override val playerBackhand: PlayerBackhand? = null,
    override val playerPhotoUri: Uri? = null,
    override val operationResult: MessageResult? = null
) : EditOrNewPlayerUiState, BaseUiState()