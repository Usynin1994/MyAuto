package com.usunin1994.myauto.feature.main_screen.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.usunin1994.myauto.R
import com.usunin1994.myauto.databinding.FragmentMainScreenBinding
import com.usunin1994.myauto.feature.main_screen.adapter.AutoAdapter
import com.usunin1994.myauto.feature.main_screen.domain.Auto

class MainScreenFragment : Fragment(), AutoAdapter.ClickListener {
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private var autoAdapter: AutoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            settingsButton.setOnClickListener {
                findNavController().navigate(R.id.action_mainScreenFragment_to_settingsScreenFragment)
            }

            addButton.setOnClickListener {
                findNavController().navigate(R.id.action_mainScreenFragment_to_newAutoScreenFragment)
            }
        }
    }

    override fun onClick (track: Auto) {
        findNavController().navigate(R.id.action_mainScreenFragment_to_infoScreenFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        autoAdapter = null
        _binding = null
    }
}
