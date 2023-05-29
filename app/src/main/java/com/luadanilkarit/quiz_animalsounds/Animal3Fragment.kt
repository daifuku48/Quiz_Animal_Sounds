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
import com.luadanilkarit.quiz_animalsounds.databinding.FragmentAnimal3Binding

class Animal3Fragment : Fragment(){
    private lateinit var binding : FragmentAnimal3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimal3Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        var grade = requireArguments().getInt(ResultsFragment.GRADE_CODE)
        Log.d("grade", grade.toString())
        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.whale_sound)
        binding.soundButton.setOnClickListener {
            mediaPlayer.start()
        }

        binding.secondAnswer.setOnClickListener {
            findNavController().navigate(R.id.action_animal3Fragment_to_resultsFragment,
                bundleOf(ResultsFragment.GRADE_CODE to grade)
            )
        }

        binding.firstAnswer.setOnClickListener {
            findNavController().navigate(R.id.action_animal3Fragment_to_resultsFragment,
                bundleOf(ResultsFragment.GRADE_CODE to grade)
            )
        }

        binding.thirdAnswer.setOnClickListener {
            grade += 1
            findNavController().navigate(R.id.action_animal3Fragment_to_resultsFragment,
                bundleOf(ResultsFragment.GRADE_CODE to grade)
            )
        }
    }
}
