package macias.silva.naye.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_result.*

class resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val imc = intent.getFloatExtra("imc", 0.0f)
        interpretaIMC(imc)


    }

    fun interpretaIMC(imc:Float){
        var rutaFoto = "url"
        var resultado = "no se"
        when {
            imc <= 18.4 -> {
                //bajo
                rutaFoto = "https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwj72JzmkMjdAhVQbKwKHcEBBFcQjRx6BAgBEAU&url=http%3A%2F%2Fmisionesonline.net%2F2017%2F09%2F15%2Fpeso-mejorar-la-alimentacion-quienes-deben-aumentar-peso-saludablemente%2F&psig=AOvVaw0GuOhSM-ulnwkyt99vV02f&ust=1537483037075541"

            }
            imc in 18.4..24.9 -> {
                //normal
                rutaFoto = "https://es.dreamstime.com/stock-de-ilustraci%C3%B3n-personaje-de-dibujos-animados-juguet%C3%B3n-muchacho-con-el-peso-normal-ejemplo-aislado-del-vector-en-el-fondo-blanco-image79246741"
            }
            imc >=  25 -> {
                rutaFoto = "https://saludmovil.com/es/deja-de-hacer-sentir-mal-a-los-ninos-con-sobrepeso-empeora-las-cosas/"
                //sobrepeso
            }
        }
        Picasso.get().load(rutaFoto).into(ivResultado)
        tvResultado.text = resultado
    }
}
