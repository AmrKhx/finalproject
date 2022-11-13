package com.udacity.project4.authentication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.udacity.project4.R
import com.udacity.project4.databinding.ActivityAuthenticationBinding


/**
 * This class should be the starting point of the app, It asks the users to sign in / register, and redirects the
 * signed in users to the RemindersActivity.
 */
class AuthenticationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAuthenticationBinding
    companion object {
        const val TAG = "MainFragment"
        const val SIGN_IN_RESULT_CODE = 1001
    }
override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    binding= DataBindingUtil.setContentView(this,R.layout.activity_authentication)
    //         TODO: Implement the create account and sign in using FirebaseUI, use sign in using email and sign in using Google //Done

    binding.authBut.setOnClickListener{SignIn()}

//          TODO: If the user was authenticated, send him to RemindersActivity

//          TODO: a bonus is to customize the sign in flow to look nice using :
        //https://github.com/firebase/FirebaseUI-Android/blob/master/auth/README.md#custom-layout

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== SIGN_IN_RESULT_CODE){
            val response =IdpResponse.fromResultIntentd(data)
        }
        if(resultCode== Activity.Result_OK)

    }

    private fun SignIn(){
        val provider =AuthUI.IdpConfig.EmailBuilder().build()
        startActivityForResult(AuthUI.getinstance().createSignInBuilder().setAvailableProviders(provider))

    }
}
