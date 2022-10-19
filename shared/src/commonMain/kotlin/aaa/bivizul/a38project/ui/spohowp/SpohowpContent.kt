package aaa.bivizul.a38project.ui.spohowp

import aaa.bivizul.a38project.domain.model.Spohowvar
import aaa.bivizul.a38project.domain.util.getSpohowact
import aaa.bivizul.a38project.domain.util.sigSpohowoff
import aaa.bivizul.a38project.ui.spohowwidget.Spohowcp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.delay

@Composable
fun SpohowpContent(
    component: SpohowpModel,
    modifier: Modifier = Modifier
) {

    val spohowg by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    LaunchedEffect(key1 = true) {
        delay(3000)
        spohowg?.spohowg?.let {
            if (it == Spohowvar.SLNO.sl) {
                component.onReplace()
            } else if (it == Spohowvar.SLNP.sl) {
                sigSpohowoff()
                component.onReplace()
            } else {
                getSpohowact(model.activity, it)
            }
        }
    }
    Spohowcp(modifier = modifier)
}