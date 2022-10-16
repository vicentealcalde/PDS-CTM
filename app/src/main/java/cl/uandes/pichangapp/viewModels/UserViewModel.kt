package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.AppDatabase
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.database.user.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val repository: UsersRepository
    val users: LiveData<List<UserEntity>>


    init{
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository = UsersRepository(userDao)
        users = repository.getAllUsers
    }


    fun addUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun login(userName:String, password:String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getLogin(userName, password)
        }
    }

    fun debugUsers(){
        val debugUsers = listOf(
            UserEntity(0,"a","a",0),
            UserEntity(1,"","",2)
        )
        debugUsers.forEach{
            print("Adding User: $it")
            addUser(it)
        }
    }
}