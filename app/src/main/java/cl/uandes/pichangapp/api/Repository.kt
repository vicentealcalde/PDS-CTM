package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.database.user.UserEntity
import retrofit2.Response

class Repository {

    suspend fun getLogin(userObject: UserObject): Response<List<UserEntity>> {
        return RetrofitInstance.api.getLogin(userObject.userName, userObject.password)
    }
    suspend fun registerUser(username: String, password:String, games: Int): Response<UserEntity>{
        return RetrofitInstance.api.registerUser(RegisterUserObject(username, password, games))
    }

    suspend fun getUserFriends(userId: Int): Response<List<UserEntity>>{
        return RetrofitInstance.api.getUserFriends(userId)
    }
}