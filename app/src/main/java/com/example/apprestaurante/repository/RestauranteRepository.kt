package com.example.apprestaurante.repository

import androidx.lifecycle.LiveData
import com.example.apprestaurante.data.RestauranteDao
import com.example.apprestaurante.model.Restaurante

class RestauranteRepository(private val restauranteDao: RestauranteDao) {

    val getAllData: LiveData<List<Restaurante>> = restauranteDao.getAllData()

    suspend fun addRestaurante(restaurante: Restaurante){
        restauranteDao.addRestaurante(restaurante)
    }

    suspend fun updateRestaurante(restaurante: Restaurante){
        restauranteDao.updateRestaurante(restaurante)
    }

    suspend fun deleteRestaurante(restaurante: Restaurante){
        restauranteDao.deleteRestaurante(restaurante)
    }


}