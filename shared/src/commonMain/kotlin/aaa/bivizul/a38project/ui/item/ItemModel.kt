package aaa.bivizul.a38project.ui.item

import aaa.bivizul.a38project.domain.model.Spohows
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemModel {

    val models: Value<Model>

    val state: StateFlow<List<Spohows>?>

    data class Model(
        val selectedSpohowItemId: Int
    )

}