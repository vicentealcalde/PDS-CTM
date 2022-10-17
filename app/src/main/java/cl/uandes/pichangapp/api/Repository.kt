package cl.uandes.pichangapp.api

import cl.uandes.pichangapp.database.user.UserEntity
import retrofit2.Response

class Repository {

    suspend fun getLogin(userObject: UserObject): Response<List<UserEntity>> {
        return RetrofitInstance.api.getLogin(userObject.userName, userObject.password)
    }

}