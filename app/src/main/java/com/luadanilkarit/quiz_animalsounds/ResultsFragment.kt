package com.luadanilkarit.quiz_animalsounds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.luadanilkarit.quiz_animalsounds.databinding.FragmentFinishBinding

class ResultsFragment : Fragment(){

    private lateinit var binding: FragmentFinishBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinishBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        const val GRADE_CODE = "GRADE_CODE"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val grade = requireArguments().getInt(ResultsFragment.GRADE_CODE)

        if (grade == 0)
        {
            binding.gradeText.text = getString(R.string.not_cool)
        } else if (grade == 1)
            binding.gradeText.text = getString(R.string.you_can_better)
        else if (grade == 2)
            binding.gradeText.text = getString(R.string.good_job)
        else if (grade == 3)
            binding.gradeText.text = getString(R.string.you_are_the_best)

        binding.popbackstackbutton.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_splashFragment)
        }
    }
}