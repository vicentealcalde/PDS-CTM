package cl.uandes.pichangapp.api

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerEntityMapper
import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerRepository
import cl.uandes.pichangapp.database.friend.FriendEntityMapper
import cl.uandes.pichangapp.database.friend.FriendRepository
import cl.uandes.pichangapp.database.friend.UserToFriendEntityMapper
import cl.uandes.pichangapp.database.lobby.InGamePlayerToLobbyEntityMapper
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.lobby.LobbyEntityMapper
import cl.uandes.pichangapp.database.lobby.LobbyRepository
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.database.user.UserRepository
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.models.InGamePlayer
import cl.uandes.pichangapp.models.Lobby
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApiViewModel(application: Application,
                   private val repository: Repository,
                   private val friendRepository: FriendRepository,
                   private val userRepository: UserRepository,
                   private val lobbyRepository: LobbyRepository,
                   private val inGamePlayerRepository: InGamePlayerRepository) : ViewModel() {
    var myResponse: MutableLiveData<Response<List<UserEntity>>> = MutableLiveData()
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    //*****************************************
    //*************  Users Calls  *************
    //*****************************************
    fun getLogin(userObject: UserObject){
        viewModelScope.launch {
            val response: Response<List<UserEntity>> = repository.getLogin(userObject)
            myResponse.value = response
        }
    }
    fun registerUser(username: String, password:String){
        viewModelScope.launch {
            val response: Response<UserEntity> = repository.registerUser(username, password, 0)

            Log.d("Register", "Register response: ${response.body()}")
        }
    }

    //*****************************************
    //************  Friends Calls  ************
    //*****************************************
    // GET accepted friends from API
    fun getUserFriends(userId: Int){
        viewModelScope.launch {
            val response: Response<List<UserEntity>> = repository.getUserFriends(userId)
            response.body()?.forEach {
                friendRepository.addFriend(UserToFriendEntityMapper().mapFromCached(it))
            }

        }
    }

    // GET Requests from Api
    fun getFriendRequests(userId: Int){
        viewModelScope.launch {
            val response: Response<List<Friend>> = repository.getFriendRequests(userId)
            Log.d("Friends","Requests Response: ${response.body()}")
            response.body()?.forEach {
                friendRepository.addFriend(FriendEntityMapper().mapToCached(it))
            }
        }
    }

    // Send Friend Request: sender is current_user, status = 0 for 'pending' Friend Request
    fun addFriend(sender: Int, receiver:Int, status: Int){
        viewModelScope.launch {
            val response: Response<Friend> = repository.addFriend(sender, receiver, status)

            Log.d("Friends","Add Friend Response: ${response.body()}")
        }
    }

    // Accept Friend Requests, res = 1 Accept, res = 0 Reject
    fun acceptFriend(id: Int, res: Int) {
        viewModelScope.launch {
            val response: Response<Friend> = repository.acceptFriend(id, res)

            Log.d("Friends","Accept Friend Response: ${response.body()}")
        }
    }

    // GET users that are not friends of current_user
    fun getUserNoFriends(userId: Int){
        viewModelScope.launch {
            val response: Response<List<UserEntity>> = repository.getUserNoFriends(userId)
            Log.d("No Friends","Response: ${response.body()}")
            response.body()?.forEach {
                userRepository.addUser(it)
            }
        }
    }

    //*****************************************
    //*************  Lobby Calls  *************
    //*****************************************
    // GET InGamePlayers of specific lobby
    fun getPlayersOfLobby(lobbyId: Int){
        viewModelScope.launch {
            val response: Response<List<InGamePlayer>> = repository.getPlayersOfLobby(lobbyId)
            Log.d("Lobby","Lobby InGames: ${response.body()}")
        }
    }
    // GET Users from Lobby, necessary for usernames of lobby users
    fun getUsersOfLobby(lobbyId: Int){
        viewModelScope.launch {
            val response: Response<List<UserEntity>> = repository.getUsersOfLobby(lobbyId)
            Log.d("Lobby","Lobby Users: ${response.body()}")
        }
    }
    // POST to create Lobby
    fun createLobby(lobbyObject: AddLobbyObject){
        viewModelScope.launch {
            val response: Response<LobbyEntity> = repository.createLobby(lobbyObject)
        }
    }
    // GET all lobbies from current_user
    fun getUserLobbies(userId: Int){
        viewModelScope.launch {
            val response: Response<List<Lobby>> = repository.getUserLobbies(userId)
            Log.d("Lobby", "Lobby GET Response: ${response.body()}")

            response.body()?.forEach{
                lobbyRepository.addLobby(LobbyEntityMapper().mapToCached(it))
            }
        }
    }

    fun getUserPendingLobbies(userId: Int){
        viewModelScope.launch {
            val response: Response<List<InGamePlayer>> = repository.getUserPendingLobbies(userId)
            Log.d("Lobby","Lobby Pending Lobbies: ${response.body()}")

            response.body()?.forEach{
                lobbyRepository.addLobby(
                    LobbyEntityMapper().mapToCached(InGamePlayerToLobbyEntityMapper().mapFromCached(it))
                )
            }
        }
    }

    //************************************************
    //*************  InGamePlayer Calls  *************
    //************************************************
    fun getInGamePlayersFromLobby(lobbyId: Int){
        viewModelScope.launch {
            val response: Response<List<InGamePlayer>> = repository.getPlayersOfLobby(lobbyId)

            response.body()?.forEach {
                inGamePlayerRepository.addInGamePlayer(InGamePlayerEntityMapper().mapFromCached(it))
            }
        }
    }

}