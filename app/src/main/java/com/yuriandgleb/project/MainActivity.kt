package com.yuriandgleb.project

import android.content.Context
import android.os.*
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.yuriandgleb.project.Field
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.yuriandgleb.project.ui.theme.ProjectTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking



class MainActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        var f = Field(this)
        var canvas = android.graphics.Canvas()
        var paint = android.graphics.Paint()
        button.setOnClickListener {
            //Log.d('i'.toString(), "CLICK!")
            //btn = true
            //DrawMeAMonter(CellCoords,f.onDraw(canvas),paint)
            //a.walk()
        }
        val timerthread = HandlerThread("Timer")
        timerthread.start()
        val handler = Handler(timerthread.looper)
        handler.post {
            while(true) {
                //Thread.sleep(1000)
                //Log.i("info", "AAAA")
                //setContentView(R.layout.activity_main)

                //логика идёт сюда
            }

        }
    }

}


