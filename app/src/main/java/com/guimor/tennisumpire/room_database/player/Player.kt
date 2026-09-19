package com.guimor.tennisumpire.room_database.player

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import java.time.LocalDate

@Entity(
indices = [
    Index(value = ["first_name", "last_name"], unique = true),
    ]
)
data class Player (
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "birthdate") val birthdate: LocalDate?,
    @ColumnInfo(name = "height") val height: Float?,
    @ColumnInfo(name = "weight") val weight: Float?,
    @ColumnInfo(name = "country") val country: Country?,
    @ColumnInfo(name = "gender") val gender: PlayerGender?,
    @ColumnInfo(name = "dominant_hand") val dominantHand: PlayerDominantHand?,
    @ColumnInfo(name = "backhand") val backhand: PlayerBackhand?,
)