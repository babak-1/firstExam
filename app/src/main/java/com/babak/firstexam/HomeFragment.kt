package com.babak.firstexam

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.babak.firstexam.databinding.CustomAlertBinding
import com.babak.firstexam.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() =_binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var array= arrayListOf<Todo>()
        val cardAdapter=CardAdapter()



        binding.alertBtn.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
            val alertDialogBinding = CustomAlertBinding.inflate(layoutInflater)
            alertDialog.setView(alertDialogBinding.root).create().show()

            alertDialogBinding.addBtn.setOnClickListener {
                val taskName = alertDialogBinding.textInput.text.toString().trim()
                var lastDay = alertDialogBinding.checkBox.isChecked
                var level = 1

                when (alertDialogBinding.radioGroup.checkedRadioButtonId) {
                    R.id.vacib -> level=1
                    R.id.orta -> level=2
                    R.id.rahat -> level=3
                }

                array.add(Todo(taskName, lastDay, level))
                binding.countText.text = "${array.size}"

                if(array.size==0){
                    binding.emptyText.visibility=View.VISIBLE
                }else{
                    binding.emptyText.visibility=View.GONE
                }

                cardAdapter.updateTaskList(array)
            }
        }



        binding.allCard.layoutManager= LinearLayoutManager(context)
        binding.allCard.adapter=cardAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}