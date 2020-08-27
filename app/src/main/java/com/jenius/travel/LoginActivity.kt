package com.jenius.travel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonSignIn.setOnClickListener {
            val username = inputUsername.text.toString()
            val password = inputPassword.text.toString()

            if(username.isBlank()) inputUsername.error = "Username harus diisi"
            else inputUsername.error = null

            if(password.isBlank()) inputPassword.error = "Password harus diisi"
            else inputPassword.error = null

            if(username.isNotBlank() && password.isNotBlank()) login(username, password)
        }
    }

    private fun login(username: String, password: String){
        progressBar.visibility = View.VISIBLE
        buttonSignIn.isEnabled = false

        val jsonObject = JSONObject()
        jsonObject.put("username", username)
        jsonObject.put("password", password)

        AndroidNetworking.post("https://thesimplycoder.herokuapp.com/travel-bucket/login")
            .addJSONObjectBody(jsonObject)
            .build()
            .getAsObject(User::class.java, object : ParsedRequestListener<User> {
                override fun onResponse(response: User?) {
                    progressBar.visibility = View.GONE
                    buttonSignIn.isEnabled = true

                    if(response?.code == 401) {
                        Toast.makeText(this@LoginActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
                    } else {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("name", response?.name)
                        intent.putExtra("address", response?.address)
                        intent.putExtra("photo", response?.photo)
                        intent.putExtra("phoneNumber", response?.phoneNumber)
                        startActivity(intent)
                    }
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(this@LoginActivity, anError!!.message, Toast.LENGTH_SHORT).show()

                    progressBar.visibility = View.GONE
                    buttonSignIn.isEnabled = true
                }

            })
    }
}