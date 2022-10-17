package cl.uandes.pichangapp.api

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.user.UserEntity
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
            Log.d("Login", "Login: ${myUser.value}")
        }
    }
    fun registerUser(userObject: UserObject){
        viewModelScope.launch {
            val response: Response<UserEntity> = repository.registerUser(userObject)

            Log.d("Register", "Register response: ${response.body()}")
        }
    }
}