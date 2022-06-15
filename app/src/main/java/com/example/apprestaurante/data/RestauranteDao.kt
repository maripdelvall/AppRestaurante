package com.example.apprestaurante.data
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.apprestaurante.model.Restaurante

@Dao
interface RestauranteDao {

    @Query("SELECT * FROM RESTAURANTE")
    fun getAllData(): LiveData<List<Restaurante>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRestaurante(restaurante: Restaurante)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateRestaurante(restaurante: Restaurante)

    @Delete
    suspend fun deleteRestaurante(restaurante: Restaurante)
}
