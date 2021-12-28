package com.app.afinal.operation_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.afinal.R
import com.app.afinal.databinding.FragmentOperationFragmentBinding
import com.app.afinal.model.model
import com.app.afinal.userviewmodel.UserViewModel

class operation_fragment : Fragment() {

    lateinit var binding: FragmentOperationFragmentBinding

    lateinit var userviewmodel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperationFragmentBinding.inflate(layoutInflater)

        userviewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.add.setOnClickListener()
        {
            val data = model(binding.id.text.toString().toInt(),binding.firstname.text.toString(),binding.lastname.text.toString())
            userviewmodel.insert(data)
            findNavController().navigate(R.id.action_operation_fragment_to_list_fragment)
        }

        binding.update.setOnClickListener()
        {
            val data = model(binding.id.text.toString().toInt(),binding.firstname.text.toString(),binding.lastname.text.toString())
            userviewmodel.update(data)
            findNavController().navigate(R.id.action_operation_fragment_to_list_fragment)
        }

        binding.delete.setOnClickListener()
        {
            val data = model(binding.id.text.toString().toInt(),binding.firstname.text.toString(),binding.lastname.text.toString())
            userviewmodel.delete(data)
            findNavController().navigate(R.id.action_operation_fragment_to_list_fragment)
        }

        return binding.root
    }

}