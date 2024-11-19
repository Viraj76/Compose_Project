import com.appsv.composeproject.pagination_practice.HomeViewModel
import com.appsv.composeproject.pagination_practice.data.remote.AirlineAPI
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//package com.appsv.composeproject.pagination_practice.data
//
//import com.appsv.composeproject.pagination_practice.data.remote.AirlineAPI
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//
//@InstallIn(SingletonComponent::class)
//@Module
//object DataModule {
//
//    @Provides

//}

fun provideAirlineAPI() : AirlineAPI{
    return Retrofit.Builder()
        .baseUrl("https://api.instantwebtools.net/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AirlineAPI::class.java)
}

val dataModules = module {
    single { provideAirlineAPI() }
    viewModel { HomeViewModel() }
}