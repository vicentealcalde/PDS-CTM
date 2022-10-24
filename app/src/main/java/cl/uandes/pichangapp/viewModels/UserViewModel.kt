package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.database.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application, private val repository: UserRepository): AndroidViewModel(application) {

    fun getNoFriends(): LiveData<List<UserEntity>> {
        return repository.getNoFriends()
    }

    fun deleteAllNoFriends(){
        repository.deleteAllNoFriends()
    }

    fun deleteNoFriend(userId: Int){
        viewModelScope.launch {
            repository.deleteNoFriend(userId)
        }
    }

    fun addUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            //repository.addUser(user)
        }
    }

    fun login(userName:String, password:String){
        viewModelScope.launch(Dispatchers.IO) {
            //repository.getLogin(userName, password)
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