package aaa.bivizul.a38project.ui.item

import aaa.bivizul.a38project.data.repository.SpohowsRepository
import aaa.bivizul.a38project.domain.model.Spohows
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemComponent(
    componentContext: ComponentContext,
    spohowsRepository: SpohowsRepository,
    spohowItemId: Int,
) : ItemModel, ComponentContext by componentContext {

    private val _models = MutableValue(ItemModel.Model(selectedSpohowItemId = spohowItemId))
    override val models: Value<ItemModel.Model> = _models

    override val state: StateFlow<List<Spohows>?> =
        spohowsRepository.spohowsList

}