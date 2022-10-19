package aaa.bivizul.a38project.ui.root

import aaa.bivizul.a38project.data.repository.SpohowRepository
import aaa.bivizul.a38project.data.repository.SpohowsRepository
import aaa.bivizul.a38project.ui.about.AboutComponent
import aaa.bivizul.a38project.ui.about.AboutModel
import aaa.bivizul.a38project.ui.item.ItemComponent
import aaa.bivizul.a38project.ui.item.ItemModel
import aaa.bivizul.a38project.ui.list.ListComponent
import aaa.bivizul.a38project.ui.list.ListModel
import aaa.bivizul.a38project.ui.main.MainComponent
import aaa.bivizul.a38project.ui.main.MainModel
import aaa.bivizul.a38project.ui.settings.SettingsComponent
import aaa.bivizul.a38project.ui.settings.SettingsModel
import aaa.bivizul.a38project.ui.spohowp.SpohowpComponent
import aaa.bivizul.a38project.ui.spohowp.SpohowpModel
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class RootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : RootModel, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val spohowRepository = SpohowRepository()
    val spohowsRepository = SpohowsRepository()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.SpohowpConfig,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, RootModel.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): RootModel.Child =
        when (config) {
            is Config.SpohowpConfig -> RootModel.Child.SpohowpChild(
                setSpohowp(componentContext)
            )
            is Config.MainConfig -> RootModel.Child.MainChild(
                setMain(componentContext)
            )
            is Config.ListConfig -> RootModel.Child.ListChild(
                setList(componentContext)
            )
            is Config.ItemConfig -> RootModel.Child.ItemChild(
                setItem(componentContext, config)
            )
            is Config.SettingsConfig -> RootModel.Child.SettingsChild(
                setSettings(componentContext)
            )
            is Config.AboutConfig -> RootModel.Child.AboutChild(
                setAbout(componentContext)
            )
        }

    private fun setSpohowp(
        componentContext: ComponentContext
    ): SpohowpModel = SpohowpComponent(
        componentContext = componentContext,
        context = context,
        spohowRepository = spohowRepository,
        onReplaceToMain = {
            navigation.replaceCurrent(Config.MainConfig)
        }
    )

    private fun setMain(
        componentContext: ComponentContext
    ): MainModel = MainComponent(
        componentContext = componentContext,
        onClickList = {
            navigation.push(Config.ListConfig)
        },
        onClickSettings = {
            navigation.push(Config.SettingsConfig)
        },
        onClickAbout = {
            navigation.push(Config.AboutConfig)
        }
    )

    private fun setList(
        componentContext: ComponentContext
    ): ListModel = ListComponent(
        componentContext = componentContext,
        spohowsRepository = spohowsRepository,
        onClickListItem = { itemId ->
            navigation.push(Config.ItemConfig(itemId = itemId))
        },
    )

    private fun setItem(
        componentContext: ComponentContext,
        config: Config.ItemConfig
    ): ItemModel = ItemComponent(
        componentContext = componentContext,
        spohowsRepository = spohowsRepository,
        spohowItemId = config.itemId
    )

    private fun setSettings(
        componentContext: ComponentContext
    ): SettingsModel = SettingsComponent(
        componentContext = componentContext,
    )

    private fun setAbout(
        componentContext: ComponentContext
    ): AboutModel = AboutComponent(
        componentContext = componentContext,
    )

    private sealed class Config : Parcelable {
        @Parcelize
        object SpohowpConfig : Config()

        @Parcelize
        object MainConfig : Config()

        @Parcelize
        object ListConfig : Config()

        @Parcelize
        data class ItemConfig(val itemId: Int) : Config()

        @Parcelize
        object SettingsConfig : Config()

        @Parcelize
        object AboutConfig : Config()
    }
}