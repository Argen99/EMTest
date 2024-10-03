package com.example.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.room.entity.VacancyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VacancyDao {
    @Query("SELECT * FROM vacancies")
    fun getAll(): Flow<List<VacancyEntity>>

    @Query("SELECT COUNT(*) FROM vacancies WHERE id = :id")
    suspend fun isVacancyExists(id: String): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vacancy: VacancyEntity)

    @Delete
    suspend fun delete(vacancy: VacancyEntity)
}