package aaa.bivizul.a38project.ui.list

import aaa.bivizul.a38project.data.repository.SpohowsRepository
import aaa.bivizul.a38project.domain.model.Spohows
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class ListComponent(
    componentContext: ComponentContext,
    spohowsRepository: SpohowsRepository,
    private val onClickListItem: (id: Int) -> Unit,
) : ListModel, ComponentContext by componentContext {

    override val state: StateFlow<List<Spohows>?> = spohowsRepository.spohowsList

    override fun onClickListItemModel(id: Int) {
        onClickListItem(id)
    }
}