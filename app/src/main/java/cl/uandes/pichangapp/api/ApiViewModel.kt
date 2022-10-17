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
            currentUser?.id?.let { getUserFriends(it.toInt()) }
            currentUser?.id?.let { getFriendRequests(it.toInt()) }
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

            response.body()?.forEach {
                it.id?.let { it1 -> myFriendRequests.add(it1.toInt()) }
            }

            Log.d("Friends","Requests: $myFriendRequests")
        }
    }
}