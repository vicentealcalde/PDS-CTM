package cl.uandes.pichangapp.api

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.friend.FriendEntityMapper
import cl.uandes.pichangapp.database.friend.FriendRepository
import cl.uandes.pichangapp.database.friend.UserToFriendEntityMapper
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.database.user.UserRepository
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.models.InGamePlayer
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApiViewModel(application: Application, private val repository: Repository, private val friendRepository: FriendRepository, private val userRepository: UserRepository) : ViewModel() {
    var myResponse: MutableLiveData<Response<List<UserEntity>>> = MutableLiveData()
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

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

    fun getUserFriends(userId: Int){
        viewModelScope.launch {
            val response: Response<List<UserEntity>> = repository.getUserFriends(userId)
            response.body()?.forEach {
                friendRepository.addFriend(UserToFriendEntityMapper().mapFromCached(it))
            }

        }
    }

    fun getFriendRequests(userId: Int){
        viewModelScope.launch {
            val response: Response<List<Friend>> = repository.getFriendRequests(userId)
            Log.d("Friends","Requests Response: ${response.body()}")
            response.body()?.forEach {
                friendRepository.addFriend(FriendEntityMapper().mapToCached(it))
            }
        }
    }

    fun addFriend(sender: Int, receiver:Int, status: Int){
        viewModelScope.launch {
            val response: Response<Friend> = repository.addFriend(sender, receiver, status)

            Log.d("Friends","Add Friend Response: ${response.body()}")
        }
    }

    fun acceptFriend(sender: Int, status: Int){
        viewModelScope.launch {
            val response: Response<Friend> = repository.acceptFriend(sender, status)

            Log.d("Friends","Accept Friend Response: ${response.body()}")
        }
    }

    fun getUserNoFriends(userId: Int){
        viewModelScope.launch {
            val response: Response<List<UserEntity>> = repository.getUserNoFriends(userId)
            Log.d("No Friends","Response: ${response.body()}")
            response.body()?.forEach {
                userRepository.addUser(it)
            }
        }
    }
    fun getPlayersOfLobby(lobbyId: Int){
        viewModelScope.launch {
            val response: Response<List<InGamePlayer>> = repository.getPlayersOfLobby(lobbyId)
            Log.d("Lobby","Lobby InGame: ${response.body()}")
        }
    }
    fun createLobby(lobbyObject: AddLobbyObject){
        viewModelScope.launch {
            val response: Response<LobbyEntity> = repository.createLobby(lobbyObject)
        }
    }
    fun getUserLobbies(userId: Int){
        viewModelScope.launch {
            val response: Response<List<InGamePlayer>> = repository.getUserLobbies(userId)
        }
    }
}