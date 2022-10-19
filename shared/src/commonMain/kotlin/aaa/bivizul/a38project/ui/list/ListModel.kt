package aaa.bivizul.a38project.ui.list

import aaa.bivizul.a38project.domain.model.Spohows
import kotlinx.coroutines.flow.StateFlow

interface ListModel {

    val state: StateFlow<List<Spohows>?>

    fun onClickListItemModel(id: Int)

}