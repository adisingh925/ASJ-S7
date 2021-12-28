package com.app.afinal.list_fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.afinal.R
import com.app.afinal.adapter.adapter
import com.app.afinal.databinding.FragmentListFragmentBinding
import com.app.afinal.model.model
import com.app.afinal.userviewmodel.UserViewModel


class list_fragment : Fragment() {

    lateinit var binding: FragmentListFragmentBinding

    lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListFragmentBinding.inflate(layoutInflater)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val adapter = adapter()
        val recyclerview = binding.recyclerview
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.floatingbutton.setOnClickListener()
        {
            findNavController().navigate(R.id.action_list_fragment_to_operation_fragment)
        }

        userViewModel.readalldata.observe(viewLifecycleOwner, Observer
        {user->
            adapter.setdata(user)
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete)
        {
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes"){_,_->
                userViewModel.deleteall()
            }
            builder.setNegativeButton("No"){_,_->

            }
            builder.setMessage("Are you sure you want to delete everything")
            builder.setTitle("Delete Everything")
            builder.create().show()
        }
        return super.onOptionsItemSelected(item)
    }
}