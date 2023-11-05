package com.vsened.deliveryapp.presentation.fragments.menu

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.vsened.deliveryapp.R
import com.vsened.deliveryapp.databinding.FragmentMainMenuBinding
import com.vsened.deliveryapp.domain.model.Add
import com.vsened.deliveryapp.domain.model.FoodType
import com.vsened.deliveryapp.presentation.MainActivity
import com.vsened.deliveryapp.presentation.adapters.adds.AddsAdapter
import com.vsened.deliveryapp.presentation.adapters.foodtypes.FoodTypeAdapter
import com.vsened.deliveryapp.presentation.adapters.meals.MealTypeAdapter
import com.vsened.deliveryapp.presentation.fragments.isPermissionsGranted


class MainMenuFragment() : Fragment() {

    private var _binding: FragmentMainMenuBinding? = null
    private var adds = ArrayList<Add>()
    private lateinit var pLauncher: ActivityResultLauncher<String>

    private val viewModel by activityViewModels<MenuViewModel>()

    private val binding: FragmentMainMenuBinding
        get() = _binding ?: throw RuntimeException("FragmentMainMenuBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        initAdds()
        initFoodTypes()
        initDishes()
        binding.llCity.setOnClickListener {
            Log.d("llCity", viewModel.state.meals.toString())
            Log.d("llCity", viewModel.state.types.toString())
        }
    }

    private fun initAdds(){
        binding.rvAdds.layoutManager = LinearLayoutManager(activity, HORIZONTAL, false)
        adds.add(Add(R.drawable.pizza_0))
        adds.add(Add(R.drawable.pizza_1))
        adds.add(Add(R.drawable.pizza_2))
        val adapter = AddsAdapter(activity as MainActivity)
        adapter.submitList(adds)
        binding.rvAdds.adapter = adapter
    }

    private fun initFoodTypes(){
        binding.foodTypes.layoutManager = LinearLayoutManager(activity, HORIZONTAL, false)
        binding.rvFoodTypes.layoutManager = LinearLayoutManager(activity, HORIZONTAL, false)
        val adapter = FoodTypeAdapter(activity as MainActivity)
        adapter.submitList(viewModel.state.types)
        binding.foodTypes.adapter = adapter
        binding.rvFoodTypes.adapter = adapter
        binding.rvFoodTypes.ser

    }

    private fun initDishes(){
        binding.rvMeals.layoutManager = LinearLayoutManager(activity, VERTICAL, false)
        val adapter = MealTypeAdapter(activity as MainActivity)
        adapter.submitList(viewModel.state.meals)
        binding.rvMeals.adapter = adapter
    }

    private fun permissionListener(){
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkPermission() {
        if (!isPermissionsGranted(Manifest.permission.INTERNET)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.INTERNET)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainMenuFragment()
    }
}

