package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_player

import android.net.Uri
import com.guimor.tennisumpire.domain.error.MessageResult
import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.ui.model.FormFieldData
import com.guimor.tennisumpire.ui.model.FormFieldDataType
import java.time.LocalDate

interface EditOrNewPlayerUiState {
    val scrollToErrorSection: Int
    val playerFirstName: FormFieldData
    val playerLastName: FormFieldData
    val playerBirthdate: FormFieldDataType<LocalDate>
    val playerHeight: FormFieldData
    val playerWeight: FormFieldData
    val playerCountry: Country?
    val playerGender: PlayerGender?
    val playerDominantHand: PlayerDominantHand?
    val playerBackhand: PlayerBackhand?
    val playerPhotoUri: Uri?
    val operationResult: MessageResult?
}