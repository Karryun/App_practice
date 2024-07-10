package com.example.instagram.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    var auth = FirebaseAuth.getInstance()
    var id : MutableLiveData<String> = MutableLiveData("")
    var password : MutableLiveData<String> = MutableLiveData("")

    var showInputNumberActivity : MutableLiveData<Boolean> = MutableLiveData(false)
    var showFindIdActivity : MutableLiveData<Boolean> = MutableLiveData(false)
    val showMainActivity : MutableLiveData<Boolean> = MutableLiveData(false)

    fun loginWithSignupEmail(){
        auth.createUserWithEmailAndPassword(id.value.toString(), password.value.toString()).addOnCompleteListener {
            if(it.isSuccessful){
                showInputNumberActivity.value = true
            }else{
                //아이디가 있을 경우
                loginEmail()
            }
        }

    }

    fun loginEmail(){
        auth.signInWithEmailAndPassword(id.value.toString(), password.value.toString()).addOnCompleteListener {
            if(it.isSuccessful){
                    showMainActivity.value = true
                }else{
                    showInputNumberActivity.value = true
                }

            }
        }

}



// if(it.result.user?.isEmailVerified == true){