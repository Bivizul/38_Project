package aaa.bivizul.a38project.ui.spohowp

import aaa.bivizul.a38project.data.repository.SpohowRepository
import aaa.bivizul.a38project.domain.model.Spohow
import aaa.bivizul.a38project.domain.model.Spohowg
import aaa.bivizul.a38project.domain.util.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class SpohowpComponent(
    componentContext: ComponentContext,
    context: Any,
    spohowRepository: SpohowRepository,
    private val onReplaceToMain: () -> Unit
) : SpohowpModel, ComponentContext by componentContext {

    private val _models = MutableValue(SpohowpModel.Model(activity = context))
    override val models: Value<SpohowpModel.Model> = _models
    override val state: StateFlow<Spohowg?> = spohowRepository.spohowg

    init {
        try {
            spohowRepository.getSpohowg(
                Spohow(
                    getSpohowmm(),
                    getSpohowsim(context),
                    getSpohowid(context),
                    getSpohowl(),
                    getSpohowt()
                )
            )
        } catch (e: Exception) {
            getSpohowdlg(context)
        }
    }

    override fun onReplace() {
        onReplaceToMain()
    }

}