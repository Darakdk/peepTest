package com.example.peeptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_home.*

class homeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    data class User(var username: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //get database
        val database = FirebaseDatabase.getInstance()
        //signout button
        signOutBut.setOnClickListener{ signOut() }

        auth = FirebaseAuth.getInstance()
        val user= auth.currentUser
        userName.text=user?.email
    }

    //Sign out and back to main activity
    private fun signOut() {
        auth.signOut();
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
