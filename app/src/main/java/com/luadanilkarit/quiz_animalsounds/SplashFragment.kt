package com.luadanilkarit.quiz_animalsounds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.luadanilkarit.quiz_animalsounds.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class SplashFragment : Fragment(){
    private val mainScope = MainScope()

    lateinit var binding : FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        delay()
    }

    private fun delay()
    {
        mainScope.launch {
            kotlinx.coroutines.delay(3000)
            findNavController().navigate(R.id.action_splashFragment_to_animal1Fragment, bundleOf(ResultsFragment.GRADE_CODE to 0))
        }
    }
}