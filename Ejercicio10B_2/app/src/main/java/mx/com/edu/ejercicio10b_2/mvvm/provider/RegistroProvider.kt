package mx.com.edu.ejercicio10b_2.mvvm.provider

class RegistroProvider {

    companion object{

        fun checkLogin(user: String, password: String): Boolean{
            return !(user.isNullOrEmpty() || password.isNullOrEmpty())
        }

    }
}