package mx.com.edu.ejercicio10b_2.calculadora.mvp.presenter

interface MainPresenterInterface {

    fun makeSuma(n1: String, n2: String)

    fun makeMultiplicacion(n1: String, n2: String)

    fun makeDivision(n1: String, n2: String)

    fun showResult(result: String)

    fun showError(error: String)
}