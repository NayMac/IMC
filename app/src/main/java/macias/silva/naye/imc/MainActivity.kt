package macias.silva.naye.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{
            //verificar el ingreso de datos
            if(!etPeso.text.equals("") and !etAltura.text.equals("")){
                //Afirmacion
                val peso = etPeso.text.toString().toFloat()
                val altura = etAltura.text.toString().toFloat()
                val imc = calculaIMC(peso,altura)

                val i = Intent(this,resultActivity::class.java)
                i.putExtra("imc",imc)
                startActivity(i)

            }else{
                //Mensaje de error
            }
        }

    }
    fun calculaIMC(peso:Float,altura:Float):Float{

    return peso/(altura*altura)
    }
}
