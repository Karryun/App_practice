package com.example.log_inout.navi_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.log_inout.LoginActivity
import com.example.log_inout.SignupActivity
import com.example.log_inout.databinding.FragmentMenuBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MenuFragment : Fragment(){

    private var mBinding : FragmentMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)

        mBinding = binding

        binding.logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)

        }


        return mBinding?.root

    }


    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

}