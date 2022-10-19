package aaa.bivizul.a38project.ui.about

import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWTA
import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWTV
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
fun AboutContent(
    component: AboutModel,
    modifier: Modifier = Modifier
) {

    val switchNotifications = remember { mutableStateOf(true) }
    val switchDark = remember { mutableStateOf(true) }

    Column(
        modifier = modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "About",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Text(
            text = SPOHOWTA,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
        Text(
            text = SPOHOWTV,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
    }
}

