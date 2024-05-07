package com.babak.firstexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.babak.firstexam.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private var _binding:FragmentDetailsBinding?=null
    private val binding get() =_binding!!

    private val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.taskName.text="Taskin adi: ${args.todo.name}"
            when(args.todo.level){
                1->binding.taskName.text="Task Vacibliyi: Vacib"
                2->binding.taskName.text="Task Vacibliyi: Orta"
                3->binding.taskName.text="Task Vacibliyi:Rahat"
            }
            if(args.todo.lastDay){
                binding.lastDayTask.text="Son Gun mu:Beli"
            }else{
                binding.lastDayTask.text="Son Gun mu:Xeyr"
            }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}