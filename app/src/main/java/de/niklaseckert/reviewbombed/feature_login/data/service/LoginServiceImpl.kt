package de.niklaseckert.reviewbombed.feature_login.data.service

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_login.data.remote.LoginApi
import de.niklaseckert.reviewbombed.feature_login.data.remote.dto.UserResponse
import de.niklaseckert.reviewbombed.feature_login.domain.model.User
import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Credentials
import retrofit2.HttpException
import retrofit2.awaitResponse
import java.io.IOException

class LoginServiceImpl(
    private val api: LoginApi
): LoginService {

    override fun login(username: String, password: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())

//        val profile = dao.getProfileById(profileId)?.toProfile()
//        emit(Resource.Loading(profile))
        /* TODO("LOAD CREDENTIALS FROM DATASTORE") */
        val creds = Credentials.basic(username = username, password = password)

        try {
            val userResponse = api.login(creds).awaitResponse()
            if (userResponse.code() == 401) {
                emit(Resource.Error(
                    message = "Unauthorized"
                ))
            } else {
                emit(Resource.Success(
                    data = userResponse.body()?.toUser()
                ))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = null
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = null
            ))
        }
    }
}