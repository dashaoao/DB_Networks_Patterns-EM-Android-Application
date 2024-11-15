package com.dashaoao.db_networks_patterns_em.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.dashaoao.db_networks_patterns_em.data.model.AvailableBouquet

@Dao
interface BouquetDao {
    @Query(
        "SELECT bouquets.bouquet_id AS bouquetId, bouquets.name AS name, " +
                "MIN(flowers.stock / bouquet_flower.quantity) AS quantity " +
                "FROM bouquets " +
                "JOIN bouquet_flower ON bouquets.bouquet_id = bouquet_flower.bouquet_id " +
                "JOIN flowers ON bouquet_flower.flower_id = flowers.flower_id " +
                "GROUP BY bouquets.bouquet_id, bouquets.name " +
                "HAVING MIN(flowers.stock >= bouquet_flower.quantity) > 0"
    )
    suspend fun getAvailableBouquets(): List<AvailableBouquet?>?
}
