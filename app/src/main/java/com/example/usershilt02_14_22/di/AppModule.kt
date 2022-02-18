package com.example.usershilt02_14_22.di

import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT
import com.example.usershilt02_14_22.network.repository.PostsRepository
import com.example.usershilt02_14_22.network.repository.TodosRepository
import com.example.usershilt02_14_22.network.repository.UsersRepository
import com.example.usershilt02_14_22.service.PostsService
import com.example.usershilt02_14_22.service.TodosService
import com.example.usershilt02_14_22.service.UsersService
import com.example.usershilt02_14_22.utils.BASE_URL
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMoshi() = Moshi.Builder().build()

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().connectTimeout(com.example.usershilt02_14_22.utils.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(com.example.usershilt02_14_22.utils.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(com.example.usershilt02_14_22.utils.TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun providesPostService(retrofit: Retrofit): PostsService {
        return retrofit.create(PostsService::class.java)
    }

    @Provides
    @Singleton
    fun providesPostRepository(postsService: PostsService): PostsRepository {
        return PostsRepository(postsService)
    }
    @Provides
    @Singleton
    fun providesTodoService(retrofit: Retrofit): TodosService {
        return retrofit.create(TodosService::class.java)
    }

    @Provides
    @Singleton
    fun providesTodoRepository(todosService: TodosService): TodosRepository {
        return TodosRepository(todosService)
    }
    @Provides
    @Singleton
    fun providesUserService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    @Singleton
    fun providesUserRepository(usersService: UsersService): UsersRepository {
        return UsersRepository(usersService)
    }

}