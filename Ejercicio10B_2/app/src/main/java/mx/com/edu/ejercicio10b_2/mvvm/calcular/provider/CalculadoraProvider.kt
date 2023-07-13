package mx.com.edu.ejercicio10b_2.mvvm.calcular.provider

class CalculadoraProvider {

    companion object{

        fun areaCuadrado(medida: String): Boolean{
            return !(medida.isNullOrEmpty())
        }

        fun areaTriangulo(medida: String): Boolean{
            return !(medida.isNullOrEmpty())
        }

        fun areaCirculo(medida: String): Boolean{
            return !(medida.isNullOrEmpty())
        }

    }
}