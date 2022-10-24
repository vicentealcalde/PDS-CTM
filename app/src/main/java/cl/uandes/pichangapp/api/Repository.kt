package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.models.InGamePlayer
import cl.uandes.pichangapp.models.Lobby
import cl.uandes.pichangapp.models.UserStats
import retrofit2.Response

class Repository {

    suspend fun getLogin(userObject: UserObject): Response<List<UserEntity>> {
        return RetrofitInstance.api.getLogin(userObject.userName, userObject.password)
    }
    suspend fun registerUser(username: String, password:String, games: Int): Response<UserEntity>{
        return RetrofitInstance.api.registerUser(RegisterUserObject(username, password, games))
    }
    suspend fun createUserStats(stats: UserStats): Response<UserStats> {
        return RetrofitInstance.api.createUserStats(stats)
    }
    suspend fun createUserIGP(igp: AddIGPObject): Response<InGamePlayer> {
        return RetrofitInstance.api.createUserIGP(igp)
    }
    suspend fun getUserFriends(userId: Int): Response<List<UserEntity>>{
        return RetrofitInstance.api.getUserFriends(userId)
    }
    suspend fun getFriendRequests(userId: Int): Response<List<Friend>>{
        return RetrofitInstance.api.getFriendRequests(userId)
    }
    suspend fun addFriend(sender: Int, receiver: Int, status: Int): Response<Friend>{
        return RetrofitInstance.api.addFriend(AddFriendObject(sender, receiver, status))
    }

    suspend fun find_user(lobbyId:Int): Response<String> {
        return RetrofitInstance.api.find_user(lobbyId)
    }
    suspend fun acceptFriend(id: Int, res: Int): Response<Friend>{
        return RetrofitInstance.api.acceptFriend(id, res)
    }
    suspend fun  getUserNoFriends(userId: Int): Response<List<UserEntity>>{
        return RetrofitInstance.api.getUserNoFriends(userId)
    }
    suspend fun getPlayersOfLobby(lobbyId: Int): Response<List<InGamePlayer>>{
        return RetrofitInstance.api.getPlayersOfLobby(lobbyId)
    }
    suspend fun getUsersOfLobby(lobbyId:Int): Response<List<UserEntity>> {
        return RetrofitInstance.api.getUsersOfLobby(lobbyId)
    }
    suspend fun createLobby(lobbyObject: AddLobbyObject): Response<LobbyEntity>{
        return RetrofitInstance.api.createLobby(lobbyObject)
    }
    suspend fun getUserLobbies(userId: Int): Response<List<Lobby>> {
        return RetrofitInstance.api.getUserLobbies(userId)
    }
    suspend fun getUserPendingLobbies(userId: Int): Response<List<InGamePlayer>> {
        return RetrofitInstance.api.getUserPendingLobbies(userId)
    }
    suspend fun getIGPOfUser(userId: Int): Response<List<InGamePlayer>> {
        return RetrofitInstance.api.getIGPOfUser(userId)
    }
    suspend fun throwDices(IGPid: Int): Response<List<Int>> {
        return RetrofitInstance.api.throwDices(IGPid)
    }
    suspend fun sendTurn(igpId: Int, turn: List<Int>): Response<String> {
        return RetrofitInstance.api.sendTurn(igpId, turn)
    }
    suspend fun updateUserStats(userId: Int): Response<UserStats> {
        return RetrofitInstance.api.updateUserStats(userId)
    }
}