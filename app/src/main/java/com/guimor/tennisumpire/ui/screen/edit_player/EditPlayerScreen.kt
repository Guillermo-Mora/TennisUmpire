package com.guimor.tennisumpire.ui.screen.edit_player

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.error.Success
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_player.EditOrNewPlayerViewModel
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_player.EditOrNewPlayerScreen

@Composable
fun EditPlayerScreen(
    onNavigateBack: () -> Unit,
    onNavigateToSettings: () -> Unit,
    editPlayerViewModel: EditOrNewPlayerViewModel,
    onOperationSuccess: (successResult: Success) -> Unit,
) {
    //Me falta crear el viewmodel base par ambos, hacerlo clase abstract, ya que la mayoría
    //de la lógica es igual. Y así sólo hacer override dónde sea necesario.
    //En el edit habrá un init en el viewmodel que seteará el uistate para darle todos los valores
    //del jugador.
    //En el edit recordar que al editar un jugador, el nombre de so foto se sobreescribirá con otro
    //archivo nuevo si el nombre permanece igual. Pero si el usuario cambia el nombre del jugador,
    // habrá que eliminar la foto persistida con nombre de archivo del jugador antes de ser editado.
    //Por lo que convendría guardar el uri de la foto original una vez se entra en la página de
    // ediciónn. Para que una vez se elimine, independientemente de si se cambió el
    // nombre o no, tenga a disposición el nombre del archivo antes de editar cualquier campo.
    EditOrNewPlayerScreen(
        onNavigateBack = { onNavigateBack() },
        onNavigateToSettings = { onNavigateToSettings() },
        editPlayerViewModel = editPlayerViewModel,
        onOperationSuccess = { successResult -> onOperationSuccess(successResult) },
        title = stringResource(R.string.edit_player),
        buttonText = stringResource(R.string.save_changes)
    )
}