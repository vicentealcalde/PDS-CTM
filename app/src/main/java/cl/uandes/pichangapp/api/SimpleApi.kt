package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.models.InGamePlayer
import cl.uandes.pichangapp.models.Lobby
import cl.uandes.pichangapp.models.UserStats
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    //*****************************************
    //*************  Users Calls  *************
    //*****************************************
    @GET("login")
    suspend fun getLogin(
        @Query("username") user: String,
        @Query("password") password: String
    ):Response<List<UserEntity>>

    @POST("users")
    suspend fun registerUser(
        @Body user: RegisterUserObject
    ): Response<UserEntity>

    @POST("users_stats")
    suspend fun createUserStats(
        @Body stats: UserStats
    ): Response<UserStats>

    @POST("igps")
    suspend fun createUserIGP(
        @Body igp: AddIGPObject
    ): Response<InGamePlayer>

    //*****************************************
    //************  Friends Calls  ************
    //*****************************************
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
    @POST("accept_friends")
    suspend fun acceptFriend(
        @Query("id") id: Int,
        @Query("res") res: Int
    ): Response<Friend>

    @GET("users_username")
    suspend fun find_user(
        @Query("id") id : Int
    ): Response<String>

    @GET("search_friends/{id}")
    suspend fun getUserNoFriends(
        @Path("id") id : Int
    ): Response<List<UserEntity>>


    //*****************************************
    //*************  Lobby Calls  *************
    //*****************************************
    // Get the IGPs from a Lobby
    @GET("lobbies_igp/{id}")
    suspend fun getPlayersOfLobby(
        @Path("id") id : Int
    ): Response<List<InGamePlayer>>

    // Users per Lobby, necessary to get the username of the members
    @GET("users_per_lobby/{id}")
    suspend fun getUsersOfLobby(
        @Path("id") id: Int
    ): Response<List<UserEntity>>

    // Create Lobby API call
    @POST("lobbies")
    suspend fun createLobby(
        @Body lobby: AddLobbyObject
    ): Response<LobbyEntity>

    // Accept Lobby Invite
    @POST("response_igps")
    suspend fun acceptLobby(
        @Query("id") id: Int,
        @Query("res") res: Int
    ): Response<InGamePlayer>

    // Get User's Lobbies
    @GET("active_lobbies/{id}")
    suspend fun getUserLobbies(
        @Path("id") id : Int
    ): Response<List<Lobby>>

    @GET("invites_pending/{id}")
    suspend fun getUserPendingLobbies(
        @Path("id") id: Int
    ): Response<List<InGamePlayer>>


    //*****************************************
    //*************  Game  Calls  *************
    //*****************************************
    @GET("user_igp/{id}")
    suspend fun getIGPOfUser(
        @Path("id") id: Int
    ):Response<List<InGamePlayer>>

    @GET("trow_dices")
    suspend fun throwDices(
        @Query("id") id: Int
    ): Response<List<Int>>

    @POST("turn")
    suspend fun sendTurn(
        @Query("id") id: Int,
        @Body turn: List<Int>
    ): Response<String>

    @POST("user_stats_params")
    suspend fun updateUserStats(
        @Query("id") id: Int
    ): Response<UserStats>

}