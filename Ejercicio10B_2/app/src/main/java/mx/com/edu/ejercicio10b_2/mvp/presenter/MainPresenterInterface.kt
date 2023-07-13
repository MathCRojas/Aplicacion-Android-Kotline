package mx.com.edu.ejercicio10b_2.mvp.presenter

interface MainPresenterInterface {
    fun makeLogin(usuario: String, password: String)

    fun showResult(result: String)

    fun showError(error: String)
}