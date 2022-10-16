package cl.uandes.pichangapp.API

import retrofit2.Response

class Repository {

    suspend fun getLogin(userObject: UserObject): Response<UserObject> {
        return RetrofitInstance.api.getLogin(userObject)
    }

}