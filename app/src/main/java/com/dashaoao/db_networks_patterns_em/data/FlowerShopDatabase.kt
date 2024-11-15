package com.dashaoao.db_networks_patterns_em.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dashaoao.db_networks_patterns_em.data.dao.BouquetDao
import com.dashaoao.db_networks_patterns_em.data.dao.BouquetFlowerDao
import com.dashaoao.db_networks_patterns_em.data.model.Bouquet
import com.dashaoao.db_networks_patterns_em.data.model.BouquetFlower
import com.dashaoao.db_networks_patterns_em.data.model.Flower

@Database(entities = [Bouquet::class, Flower::class, BouquetFlower::class], version = 2, exportSchema = false)
abstract class FlowerShopDatabase : RoomDatabase() {

    abstract fun bouquetDao(): BouquetDao
    abstract fun bouquetFlowerDao(): BouquetFlowerDao

    companion object {
        private var INSTANCE: FlowerShopDatabase? = null
        private val LOCK = Any()
        private const val DATABASE_NAME = "bouquets.db"

        fun getInstance(context: Context): FlowerShopDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    FlowerShopDatabase::class.java,
                    DATABASE_NAME
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()

                INSTANCE = db
                return db
            }
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE bouquets ADD COLUMN design TEXT DEFAULT 'undefined' NOT NULL")
                db.execSQL("ALTER TABLE flowers ADD COLUMN country_of_manufacture TEXT DEFAULT 'undefined' NOT NULL")
            }
        }
    }
}
