package com.example.finalweatherproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.finalweatherproject.R
import com.example.finalweatherproject.databinding.FragmentSettingsBinding
import com.example.finalweatherproject.viewmodel.SettingsFragmentViewModel

class SettingsFragment : Fragment() {

    private lateinit var binding:FragmentSettingsBinding
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(SettingsFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.categoryPropertyLifeData.observe(viewLifecycleOwner, Observer<String> {
            when (it) {
                THEME_CATEGORY -> binding.radioGroup.check(R.id.radio_theme)
                TEMPERATURE_UNIT_CATEGORY -> binding.radioGroup.check(R.id.radio_temperature_units)
            }
        })

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_theme -> viewModel.putCategoryProperty(THEME_CATEGORY)
                R.id.radio_temperature_units -> viewModel.putCategoryProperty(TEMPERATURE_UNIT_CATEGORY)

            }
        }
    }

    companion object {
        private const val THEME_CATEGORY = "theme"
        private const val TEMPERATURE_UNIT_CATEGORY = "temperature_unit"

    }
}