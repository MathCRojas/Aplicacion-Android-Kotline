package mx.com.edu.ejercicio10b_2.mvvm.calcular.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.com.edu.ejercicio10b_2.mvvm.calcular.provider.CalculadoraProvider

class CalculadoraViewModel: ViewModel() {

    var result: MutableLiveData<String> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun areaCuadrado(medida: String){
        if(CalculadoraProvider.areaCuadrado(medida)){
            result.postValue("Area: " + (Integer.parseInt(medida) * Integer.parseInt(medida))
            + "\nPerimetro: " + (Integer.parseInt(medida) * 4))
        }else{
            error.postValue("Ingrese un valor")
        }
    }

    fun areaTriangulo(medida: String){
        if(CalculadoraProvider.areaCuadrado(medida)){
            result.postValue("Area: " + (Math.sqrt(3.0) / 4 * (Integer.parseInt(medida) * Integer.parseInt(medida))).toInt()
            + "\nPerimetro: " + (Integer.parseInt(medida) + Integer.parseInt(medida) + Integer.parseInt(medida)))
        }else{
            error.postValue("Ingrese un valor")
        }
    }

    fun areaCirculo(medida: String){
        if(CalculadoraProvider.areaCuadrado(medida)){
            result.postValue("Area: " + (Integer.parseInt(medida) * Integer.parseInt(medida) * 3.1416).toInt()
            + "\nPerimetro: " + (2 * 3.1416 * Integer.parseInt(medida)).toInt())
        }else{
            error.postValue("Ingrese un valor")
        }
    }

}