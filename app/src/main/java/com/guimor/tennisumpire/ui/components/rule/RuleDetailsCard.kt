package com.guimor.tennisumpire.ui.components.rule

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.guimor.tennisumpire.domain.model.rule.RuleOnGameDeuce
import com.guimor.tennisumpire.domain.model.rule.RuleSetDecider
import com.guimor.tennisumpire.domain.model.rule.RuleSetType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakDecider
import com.guimor.tennisumpire.room_database.rule.Rule
import com.guimor.tennisumpire.room_database.rule.ServingRules
import com.guimor.tennisumpire.room_database.rule.SetRules
import com.guimor.tennisumpire.ui.components.card.DetailsCard
import com.guimor.tennisumpire.ui.components.card.DetailsCardEntry
import com.guimor.tennisumpire.ui.components.text.TextOneLine

@Composable
fun RuleDetailsCard(
    rule: Rule?
) {
    DetailsCard {
        DetailsCardEntry(
            definition = "Rule name"
        ) {
            TextOneLine(rule?.name ?: "")
        }
        DetailsCardEntry(
            definition = "Sets quantity"
        ) {
            TextOneLine(
                when (rule?.setsQuantityType) {
                    RuleSetsQuantityType.BEST_OF -> "Best of ${rule.setsQuantity}"
                    RuleSetsQuantityType.FIXED_QUANTITY -> "Fixed quantity of ${rule.setsQuantity}"
                    else -> ""
                }
            )
        }
    }
    DetailsCard {
        SetDetails(
            title = "Sets",
            setRules = rule?.setRules
        )
    }
    rule?.decidingSetRules?.let { decidingSetRules ->
        DetailsCard {
            SetDetails(
                title = "Deciding set",
                setRules = decidingSetRules
            )
        }
    }
}

@Composable
private fun SetDetails(
    title: String,
    setRules: SetRules?
) {
    DetailsCardEntry(
        definition = title,
        definitionFontWeight = FontWeight.Bold
    )
    DetailsCardEntry(
        definition = "Sets type"
    ) {
        TextOneLine(
            when (setRules?.setType) {
                RuleSetType.TIEBREAK -> "Tiebreak to ${setRules.pointsPerTiebreak} points"
                RuleSetType.GAMES -> "Set to ${setRules.gamesPerSet} games"
                else -> ""
            }
        )
    }
    setRules?.onGameDeuce?.let { onGameDeuce ->
        DetailsCardEntry(
            definition = "On game deuce"
        ) {
            TextOneLine(
                when (onGameDeuce) {
                    RuleOnGameDeuce.ADVANTAGE -> "Advantage"
                    RuleOnGameDeuce.GOLDEN_POINT -> "Golden point"
                    RuleOnGameDeuce.STAR_POINT -> "Star point"
                }
            )
        }
    }
    setRules?.setDecider?.let { setDecider ->
        DetailsCardEntry(
            definition = "Sets decider"
        ) {
            TextOneLine(
                when (setDecider) {
                    RuleSetDecider.TIEBREAK -> "Tiebreak to ${setRules.pointsPerTiebreak} points"
                    RuleSetDecider.TWO_GAMES_DIFFERENCE -> "Two games difference"
                }
            )
        }
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 100,
)
private fun RuleDetailsCardPreview() {
    MaterialTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
            ) {
                RuleDetailsCard(
                    rule = Rule(
                        uid = 1,
                        name = "Demo rule",
                        setsQuantityType = RuleSetsQuantityType.FIXED_QUANTITY,
                        setsQuantity = 3,
                        setRules = SetRules(
                            setType = RuleSetType.GAMES,
                            gamesPerSet = 6,
                            onGameDeuce = RuleOnGameDeuce.ADVANTAGE,
                            setDecider = RuleSetDecider.TIEBREAK,
                            pointsPerTiebreak = 7,
                            tiebreakDecider = RuleTiebreakDecider.TWO_POINTS_DIFFERENCE
                        ),
                        decidingSetRules = null,
                        servingRules = ServingRules(),
                    )
                )
            }
        }
    }
}