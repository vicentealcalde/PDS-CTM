package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.models.Friend
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SimpleApi {

    //User Calls
    @GET("login")
    suspend fun getLogin(
        @Body user: UserObject
    ):Response<UserObject>
    @GET("")
    suspend fun

    //Friends Calls
    @GET("friends")
    suspend fun getAllFriends(): Response<List<Friend>>

    @GET("friends/{id}")
    suspend fun getUserFriends(
        @Path("roomName") roomName : String
    )
}