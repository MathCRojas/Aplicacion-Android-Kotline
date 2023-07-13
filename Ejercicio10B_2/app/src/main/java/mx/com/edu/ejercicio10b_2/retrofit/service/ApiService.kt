package mx.com.edu.ejercicio10b_2.retrofit.service

import mx.com.edu.ejercicio10b_2.retrofit.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET
    suspend fun getAll(@Url url: String): Response<List<User>>

    @POST
    suspend fun create(@Url url: String, @Body usuario: User, @Header("Authorization") token: String): Response<User>

    @GET
    suspend fun getOne(@Url url: String, @Header("Authorization") token: String): Response<User>

}