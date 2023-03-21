package id.insinyurdigital.doi.data.model

import com.google.gson.annotations.SerializedName
import id.insinyurdigital.doi.domain.model.UserDetail

data class LoginResponse(
    @SerializedName("error")
    val error: String?,
    @SerializedName("token")
    val token: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String
) { fun toUserDetail(): UserDetail { return UserDetail(token, id, username) } }
