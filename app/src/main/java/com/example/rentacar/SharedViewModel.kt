package com.example.rentacar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SharedViewModel : ViewModel() {
    private val database = FirebaseDatabase.getInstance()
    private val carsRef = database.getReference("cars")

    private val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>> get() = _cars

    init {
        carsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val carsList = mutableListOf<Car>()
                for (carSnapshot in snapshot.children) {
                    val car = carSnapshot.getValue(Car::class.java)
                    if (car != null) {
                        car.id = carSnapshot.key ?: ""
                        carsList.add(car)
                    }
                }
                _cars.value = carsList
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun addCar(car: Car) {
        val newCarRef = carsRef.push()
        car.id = newCarRef.key ?: ""
        newCarRef.setValue(car)
    }

    fun deleteCar(carId: String) {
        val carRef = carsRef.child(carId)
        carRef.removeValue()
    }
}

