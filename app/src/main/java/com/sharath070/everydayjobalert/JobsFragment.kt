package com.sharath070.everydayjobalert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.sharath070.everydayjobalert.databinding.FragmentJobsBinding

class JobsFragment : Fragment() {

    private val qualification = listOf(
        "High School", "Intermediate", "ITI/Diploma", "B.Ed/M.Ed", "Nursing", "Engineering", "MBA",
        "Graduation", "Post Graduation", "Medical", "Law", "Finance", "Arts", "Aviation",
        "Pharmacy", "Agriculture", "Architecture", "Any Degree"
    )

    private var _binding: FragmentJobsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dropDownAdapter =
            ArrayAdapter(requireContext(), R.layout.dropdown_list_item, qualification)
        binding.jobsFilter.setAdapter(dropDownAdapter)

        binding.jobsFilter.setDropDownBackgroundDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.search_bar_bg,
                null
            )
        )

        binding.jobsFilter.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position)
            Toast.makeText(requireContext(), selectedItem.toString(), Toast.LENGTH_SHORT).show()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}