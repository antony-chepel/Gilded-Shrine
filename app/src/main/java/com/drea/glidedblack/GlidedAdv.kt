package com.drea.glidedblack

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GlidedAdv(val context: Context) {

    private val jsdoeiwe = AdvertisingIdClient(context.applicationContext)

    suspend fun sacjacac(): String =
        withContext(Dispatchers.IO) {
            jsdoeiwe.start()
            val adIdInfo = jsdoeiwe.info
            Log.d("getAdvertisingId = ",adIdInfo.id.toString())
            jsdoeiwe.finish()
            adIdInfo.id
        }
}