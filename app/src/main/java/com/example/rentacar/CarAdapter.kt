package com.example.rentacar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class CarAdapter(private val context: Context, private val carList: List<Car>) : BaseAdapter() {

    override fun getCount(): Int = carList.size

    override fun getItem(position: Int): Any = carList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val car = getItem(position) as Car
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_car, parent, false)

        val typeOfCar: TextView = view.findViewById(R.id.typeOfCar)
        val numberOfSeats: TextView = view.findViewById(R.id.numberOfSeats)
        val carColor: TextView = view.findViewById(R.id.carColor)
        val carCompany: TextView = view.findViewById(R.id.carCompany)
        val pricePerDay: TextView = view.findViewById(R.id.pricePerDay)
        val bookNowButton: Button = view.findViewById(R.id.bookNowButton)

        typeOfCar.text = car.typeOfCar
        numberOfSeats.text = car.numberOfSeats
        carColor.text = car.carColor
        carCompany.text = car.carCompany
        pricePerDay.text = car.pricePerDay

        bookNowButton.setOnClickListener {
            // Handle book now button click
        }

        return view
    }
}
