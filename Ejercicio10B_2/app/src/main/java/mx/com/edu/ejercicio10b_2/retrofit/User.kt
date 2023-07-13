package mx.com.edu.ejercicio10b_2.retrofit

import java.io.Serializable

class User (
    var id: Int?,
    var name: String,
    var email: String,
    var gender: String,
    var status: String
): Serializable