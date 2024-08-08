package com.example.rentacar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class AddVehicleFragment : Fragment(R.layout.fragment_add_vehicle) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_vehicle, container, false)

        val carTypeSpinner: Spinner = view.findViewById(R.id.add_sp_car_type)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.car_types_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            carTypeSpinner.adapter = adapter
        }

        val seatsSpinner: Spinner = view.findViewById(R.id.add_sp_seats)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.number_of_seats_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            seatsSpinner.adapter = adapter
        }

        val colorSpinner: Spinner = view.findViewById(R.id.add_sp_color)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.car_colors_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            colorSpinner.adapter = adapter
        }

        val companyEditText: EditText = view.findViewById(R.id.editTextCompany)
        val priceEditText: EditText = view.findViewById(R.id.editTextPrice)

        val addButton: Button = view.findViewById(R.id.button)
        addButton.setOnClickListener {
            val selectedCarType = carTypeSpinner.selectedItem.toString()
            val selectedSeats = seatsSpinner.selectedItem.toString()
            val selectedColor = colorSpinner.selectedItem.toString()
            val carCompany = companyEditText.text.toString()
            val carPrice = priceEditText.text.toString()
            val ownerId = FirebaseAuth.getInstance().uid.toString()

            if (ownerId.isNullOrEmpty()) {
                Snackbar.make(view, "User is not authenticated", Snackbar.LENGTH_LONG).show()
            } else {
                // Proceed with adding the car
                val newCar = Car(selectedCarType, selectedSeats, selectedColor, carCompany, carPrice, ownerId)
                sharedViewModel.addCar(newCar)

                Snackbar.make(view, "Car added successfully!", Snackbar.LENGTH_LONG).show()
            }

        }

        return view
    }
}
