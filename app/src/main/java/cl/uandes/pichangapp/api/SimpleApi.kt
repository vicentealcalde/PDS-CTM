package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.models.InGamePlayer
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
    // Friends Request received
    @GET("friend_requests/{id}")
    suspend fun getFriendRequests(
        @Path("id") id : Int
    ): Response<List<Friend>>

    // Friends of User
    @GET("user_friends/{id}")
    suspend fun getUserFriends(
        @Path("id") id : Int
    ): Response<List<UserEntity>>

    // Add Friend
    @POST("friends")
    suspend fun addFriend(
        @Body request: AddFriendObject
    ): Response<Friend>

    // Accept Friend
    @PUT("friends/{id}")
    suspend fun acceptFriend(
        @Path("id") id : Int,
        @Query("res") res: Int
    ): Response<Friend>

    @GET("search_friends/{id}")
    suspend fun getUserNoFriends(
        @Path("id") id : Int
    ): Response<List<UserEntity>>
    
    //Lobby Calls
    @GET("lobbies_igp/{id}")
    suspend fun getInGamesOfLobby(
        @Path("id") id : Int
    ): Response<List<InGamePlayer>>

    @POST("lobbies")
    suspend fun createLobby(
        @Body lobby: AddLobbyObject
    ): Response<LobbyEntity>

}