package com.example.stateflowcounterapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.stateflowcounterapp.databinding.FragmentFirstBinding
import com.example.stateflowcounterapp.viewModel.CounterViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        counterResult()
    }

    private fun counterResult() {
        lifecycleScope.launchWhenStarted {  //Since collect is a Suspend function
            counterViewModel.counterValue.collect{  counterValue ->
                binding.tvResult.text = counterValue.toString()
            }
        }
    }

    private fun onClick() {
        binding.btnInc.setOnClickListener {
            counterViewModel.incrementCounter()
        }
        binding.btnDec.setOnClickListener {
            counterViewModel.decrementCounter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}