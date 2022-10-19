package aaa.bivizul.a38project.ui.list

import aaa.bivizul.a38project.ui.spohowwidget.SpohowButton
import aaa.bivizul.a38project.ui.spohowwidget.Spohowcp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListContent(
    component: ListModel,
    modifier: Modifier = Modifier
) {

    val spohowItemList by component.state.collectAsState()

    if (spohowItemList != null) {
        spohowItemList?.let { list ->
            Card(
                modifier = modifier.padding(8.dp).fillMaxSize(),
                shape = MaterialTheme.shapes.large,
                elevation = 0.dp
            ){
                LazyColumn(
                    modifier = modifier.padding(horizontal = 8.dp).fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(list) { spohowItem ->
                        Row(
                            modifier = modifier.padding(vertical = 8.dp).fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "->",
                                modifier = modifier.weight(1f),
                                fontSize = 32.sp,
                                textAlign = TextAlign.Center
                            )
                            SpohowButton(
                                modifier = modifier.weight(4f),
                                onClick = { component.onClickListItemModel(id = spohowItem.id) },
                                text = spohowItem.spohowtit
                            )
                            Text(
                                text = "<-",
                                modifier = modifier.weight(1f),
                                fontSize = 32.sp,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
            }

        }
    } else {
        Spohowcp(modifier = modifier)
    }

}