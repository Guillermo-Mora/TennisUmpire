package com.guimor.tennisumpire.ui.screen.new_player

import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.ui.components.form.FormFieldData
import com.guimor.tennisumpire.ui.components.form.FormFieldDataType
import com.guimor.tennisumpire.ui_state.BaseUiState
import java.time.LocalDate

data class NewPlayerUiState(
    val playerFirstName: FormFieldData = FormFieldData(),
    val playerSecondName: FormFieldData = FormFieldData(),
    val playerBirthdate: FormFieldDataType<LocalDate> = FormFieldDataType(),
    val playerHeight: FormFieldData = FormFieldData(),
    val playerWeight: FormFieldData = FormFieldData(),
    val playerCountry: Country? = null,
    val playerGender: PlayerGender? = null,
    val playerDominantHand: PlayerDominantHand? = null,
    val playerBackhand: PlayerBackhand? = null,
) : BaseUiState()