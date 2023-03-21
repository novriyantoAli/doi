package id.insinyurdigital.doi.repository

import id.insinyurdigital.doi.data.model.LoginRequest
import id.insinyurdigital.doi.data.network.RemoteService
import id.insinyurdigital.doi.domain.DataState
import id.insinyurdigital.doi.domain.model.UserDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteService: RemoteService) : Repository {
    override suspend fun postLogin(
        username: String,
        password: String
    ): Flow<DataState<UserDetail>> = flow {
        emit(DataState.Loading)
        try {
            val postLogin = remoteService.login(LoginRequest(username, password))
            if(postLogin.error != null) {
                emit(DataState.Error(Exception(postLogin.error)))
            } else {
                emit(DataState.Success(postLogin.toUserDetail()))
            }
        } catch (e: Exception) { emit(DataState.Error(e)) }
    }
}