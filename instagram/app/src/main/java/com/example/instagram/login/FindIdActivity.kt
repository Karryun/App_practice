package com.example.instagram.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.instagram.R
import com.example.instagram.databinding.ActivityFindIdBinding

class FindIdActivity : AppCompatActivity() {
    lateinit var binding : ActivityFindIdBinding
    val findIdViewModel : FindIdViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_find_id)
        binding.activity = this
        binding.viewModel = findIdViewModel
        binding.lifecycleOwner = this
        setObserve()
    }

    fun setObserve(){
        findIdViewModel.toastMessage.observe(this){
            if(!it.isEmpty()){
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        }
    }
}