package com.dashaoao.db_networks_patterns_em.patterns.factory

import com.dashaoao.db_networks_patterns_em.patterns.Car
import com.dashaoao.db_networks_patterns_em.patterns.builder.CarBuilder

class HondaFactory : CarFactory {
    override fun createCar(): Car {
        return CarBuilder()
            .setMake("Honda")
            .setModel("Civic")
            .setYear(2022)
            .setColor("Red")
            .build()
    }
}
