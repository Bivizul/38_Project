@file:Suppress("DEPRECATION")

package aaa.bivizul.a38project.domain.util

import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWACTIVITY
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

actual val spohowUiDispatcher: CoroutineContext = Dispatchers.Main

actual val spohowIoDispatcher: CoroutineContext = Dispatchers.IO

actual fun getSpohowmm(): String {
    val manfacspohow = android.os.Build.MANUFACTURER
    val modelspohow = android.os.Build.MODEL
    return "$manfacspohow $modelspohow"
}

actual fun getSpohowsim(spohowcon: Any): String {
    val context = spohowcon as Context
    val telmanspohow = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanspohow.simCountryIso
}

actual fun getSpohowid(spohowcon: Any): String {
    val context = spohowcon as Context
    val sharedPreferences = context.getSharedPreferences("appprefspohow", Context.MODE_PRIVATE)
    var spohowid = sharedPreferences.getString("spohow_key", "nospohow") ?: "nospohow"
    if (spohowid == "nospohow") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        spohowid = datetime + randomNum
        sharedPreferences.edit().putString("spohow_key", spohowid).apply()
    }
    return spohowid
}

actual fun getSpohowl(): String {
    return Locale.getDefault().language
}

actual fun getSpohowt(): String {
    val spohowtz: String = SimpleDateFormat("z", Locale.getDefault()).format(
        Calendar.getInstance(
            TimeZone.getTimeZone("GMT"),
            Locale.getDefault()
        ).time
    ).replace("GMT", "")
    val spohowzone = if (spohowtz.contains(":")) spohowtz else "default"
    return spohowzone
}

actual fun getSpohowdlg(spohowcon: Any) {
    val context = spohowcon as Context
    val activity = spohowcon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Oops, error!")
        setMessage("Please try again later, push exit")
        setPositiveButton("Exit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkSpohownet(spohowcon: Any): Boolean {
    val context = spohowcon as Context
    val conmanspohow =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfspohow = conmanspohow.activeNetworkInfo
    return netinfspohow != null && netinfspohow.isConnected
}

actual fun sigSpohowoff() {
    OneSignal.disablePush(true)
}

actual fun getSpohowact(spohowact: Any, spohowurl: String) {
    val activity = spohowact as Activity
    val spohowc = Class.forName(SPOHOWACTIVITY)
    val spohowi = Intent(activity, spohowc)
    val put = spohowi.putExtra(Spohowcon.SPOHOWKOR, spohowurl)
    activity.startActivity(put)
}