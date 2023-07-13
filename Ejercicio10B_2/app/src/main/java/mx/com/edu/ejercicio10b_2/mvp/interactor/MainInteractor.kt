package mx.com.edu.ejercicio10b_2.mvp.interactor

import mx.com.edu.ejercicio10b_2.mvp.presenter.MainPresenter

class MainInteractor(private val presenter: MainPresenter) : MainInteractorInterface {
    override fun makeLogin(usuario: String, password: String) {
        if(usuario.isNullOrEmpty()){
            presenter.showError("Ingrese un usuario")
        }else if(password.isNullOrEmpty()){
            presenter.showError("Ingrese una contraseña")
        }else{
            presenter.showResult("Todo ok!")
        }
    }
}