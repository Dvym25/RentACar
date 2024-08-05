package com.example.rentacar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class CarAdapter(
    context: Context,
    private val carList: List<Car>,
    private val onDeleteClick: (String) -> Unit
) : ArrayAdapter<Car>(context, 0, carList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_car, parent, false)
        val car = carList[position]

        view.findViewById<TextView>(R.id.textViewCarType).text = car.type
        view.findViewById<TextView>(R.id.textViewCarSeats).text = car.seats
        view.findViewById<TextView>(R.id.textViewCarColor).text = car.color
        view.findViewById<TextView>(R.id.textViewCarCompany).text = car.company
        view.findViewById<TextView>(R.id.textViewCarPrice).text = car.price

        view.findViewById<ImageButton>(R.id.buttonDelete).setOnClickListener {
            onDeleteClick(car.id)
        }

        return view
    }
}



