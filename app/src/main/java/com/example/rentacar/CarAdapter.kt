// CarAdapter.kt
package com.example.rentacar

import android.content.Context
import android.content.Intent
import android.net.Uri
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

        val currentUserId = FirebaseAuth.getInstance().uid
        Log.d("CarAdapter", "Current logged in ID: $currentUserId")
        Log.d("CarAdapter", "POST Owner ID: ${car.ownerId}")

        view.findViewById<TextView>(R.id.textViewCarType).text = "Type:           " + car.type
        view.findViewById<TextView>(R.id.textViewCarSeats).text = "Seats:          " + car.seats
        view.findViewById<TextView>(R.id.textViewCarColor).text = "Colors:         " + car.color
        view.findViewById<TextView>(R.id.textViewCarCompany).text = "Company:   " + car.company
        view.findViewById<TextView>(R.id.textViewCarPrice).text = "Price:           " + "$" + car.price + " /Day"
        view.findViewById<TextView>(R.id.textViewContactNumber).text = "Contact:      " + car.contact

        view.findViewById<TextView>(R.id.textViewContactNumber).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${car.contact}")
            }
            context.startActivity(intent)
        }

        val deleteButton: ImageButton = view.findViewById(R.id.buttonDelete)
        deleteButton.setOnClickListener {
            onDeleteClick(car.id)
        }

        return view
    }
}
