package lottiefiles.blogspot.com

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityLottie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        myurl.setOnClickListener {
            if(edturl.length()>10){
                // It must be an URL
                val Http: String = edturl.text.toString()
                if(Http.contains("http")){
                    //Url must be .json extension
                    val Url: String = edturl.text.toString()

                    if(Url.contains(".json")){
                        //Some animations in LottieFiles are not compatible, so test the animations beforehand.
                        LottieAnimationViewId.setAnimationFromUrl(edturl.text.toString())
                        try {
                            LottieAnimationViewId.playAnimation()

                        } catch (e: Exception) {
                            Toast.makeText(this, "Exception: $e", Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(this, "Url must be .json extension", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this, "It must be an URL", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this, "Url field must not be empty", Toast.LENGTH_LONG).show()
            }
        }



        clearfield.setOnClickListener {
            edturl.setText("")
            Toast.makeText(this, "clean edit field", Toast.LENGTH_LONG).show()
        }

        bg_black.setOnClickListener {
            containerLottie.setBackgroundColor(Color.BLACK)
        }
        bg_white.setOnClickListener {
            containerLottie.setBackgroundColor(Color.WHITE)
        }

        fromurl.setOnClickListener {
            LottieAnimationViewId.setAnimationFromUrl("https://gist.githubusercontent.com/Allanksr/d36c8a66ea24ec7df1ea422782fa7ae0/raw/bf1a65fc57b1db102893c80f0f3356e100e10a51/proxsensor.json")
            LottieAnimationViewId.playAnimation()
        }

        fromhere.setOnClickListener {
            LottieAnimationViewId.setAnimation("signalicon.json")
            LottieAnimationViewId.playAnimation()
        }

        dialog.setOnClickListener {
            LottieAnimationViewId.setAnimation("signalicon.json")
            LottieAnimationViewId.playAnimation()
        }


        myspace.setOnClickListener {
            val space = Uri.parse("https://lottiefiles.com/allanksr")
            try {
                 startActivity(Intent(Intent.ACTION_VIEW, space))
            } catch (e: Exception) {
                Toast.makeText(this, "Install a browser", Toast.LENGTH_LONG).show()
            }
            lottieCom.playAnimation()
            border.playAnimation()
        }


    }
}