package mx.com.edu.ejercicio10b_2.calculadora.mvp.interactor

import mx.com.edu.ejercicio10b_2.calculadora.mvp.presenter.MainPresenter

class MainInteractor(private val presenter: MainPresenter): MainInteractorInterface {
    override fun makeSuma(n1: String, n2: String) {
        if(n1.isNullOrEmpty()){
            presenter.showError("Primer numero es nulo")
        }else if(n2.isNullOrEmpty() ){
            presenter.showError("Segundo numero es nulo")
        }else{
            presenter.showResult("El resultado es: " + (Integer.parseInt(n1) + Integer.parseInt(n2)))
        }
    }

    override fun makeMultiplicacion(n1: String, n2: String) {
        if(n1.isNullOrEmpty()){
            presenter.showError("Primer numero es nulo")
        }else if(n2.isNullOrEmpty() ){
            presenter.showError("Segundo numero es nulo")
        }else{
            presenter.showResult("El resultado es: " + (Integer.parseInt(n1) * Integer.parseInt(n2)))
        }
    }

    override fun makeDivision(n1: String, n2: String) {
        if(n1.isNullOrEmpty() || n1.equals("0")){
            presenter.showError("Primer numero es nulo")
        }else if(n2.isNullOrEmpty() || n2.equals("0")){
            presenter.showError("Segundo numero es nulo")
        }else{
            presenter.showResult("El resultado es: " + (Integer.parseInt(n1) / Integer.parseInt(n2)))
        }
    }


}