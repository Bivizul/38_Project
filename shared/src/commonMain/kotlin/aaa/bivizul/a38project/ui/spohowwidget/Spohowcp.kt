package aaa.bivizul.a38project.ui.spohowwidget

import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWAN
import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWTS
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Spohowcp(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = SPOHOWAN,
            style = MaterialTheme.typography.h2
        )
        CircularProgressIndicator(
            modifier = modifier.size(50.dp),
            color = MaterialTheme.colors.primary,
            strokeWidth = 5.dp
        )
        Text(
            text = SPOHOWTS,
            style = MaterialTheme.typography.h6
        )
    }
}