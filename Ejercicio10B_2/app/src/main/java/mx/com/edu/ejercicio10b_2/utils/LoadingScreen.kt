package mx.com.edu.ejercicio10b_2.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import mx.com.edu.ejercicio10b_2.R

object LoadingScreen {

    var dialog: Dialog? = null

    fun show(context: Context, mensaje: String, cancelable: Boolean){
        dialog = Dialog(context)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //Este layout se creo
        dialog!!.setContentView(R.layout.dialog)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //Indica si se puede cerrar la alerta o no
        dialog!!.setCancelable(cancelable)
        //Para setear el mensaje
        var label = dialog!!.findViewById<TextView>(R.id.label)
        label.setText(mensaje)

        dialog!!.show()

    }

    fun hide(){
        if(dialog != null){
            dialog!!.dismiss()
        }
    }

}