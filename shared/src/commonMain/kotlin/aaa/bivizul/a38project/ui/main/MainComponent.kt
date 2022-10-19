package aaa.bivizul.a38project.ui.main

import com.arkivanov.decompose.ComponentContext

class MainComponent(
    componentContext: ComponentContext,
    private val onClickList: () -> Unit,
    private val onClickSettings: () -> Unit,
    private val onClickAbout: () -> Unit,
) : MainModel, ComponentContext by componentContext {

    override fun onClickListModel() {
        onClickList()
    }

    override fun onClickSettingsModel() {
        onClickSettings()
    }

    override fun onClickAboutModel() {
        onClickAbout()
    }

}