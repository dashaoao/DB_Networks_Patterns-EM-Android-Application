package com.dashaoao.db_networks_patterns_em.patterns.factory

import com.dashaoao.db_networks_patterns_em.patterns.Car
import com.dashaoao.db_networks_patterns_em.patterns.builder.CarBuilder

class ToyotaFactory : CarFactory {
    override fun createCar(): Car {
        return CarBuilder()
            .setMake("Toyota")
            .setModel("Camry")
            .setYear(2021)
            .setColor("Blue")
            .build()
    }
}
