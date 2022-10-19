package aaa.bivizul.a38project.data.repository

import aaa.bivizul.a38project.data.network.SpohowApi
import aaa.bivizul.a38project.domain.model.Spohow
import aaa.bivizul.a38project.domain.model.Spohowg
import aaa.bivizul.a38project.domain.util.spohowIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SpohowRepository {

    private val spohowApi = SpohowApi()
    private val spohowjob = SupervisorJob()
    private val spohowscope = CoroutineScope(spohowIoDispatcher + spohowjob)

    private val _spohowg = MutableStateFlow<Spohowg?>(null)
    val spohowg: StateFlow<Spohowg?> = _spohowg.asStateFlow()

    fun getSpohowg(spohow: Spohow) {
        spohowscope.launch {
            val response = spohowApi.getSpohowg(spohow)
            _spohowg.emit(response)
        }
    }

}