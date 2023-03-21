package id.insinyurdigital.doi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
<<<<<<< HEAD
=======
import id.insinyurdigital.doi.repository.Repository
import id.insinyurdigital.doi.repository.RepositoryImpl
>>>>>>> Insyaallah selesai karena modal saya hanya pengetahuan
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
<<<<<<< HEAD
    fun provideRepository(repositoryImpl: RepositoryImpl): Repository =
        repositoryImpl
=======
    fun provideRepository(repositoryImpl: RepositoryImpl): Repository = repositoryImpl
>>>>>>> Insyaallah selesai karena modal saya hanya pengetahuan
}