package dev.berlitz.mykotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    var responseView: TextView? = null
    var editText: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        responseView = findViewById(R.id.response)
        editText = findViewById(R.id.editText)
    }

    fun getData(view: View) {
        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET,
            "https://viacep.com.br/ws/${editText?.text}/json/",
            Response.Listener<String> { response ->
                responseView?.text = response
            }, Response.ErrorListener { responseView?.text = "Errooou"  })

        queue.add(stringRequest);
    }
}
