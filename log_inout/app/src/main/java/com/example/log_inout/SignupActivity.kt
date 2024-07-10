package com.example.log_inout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.log_inout.databinding.ActivitySignupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SignupActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignupBinding

    lateinit var mAuth: FirebaseAuth

    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = Firebase.auth

        mDbRef = Firebase.database.reference

        binding.signupBtn.setOnClickListener {
            val name = binding.nameEdit.text.toString().trim()
            val email = binding.emailEdit.text.toString().trim()
            val password = binding.passwordEdit.text.toString().trim()

            singUp(name, email, password)
        }

    }

    private fun singUp(name: String, email: String, password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this,"회원가입 성공", Toast.LENGTH_SHORT).show()
                    val intent : Intent = Intent(this@SignupActivity, LoginActivity::class.java)
                    startActivity(intent)
                    addUserToDatabase(name, email, mAuth.currentUser?.uid!!)

                } else {
                    Toast.makeText(this,"회원가입 실패", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(name: String, email: String, uId: String){
        mDbRef.child("user").child(uId).setValue(User(name, email, uId))
    }

}