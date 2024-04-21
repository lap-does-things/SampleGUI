package com.yuriandgleb.project
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        val pic = BitmapFactory.decodeResource(resources,R.drawable.sinthtulo)

        canvas.drawLine(0f,0f,300f,500f,paint)
        canvas.drawCircle(500f,200f,250f,paint)

        canvas.drawBitmap(pic,matrix,paint)

        canvas.drawText("Юра хуй", 200f,200f,paint)
    }
    
}