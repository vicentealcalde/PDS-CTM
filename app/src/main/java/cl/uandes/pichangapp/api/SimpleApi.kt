package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.models.Friend
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    //User Calls
    @GET("login")
    suspend fun getLogin(
        @Query("username") user: String,
        @Query("password") password: String
    ):Response<List<UserEntity>>
    @POST("users")
    suspend fun registerUser(
        @Body user: RegisterUserObject
    ): Response<UserEntity>

    @GET("users")
    suspend fun getAllUsers(): Response<List<UserObject>>


    //Friends Calls
    @GET("friends")
    suspend fun getAllFriends(): Response<List<Friend>>

    @GET("search_friends/{id}")
    suspend fun getUserFriends(
        @Path("id") id : Int
    ): Response<List<UserEntity>>
}