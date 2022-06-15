package com.example.apprestaurante.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.apprestaurante.data.RestauranteDatabase
import com.example.apprestaurante.model.Restaurante
import com.example.apprestaurante.repository.RestauranteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RestauranteViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Restaurante>>

    private val repository: RestauranteRepository

    init {
        val restauranteDao = RestauranteDatabase.getDatabase(application).restauranteDao()
        repository = RestauranteRepository(restauranteDao)
        getAllData = repository.getAllData
    }

    fun addRestaurante (restaurante: Restaurante) {
        viewModelScope.launch (Dispatchers.IO) {  repository.addRestaurante(restaurante)}
    }

    fun updateRestaurante (restaurante: Restaurante) {
        viewModelScope.launch (Dispatchers.IO) {  repository.updateRestaurante(restaurante) }
    }

    fun deleteRestaurante (restaurante: Restaurante) {
        viewModelScope.launch (Dispatchers.IO) {  repository.deleteRestaurante(restaurante)}
    }

}