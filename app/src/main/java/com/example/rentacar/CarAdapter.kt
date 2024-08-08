package com.example.rentacar

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class CarAdapter(
    context: Context,
    private val carList: List<Car>,
    private val onDeleteClick: (String) -> Unit
) : ArrayAdapter<Car>(context, 0, carList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_car, parent, false)
        val car = carList[position]

        // Get the current user's ID
        val currentUserId = FirebaseAuth.getInstance().uid
        Log.d("CarAdapter", "Current logged in ID: $currentUserId")
        Log.d("CarAdapter", "POST Owner ID: ${car.ownerId}")

        view.findViewById<TextView>(R.id.textViewCarType).text = "Type:           " + car.type
        view.findViewById<TextView>(R.id.textViewCarSeats).text = "Seats:          " + car.seats
        view.findViewById<TextView>(R.id.textViewCarColor).text = "Colors:         " + car.color
        view.findViewById<TextView>(R.id.textViewCarCompany).text = "Company:   " + car.company
        view.findViewById<TextView>(R.id.textViewCarPrice).text = "Price:           " + "$" + car.price + " /Day"

        // Find the delete button
        val deleteButton: ImageButton = view.findViewById(R.id.buttonDelete)

        // Check if the current user is the owner of the car
        if (car.ownerId == currentUserId) {
            deleteButton.visibility = View.VISIBLE
            deleteButton.setOnClickListener {
                onDeleteClick(car.id)
            }
        } else {
            deleteButton.visibility = View.GONE
        }

        return view
    }
}
