package aaa.bivizul.a38project.ui.main

import aaa.bivizul.a38project.ui.spohowwidget.Logo
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(
    component: MainModel,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Let's go",
                modifier = modifier
                    .clickable { component.onClickListModel() },
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Settings",
                modifier = modifier
                    .clickable { component.onClickSettingsModel() },
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            Text(
                text = "About",
                modifier = modifier
                    .clickable { component.onClickAboutModel() },
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
        }


    }

}