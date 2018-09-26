package macias.silva.naye.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_result.*

class resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val imc = intent.getFloatExtra("imc", 0.0f)
        interpretaIMC(imc)


    }

    fun interpretaIMC(imc:Float){
        var rutaFoto = ""
        when {
            imc <= 18.4 -> {
                //bajo
                rutaFoto = "https://static0.misionesonline.net/wp-content/uploads/2017/09/bajo-peso-61i7f7jofk70.jpg"
                tvResultado.text = "bajo"
            }
            imc in 18.4..24.9 -> {
                //normal
                rutaFoto = "https://thumbs.dreamstime.com/z/personaje-de-dibujos-animados-juguet%C3%B3n-muchacho-con-el-peso-normal-ejemplo-aislado-del-vector-en-el-fondo-blanco-79246741.jpg"
                tvResultado.text = "normal"
        }
            imc >=  25 -> {
                rutaFoto = "https://saludmovil.com/wp-content/uploads/2018/01/Stop-Shaming-Overweight-Kids-It-Makes-Things-Worse-MainPhoto.jpg"
                tvResultado.text = "sobrepeso"
                //sobrepeso
            }
        }
        Log.d("img", rutaFoto)
        Glide.with(this).load(rutaFoto).into(res)
    }
}
