package com.example.apprestaurante.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apprestaurante.model.Restaurante

@Database(entities=[Restaurante::class], version=1, exportSchema = false)
    abstract class RestauranteDatabase: RoomDatabase() {
    abstract fun restauranteDao() : RestauranteDao

    companion object {
        @Volatile
        private var INSTANCE: RestauranteDatabase? = null

        fun getDatabase(context: android.content.Context) : RestauranteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestauranteDatabase::class.java,
                    "restaurante_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}