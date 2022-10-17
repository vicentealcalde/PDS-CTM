package cl.uandes.pichangapp.api

import retrofit2.Response

class Repository {

    suspend fun getLogin(userObject: UserObject): Response<UserObject> {
        return RetrofitInstance.api.getLogin(userObject)
    }

}