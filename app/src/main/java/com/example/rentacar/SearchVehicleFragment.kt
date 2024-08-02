package com.example.rentacar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class SearchVehicleFragment : Fragment(R.layout.fragment_search_vehicle) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_vehicle, container, false)

        // Sample data
        val carList = listOf(
            Car("Sedan", "4 Seater", "Red", "Toyota", "$50"),
            Car("SUV", "7 Seater", "Blue", "Ford", "$70"),
            Car("Hatchback", "4 Seater", "Green", "Honda", "$45"),
            Car("Pick-up Truck", "5 Seater", "Black", "Chevrolet", "$80"),
            Car("Van", "8 Seater", "White", "Nissan", "$90"),
            Car("Sports", "2 Seater", "Yellow", "Ferrari", "$150"),
            Car("Muscle", "2 Seater", "Orange", "Dodge", "$120"),
            Car("Sedan", "5 Seater", "Grey", "Hyundai", "$55"),
            Car("SUV", "5 Seater", "Purple", "BMW", "$85"),
            Car("Hatchback", "4 Seater", "Silver", "Volkswagen", "$50")
        )

        // Set up the ListView
        val listView: ListView = view.findViewById(R.id.listViewCars)
        val adapter = CarAdapter(requireContext(), carList)
        listView.adapter = adapter

        return view
    }
}
