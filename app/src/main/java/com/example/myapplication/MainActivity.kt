package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.contus.flycommons.FlyUtils
import com.contusflysdk.api.ChatConnectionListener
import com.contusflysdk.api.ChatManager
import com.contusflysdk.api.FlyCore
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val LTAG = "MirrorFly"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FlyCore.registerUser("123456098") { isSuccess, throwable, data ->
            if(isSuccess) {
                val responseObject = data.get("data") as JSONObject
                Log.i(LTAG, "User Registered")
                val uname = responseObject.getString("username")
                val pwd = responseObject.getString("password")
                val unname
                connectUser(unname)
                // Get Username and password from the object
            } else {
                // Register user failed print throwable to find the exception details.
            }
        }
    }

    private fun connectUser(uname: String) {
        ChatManager.connect(object : ChatConnectionListener {
            override fun onConnected() {
                Log.i(LTAG, "Connected")
                val userJID = FlyUtils.getJid(uname)
                Log.i(LTAG,userJID)
                val idView = findViewById<TextView>(R.id.id)
                idView.text = userJID
                // Write your success logic here to navigate Profile Page or
                // To Start your one-one chat with your friends
            }

            override fun onDisconnected() {
                Log.i(LTAG, "Disconnected")
                // Connection disconnected
                //No need implementations
            }

            override fun onConnectionNotAuthorized() {
                // Connection Not authorized
                //No need implementations
            }
        })



    }
}