package mx.com.edu.ejercicio10b_2.mvp.presenter

import mx.com.edu.ejercicio10b_2.mvp.interactor.MainInteractor
import mx.com.edu.ejercicio10b_2.mvp.view.MainMvpActivity

class MainPresenter(private val view:MainMvpActivity): MainPresenterInterface {

    val interactor = MainInteractor(this)

    override fun makeLogin(usuario: String, password: String) {
        interactor.makeLogin(usuario,password)
    }

    override fun showResult(result: String) {
        view.showResult(result)
    }

    override fun showError(error: String) {
        view.showError(error)
    }
}