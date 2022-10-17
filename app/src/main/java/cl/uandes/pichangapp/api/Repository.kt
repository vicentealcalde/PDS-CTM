package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.database.user.UserEntity
import retrofit2.Response

class Repository {

    suspend fun getLogin(userObject: UserObject): Response<List<UserEntity>> {
        return RetrofitInstance.api.getLogin(userObject.userName, userObject.password)
    }
    suspend fun registerUser(userObject: UserObject): Response<UserEntity>{
        return RetrofitInstance.api.registerUser(userObject.userName, userObject.password)
    }

}