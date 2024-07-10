package com.example.bottomnavigationviewwithnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationviewwithnavigation.databinding.FragmentFriendsBinding
import com.example.bottomnavigationviewwithnavigation.databinding.FragmentHomeBinding
import com.example.bottomnavigationviewwithnavigation.databinding.FragmentMenuBinding

class MenuFragment : Fragment(){

    private var mBinding : FragmentMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)

        mBinding = binding

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

}