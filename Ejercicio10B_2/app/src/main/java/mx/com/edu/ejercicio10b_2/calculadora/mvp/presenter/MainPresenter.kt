package mx.com.edu.ejercicio10b_2.calculadora.mvp.presenter

import mx.com.edu.ejercicio10b_2.calculadora.mvp.interactor.MainInteractor
import mx.com.edu.ejercicio10b_2.calculadora.mvp.view.CalculadoraActivity

class MainPresenter(private val view: CalculadoraActivity): MainPresenterInterface {

    val interactor = MainInteractor(this)

    override fun makeSuma(n1: String, n2: String) {
        interactor.makeSuma(n1, n2)
    }

    override fun makeMultiplicacion(n1: String, n2: String) {
        interactor.makeMultiplicacion(n1, n2)
    }

    override fun makeDivision(n1: String, n2: String) {
        interactor.makeDivision(n1, n2)
    }

    override fun showResult(result: String) {
        view.showResult(result)
    }

    override fun showError(error: String) {
        view.showError(error)
    }
}