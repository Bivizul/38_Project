package aaa.bivizul.a38project.ui.spohowp

import aaa.bivizul.a38project.domain.model.Spohowg
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface SpohowpModel {

    val models: Value<Model>
    val state: StateFlow<Spohowg?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}