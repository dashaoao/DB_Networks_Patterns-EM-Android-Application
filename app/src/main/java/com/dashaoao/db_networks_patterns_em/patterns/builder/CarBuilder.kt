package com.dashaoao.db_networks_patterns_em.patterns.builder

import com.dashaoao.db_networks_patterns_em.patterns.Car

class CarBuilder {
    private var make: String = ""
    private var model: String = ""
    private var year: Int = 0
    private var color: String = ""

    fun setMake(make: String) = apply { this.make = make }
    fun setModel(model: String) = apply { this.model = model }
    fun setYear(year: Int) = apply { this.year = year }
    fun setColor(color: String) = apply { this.color = color }

    fun build(): Car {
        return Car(make, model, year, color)
    }
}
