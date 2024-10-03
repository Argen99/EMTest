package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.room.dao.VacancyDao
import com.example.data.local.room.db.AppDB
import com.example.data.remote.api_service.MainApiService
import com.example.data.remote.repository.MainRepositoryImpl
import com.example.domain.repository.FavoritesRepository
import com.example.domain.repository.SearchRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://drive.usercontent.google.com/"

val dataModule = module {
    singleOf(::provideRetrofit)
    singleOf(::provideOkHttpClient)
    singleOf(::provideMainApiService)
    singleOf(::MainRepositoryImpl) {
        bind<SearchRepository>()
    }
    singleOf(::MainRepositoryImpl) {
        bind<FavoritesRepository>()
    }
    singleOf(::provideRoomDB)
    singleOf(::provideVacancyDao)
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

fun provideMainApiService(retrofit: Retrofit): MainApiService {
    return retrofit.create(MainApiService::class.java)
}

fun provideRoomDB(context: Context) : AppDB {
    return Room.databaseBuilder(context, AppDB::class.java, "database.db").build()
}

fun provideVacancyDao(roomDB: AppDB): VacancyDao {
    return roomDB.vacancyDao()
}