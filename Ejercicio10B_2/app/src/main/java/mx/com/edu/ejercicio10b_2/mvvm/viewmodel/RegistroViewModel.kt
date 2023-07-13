package mx.com.edu.ejercicio10b_2.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.com.edu.ejercicio10b_2.mvvm.provider.RegistroProvider

class RegistroViewModel: ViewModel() {

    var result: MutableLiveData<String> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun checkLogin(user: String, password: String){
        if(RegistroProvider.checkLogin(user, password)){
            result.postValue("Todo ok!")
        }else{
            error.postValue("Verifique sus datos...")
        }
    }

}