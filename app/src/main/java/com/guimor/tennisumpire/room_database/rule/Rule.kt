package com.guimor.tennisumpire.room_database.rule

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.guimor.tennisumpire.domain.model.rule.RuleOnGameDeuce
import com.guimor.tennisumpire.domain.model.rule.RuleSetDecider
import com.guimor.tennisumpire.domain.model.rule.RuleSetType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakDecider

@Entity(
    indices = [
        Index(value = ["name"], unique = true),
    ]
)
data class Rule (
    //In the UI, the rules will be separated in these sections for better readability
    // and understanding
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo val name: String,
    @ColumnInfo val sideChanges: Boolean,
    //Sets
    @ColumnInfo val setsQuantityType: RuleSetsQuantityType,
    @ColumnInfo val setsQuantity: Int,
    @Embedded(prefix = "set_") val setRules: SetRules,

    //Deciding set
    //If RuleSetsQuantityType = FIXED_QUANTITY, there will be no possibility for setting this
    //In the UI, this will be enabled/disabled with a boolean check selector or a multiselection
    // button row. For selection same as normal sets / different
    //In case different is selected, the options for the deciding set will appear, in case not, it
    //will be sent as null.
    @Embedded(prefix = "deciding_set_") val decidingSetRules: SetRules? = null,
    @Embedded val timeRules: TimeRules
)

data class SetRules(
    //Set
    @ColumnInfo val setType: RuleSetType,
    //Games
    @ColumnInfo val gamesPerSet: Int? = null,
    @ColumnInfo val onGameDeuce: RuleOnGameDeuce? = null,
    //Tiebreaks
    @ColumnInfo val setDecider: RuleSetDecider? = null,
    @ColumnInfo val pointsPerTiebreak: Int? = null,
    @ColumnInfo val tiebreakDecider: RuleTiebreakDecider? = null,
)

data class TimeRules(
    @ColumnInfo val timeBetweenPoints: Int = 25,
    @ColumnInfo val timeBreakAfterOddGames: Int = 90,
    @ColumnInfo val timeBreakBetweenSets: Int = 120,
    @ColumnInfo val timeMedicalTimeOut: Int = 180,
    @ColumnInfo val timeBathroom: Int = 180,
    @ColumnInfo val timeBathroomWithClothesChange: Int = 300
)