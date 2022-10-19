package aaa.bivizul.a38project.ui.settings

import aaa.bivizul.a38project.ui.spohowwidget.CardSwitch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SettingsContent(
    component: SettingsModel,
    modifier: Modifier = Modifier
) {

    val switchNotifications = remember { mutableStateOf(true) }
    val switchDark = remember { mutableStateOf(true) }

    Column(
        modifier = modifier.padding(8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardSwitch(
                modifier = modifier,
                text = "Notifications",
                state = switchNotifications
            )
            CardSwitch(
                modifier = modifier,
                text = "Dark theme",
                state = switchDark
            )
        }
    }
}

