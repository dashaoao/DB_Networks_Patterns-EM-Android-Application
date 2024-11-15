package com.dashaoao.db_networks_patterns_em.patterns.factory

import com.dashaoao.db_networks_patterns_em.patterns.Car

interface CarFactory {
    fun createCar(): Car
}
