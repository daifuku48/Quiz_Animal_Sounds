package com.luadanilkarit.quiz_animalsounds

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.luadanilkarit.quiz_animalsounds.databinding.FragmentAnimal1Binding
import com.luadanilkarit.quiz_animalsounds.databinding.FragmentFinishBinding

class Animal1Fragment : Fragment(){

    private lateinit var binding : FragmentAnimal1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimal1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var grade = requireArguments().getInt(ResultsFragment.GRADE_CODE)
        Log.d("grade", grade.toString())
        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.sound_cow)
        binding.soundButton.setOnClickListener {
            mediaPlayer.start()
        }

        binding.secondAnswer.setOnClickListener {
            findNavController().navigate(R.id.action_animal1Fragment_to_animal2Fragment,
                bundleOf(ResultsFragment.GRADE_CODE to grade))
        }

        binding.firstAnswer.setOnClickListener {
            findNavController().navigate(R.id.action_animal1Fragment_to_animal2Fragment,
                bundleOf(ResultsFragment.GRADE_CODE to grade))
        }

        binding.thirdAnswer.setOnClickListener {
            grade += 1
            findNavController().navigate(R.id.action_animal1Fragment_to_animal2Fragment,
                bundleOf(ResultsFragment.GRADE_CODE to grade))
        }
    }
}