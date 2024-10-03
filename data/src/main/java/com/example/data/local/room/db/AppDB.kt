package com.example.data.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local.room.converters.Converters
import com.example.data.local.room.dao.VacancyDao
import com.example.data.local.room.entity.VacancyEntity

@Database(entities = [VacancyEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDB: RoomDatabase() {
    abstract fun vacancyDao(): VacancyDao
}