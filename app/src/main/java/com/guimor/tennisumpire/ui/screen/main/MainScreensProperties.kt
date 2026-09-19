package com.guimor.tennisumpire.ui.screen.main

import androidx.navigation3.runtime.NavKey
import com.guimor.tennisreferee.R
import com.guimor.tennisumpire.ui.icons.addIcon
import com.guimor.tennisumpire.ui.icons.add_notesIcon
import com.guimor.tennisumpire.ui.icons.person_addIcon
import com.guimor.tennisumpire.ui.icons.sportsIcon
import com.guimor.tennisumpire.ui.screen.main.navigation.NavRoutesMain

object MainScreensProperties {
    fun NavKey.function(
        matchesScreen: (() -> Unit)? = null,
        resultsScreen: (() -> Unit)? = null,
        playersScreen: (() -> Unit)? = null,
    ): Unit? = when (this) {
        NavRoutesMain.Matches -> matchesScreen?.invoke()
        NavRoutesMain.Results -> resultsScreen?.invoke()
        NavRoutesMain.Players -> playersScreen?.invoke()
        else -> {}
    }

    fun <T> NavKey.options(
        matchesScreen: T? = null,
        resultsScreen: T? = null,
        playersScreen: T? = null,
        empty: T
    ): T = when (this) {
        NavRoutesMain.Matches -> matchesScreen ?: empty
        NavRoutesMain.Results -> resultsScreen ?: empty
        NavRoutesMain.Players -> playersScreen ?: empty
        else -> empty
    }
}
//Outside the object to get the context without problems (memory leaks)
fun NavKey.getCurrentScreenData(): MainScreenData {
    return when (this) {
        NavRoutesMain.Matches -> MainScreenData(
            title = R.string.matches,
            fabDescription = R.string.new_match,
            fabIcon = sportsIcon
        )

        NavRoutesMain.Results -> MainScreenData(
            title = R.string.results,
            fabDescription = R.string.new_result,
            fabIcon = add_notesIcon
        )

        NavRoutesMain.Players -> MainScreenData(
            title = R.string.players,
            fabDescription = R.string.new_player,
            fabIcon = person_addIcon
        )

        else -> MainScreenData(
            title = R.string.matches,
            fabDescription = R.string.new_match,
            fabIcon = sportsIcon
        )
    }
}