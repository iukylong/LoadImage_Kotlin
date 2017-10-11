package z79.trainingcourse.loadimage


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

import java.net.URL

class MainActivity : AppCompatActivity() {

    val ul = "https://i.ytimg.com/vi/wwi_TTdzeqo/maxresdefault.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_Download.setOnClickListener {

            LoadImg().execute(ul)
        }

    }


    inner class LoadImg : AsyncTask<String, Void, Bitmap>() {

        override fun doInBackground(vararg params: String?): Bitmap {
            val url = URL(params[0])
            val inputStream = url.openConnection().getInputStream()
            val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)

            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)

            img.setImageBitmap(result)
        }
    }


}
