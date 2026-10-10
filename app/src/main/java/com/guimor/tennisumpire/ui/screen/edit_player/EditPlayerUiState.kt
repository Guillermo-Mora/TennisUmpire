package com.guimor.tennisumpire.ui.screen.edit_player

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

data class EditPlayerUiState(
    override val scrollToErrorSection: Int,
    override val playerFirstName: FormFieldData,
    override val playerLastName: FormFieldData,
    override val playerBirthdate: FormFieldDataType<LocalDate>,
    override val playerHeight: FormFieldData,
    override val playerWeight: FormFieldData,
    override val playerCountry: Country?,
    override val playerGender: PlayerGender?,
    override val playerDominantHand: PlayerDominantHand?,
    override val playerBackhand: PlayerBackhand?,
    override val playerPhotoUri: Uri?,
    override val operationResult: MessageResult?
) : EditOrNewPlayerUiState, BaseUiState()
