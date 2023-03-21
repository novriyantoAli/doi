package id.insinyurdigital.doi.data

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    var userSession: SharedPreferences =
        context.getSharedPreferences("userSessionData", Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor = userSession.edit()

<<<<<<< HEAD

    fun createLoginSession(id: String, name: String, mobile: String, isRemOn: Boolean) {
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_ID, id)
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_MOBILE, mobile)
=======
    fun createLoginSession(id: Int, name: String, token: String, isRemOn: Boolean) {
        editor.putBoolean(IS_LOGIN, true)
        editor.putInt(KEY_ID, id)
        editor.putString(KEY_USERNAME, name)
        editor.putString(KEY_TOKEN, token)
>>>>>>> Insyaallah selesai karena modal saya hanya pengetahuan
        editor.putBoolean(KEY_REMEMBER_ME, isRemOn)

        editor.commit()
    }

    fun isRememberMeOn(): Boolean = userSession.getBoolean(KEY_REMEMBER_ME, false)

<<<<<<< HEAD
    fun getPhoneNumber(): String? = userSession.getString(KEY_MOBILE, null)
=======
    fun getPhoneNumber(): String? = userSession.getString(KEY_TOKEN, null)
>>>>>>> Insyaallah selesai karena modal saya hanya pengetahuan

    fun getUserDataFromSession(): HashMap<String, String?> {
        return hashMapOf(
            KEY_ID to userSession.getString(KEY_ID, null),
<<<<<<< HEAD
            KEY_NAME to userSession.getString(KEY_NAME, null),
            KEY_MOBILE to userSession.getString(KEY_MOBILE, null)
=======
            KEY_USERNAME to userSession.getString(KEY_USERNAME, null),
            KEY_TOKEN to userSession.getString(KEY_TOKEN, null)
>>>>>>> Insyaallah selesai karena modal saya hanya pengetahuan
        )
    }

    fun getUserIdFromSession(): String? = userSession.getString(KEY_ID, null)

    fun isLoggedIn(): Boolean = userSession.getBoolean(IS_LOGIN, false)

    fun logoutFromSession() {
        editor.clear()
        editor.commit()
    }

    companion object {
        private const val IS_LOGIN = "isLoggedIn"
<<<<<<< HEAD
        private const val KEY_NAME = "userName"
        private const val KEY_MOBILE = "userMobile"
=======
        private const val KEY_USERNAME = "userName"
        private const val KEY_TOKEN = "userToken"
>>>>>>> Insyaallah selesai karena modal saya hanya pengetahuan
        private const val KEY_ID = "userId"
        private const val KEY_REMEMBER_ME = "isRemOn"
    }
}