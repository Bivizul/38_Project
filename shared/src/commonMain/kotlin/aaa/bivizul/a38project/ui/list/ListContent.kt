package aaa.bivizul.a38project.ui.list

import aaa.bivizul.a38project.ui.spohowwidget.SpohowButton
import aaa.bivizul.a38project.ui.spohowwidget.Spohowcp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListContent(
    component: ListModel,
    modifier: Modifier = Modifier
) {

    val spohowItemList by component.state.collectAsState()

    if (spohowItemList != null) {
        spohowItemList?.let { list ->
            LazyColumn(
                modifier = modifier.padding(8.dp).fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(list) { spohowItem ->
                    SpohowButton(
                        onClick = { component.onClickListItemModel(id = spohowItem.id) },
                        text = spohowItem.spohowtit
                    )
                }
            }
        }
    } else {
        Spohowcp(modifier = modifier)
    }

}