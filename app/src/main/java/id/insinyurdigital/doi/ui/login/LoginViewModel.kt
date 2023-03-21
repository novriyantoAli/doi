package id.insinyurdigital.doi.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.insinyurdigital.doi.domain.DataState
import id.insinyurdigital.doi.domain.model.UserDetail
import id.insinyurdigital.doi.repository.Repository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _dataState = MutableLiveData<DataState<UserDetail>>()
    val dataState: LiveData<DataState<UserDetail>>
        get() = _dataState

    private fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    fun postLogin(mainStateEvent: MainStateEvent, username: String, password: String){
        viewModelScope.launch {
            when(mainStateEvent){
                MainStateEvent.GetMemberDetail -> {
                    repository.postLogin(username, md5(password))
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

    sealed class MainStateEvent {
        object GetMemberDetail: MainStateEvent()
    }
}