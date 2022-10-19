package aaa.bivizul.a38project.ui.item

import aaa.bivizul.a38project.domain.model.Spohowin
import aaa.bivizul.a38project.ui.spohowwidget.Spohowcp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ItemContent(
    component: ItemModel,
    modifier: Modifier = Modifier
) {

    val spohowItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()
//    val scrollState = rememberScrollState()

    if (spohowItemList != null) {
        spohowItemList?.let { list ->
            list[model.selectedSpohowItemId - 1].let { spohows ->
                LazyColumn  (
                    modifier = modifier
//                        .verticalScroll(scrollState)
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Column {
                            Text(
                                text = spohows.spohowtit,
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = spohows.spohowdesc,
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }
                    if (spohows.spohowin != emptyList<Spohowin>()){
                        items(spohows.spohowin){ spohowin ->
                            Card(){
                                Column {
                                    Text(
                                        text = spohowin.spohowsubtit,
                                        style = MaterialTheme.typography.h5
                                    )
                                    Text(
                                        text = spohowin.spohowsubdesc,
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    } else {
        Spohowcp(modifier = modifier)
    }
}