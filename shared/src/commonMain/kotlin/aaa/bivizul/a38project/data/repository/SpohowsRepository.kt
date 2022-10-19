package aaa.bivizul.a38project.data.repository

import aaa.bivizul.a38project.data.network.SpohowApi
import aaa.bivizul.a38project.domain.model.Spohows
import aaa.bivizul.a38project.domain.util.spohowIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SpohowsRepository {

    private val spohowApi = SpohowApi()
    private val spohowjob = SupervisorJob()
    private val spohowscope = CoroutineScope(spohowIoDispatcher + spohowjob)

    private val _spohowItemList = MutableStateFlow<List<Spohows>?>(null)
    val spohowsList: StateFlow<List<Spohows>?> = _spohowItemList.asStateFlow()

    init {
        getSpohowItem()
    }

    fun getSpohowItem() {
        spohowscope.launch {
            val response = spohowApi.getSpohowItem()
            _spohowItemList.emit(response)
        }
    }

}