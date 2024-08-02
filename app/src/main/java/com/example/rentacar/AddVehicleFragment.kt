package com.example.rentacar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class AddVehicleFragment : Fragment(R.layout.fragment_add_vehicle) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_vehicle, container, false)

        // Set up car type spinner
        val carTypeSpinner: Spinner = view.findViewById(R.id.add_sp_car_type)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.car_types_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            carTypeSpinner.adapter = adapter
        }

        // Set up number of seats spinner
        val seatsSpinner: Spinner = view.findViewById(R.id.add_sp_seats)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.number_of_seats_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            seatsSpinner.adapter = adapter
        }

        // Set up car color spinner
        val colorSpinner: Spinner = view.findViewById(R.id.add_sp_color)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.car_colors_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            colorSpinner.adapter = adapter
        }

        // Get references to the EditTexts
        val companyEditText: EditText = view.findViewById(R.id.editTextCompany)
        val priceEditText: EditText = view.findViewById(R.id.editTextPrice)

        // Set up the Add Vehicle button
        val addButton: Button = view.findViewById(R.id.button)
        addButton.setOnClickListener {
            // Get the selected items and entered text
            val selectedCarType = carTypeSpinner.selectedItem.toString()
            val selectedSeats = seatsSpinner.selectedItem.toString()
            val selectedColor = colorSpinner.selectedItem.toString()
            val carCompany = companyEditText.text.toString()
            val carPrice = priceEditText.text.toString()

            // Display the message
            val message = "Car added successfully!\nType: $selectedCarType\nSeats: $selectedSeats\nColor: $selectedColor\nCompany: $carCompany\nPrice per day: $carPrice"
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
        }

        return view
    }
}
