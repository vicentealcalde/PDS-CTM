package cl.uandes.pichangapp.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApiViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<UserObject>> = MutableLiveData()
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    fun getLogin(userObject: UserObject){
        viewModelScope.launch {
            val response: Response<UserObject> = repository.getLogin(userObject)
            myResponse.value = response
        }
    }
}