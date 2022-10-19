package aaa.bivizul.a38project.ui.root

import aaa.bivizul.a38project.ui.item.ItemModel
import aaa.bivizul.a38project.ui.list.ListModel
import aaa.bivizul.a38project.ui.main.MainModel
import aaa.bivizul.a38project.ui.settings.SettingsModel
import aaa.bivizul.a38project.ui.spohowp.SpohowpModel
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootModel {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class SpohowpChild(val component: SpohowpModel) : Child()
        class MainChild(val component: MainModel) : Child()
        class ListChild(val component: ListModel) : Child()
        class ItemChild(val component: ItemModel) : Child()
        class SettingsChild(val component: SettingsModel) : Child()
    }

}