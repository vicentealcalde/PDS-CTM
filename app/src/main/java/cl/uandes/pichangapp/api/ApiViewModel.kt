package cl.uandes.pichangapp.api

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.currentUser
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.myFriendRequests
import cl.uandes.pichangapp.myFriends
import cl.uandes.pichangapp.myNotFriends
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApiViewModel(application: Application, private val repository: Repository) : ViewModel() {
    val myUser: MutableLiveData<UserEntity> = MutableLiveData()
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    fun getLogin(userObject: UserObject){
        viewModelScope.launch {
            val response: Response<List<UserEntity>> = repository.getLogin(userObject)
            myUser.value = response.body()?.get(0)
            currentUser = response.body()?.get(0)
            myFriends.clear()
            myNotFriends.clear()
            currentUser?.id?.let { getUserFriends(it.toInt()) }
            currentUser?.id?.let { getFriendRequests(it.toInt()) }
            currentUser?.id?.let { getUserNoFriends(it.toInt()) }
            Log.d("Login", "Login: ${myUser.value}")
            Log.d("Login", "Login: ${currentUser}")
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
            Log.d("Friends","Response: ${response.body()}")
            response.body()?.forEach {
                it.username?.let { it1 -> myFriends.add(it1) }
            }

            Log.d("Friends","myFriends: $myFriends")
        }
    }

    fun getFriendRequests(userId: Int){
        viewModelScope.launch {
            val response: Response<List<Friend>> = repository.getFriendRequests(userId)
            Log.d("Friends","Response: $response")
            myFriendRequests.clear()
            response.body()?.forEach {
                myFriendRequests.add(it)
            }

            Log.d("Friends","Requests: $myFriendRequests")
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
                it.username?.let { it1 -> myNotFriends.add(it1) }
            }

            Log.d("No Friends","mynoFriends: $myNotFriends")
        }
    }
}