package com.example.rentacar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class SearchVehicleFragment : Fragment(R.layout.fragment_search_vehicle) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_vehicle, container, false)
        val listView: ListView = view.findViewById(R.id.listViewCars)

        sharedViewModel.cars.observe(viewLifecycleOwner) { carList ->
            val adapter = CarAdapter(requireContext(), carList) { carId ->
                // Handle the delete action
                sharedViewModel.deleteCar(carId)
                Toast.makeText(requireContext(), "Car deleted", Toast.LENGTH_SHORT).show()
            }
            listView.adapter = adapter
        }

        return view
    }
}
