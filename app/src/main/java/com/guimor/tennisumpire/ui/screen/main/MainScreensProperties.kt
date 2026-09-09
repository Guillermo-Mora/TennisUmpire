package com.guimor.tennisumpire.ui.screen.main

import android.content.Context
import androidx.navigation3.runtime.NavKey
import com.guimor.tennisreferee.R
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.icons.addIcon
import com.guimor.tennisumpire.icons.add_notesIcon
import com.guimor.tennisumpire.icons.person_addIcon
import com.guimor.tennisumpire.icons.sportsIcon
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
    val context: Context = MyApplication.appModule.context
    return when (this) {
        NavRoutesMain.Matches -> MainScreenData(
            title = context.getString(R.string.matches),
            fabDescription = context.getString(R.string.new_match),
            fabIcon = sportsIcon
        )

        NavRoutesMain.Results -> MainScreenData(
            title = context.getString(R.string.results),
            fabDescription = context.getString(R.string.new_result),
            fabIcon = add_notesIcon
        )

        NavRoutesMain.Players -> MainScreenData(
            title = context.getString(R.string.players),
            fabDescription = context.getString(R.string.new_player),
            fabIcon = person_addIcon
        )

        else -> MainScreenData(
            title = "",
            fabDescription = "",
            fabIcon = addIcon
        )
    }
}