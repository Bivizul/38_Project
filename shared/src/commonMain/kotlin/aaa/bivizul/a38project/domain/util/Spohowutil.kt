package aaa.bivizul.a38project.domain.util

import kotlin.coroutines.CoroutineContext

internal expect val spohowIoDispatcher: CoroutineContext
internal expect val spohowUiDispatcher: CoroutineContext

internal expect fun getSpohowmm(): String
internal expect fun getSpohowsim(spohowcon: Any): String
internal expect fun getSpohowid(spohowcon: Any): String
internal expect fun getSpohowl(): String
internal expect fun getSpohowt(): String
internal expect fun getSpohowdlg(spohowcon: Any)
internal expect fun checkSpohownet(spohowcon: Any): Boolean
internal expect fun sigSpohowoff()
internal expect fun getSpohowact(spohowact: Any, spohowurl: String)