package com.sharath070.everydayjobalert

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.sharath070.everydayjobalert.databinding.FragmentHomeBinding
import java.util.Timer
import java.util.TimerTask

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.dropdown_menu){
                showPopupMenu()
            }
            true
        }
        return binding.root
    }

    private fun showPopupMenu() {
        val popupMenu = PopupMenu(requireContext(), binding.cvToolbar)
        popupMenu.inflate(R.menu.home_popup_menu)
        popupMenu.show()
    }


}