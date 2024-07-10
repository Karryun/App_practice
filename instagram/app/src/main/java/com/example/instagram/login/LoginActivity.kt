package com.example.instagram.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.instagram.MainActivity
import com.example.instagram.R
import com.example.instagram.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewModel = loginViewModel
        binding.activity = this
        binding.lifecycleOwner = this
        setObserve()
    }

    fun setObserve(){
        loginViewModel.showInputNumberActivity.observe(this){
            if(it){
                finish()
                startActivity(Intent(this, InputNumberActivity::class.java))
            }
        }

        loginViewModel.showFindIdActivity.observe(this){
            if(it){
                startActivity(Intent(this, FindIdActivity::class.java))
            }
        }

        loginViewModel.showMainActivity.observe(this){
            if(it){
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }


    fun findId(){
        println("findId")
        loginViewModel.showFindIdActivity.value = true
    }

}