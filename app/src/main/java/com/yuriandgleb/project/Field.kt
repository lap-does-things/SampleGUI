package com.yuriandgleb.project
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

fun MisterSandmanBringMeAField(FieldCoords : Array<Array<Int>>, canvas: Canvas, paint: Paint){

    for (i in 0..9){
        for (j in 0..9) {
            if (FieldCoords[i][j] == 0) {

                canvas.drawRect(
                    ((i + 5) * 50).toFloat(),
                    ((j + 5) * 50).toFloat(),
                    ((i + 6) * 50).toFloat(),
                    ((j + 6) * 50).toFloat(),
                    paint
                )
            }

            //paint.setColor(1070109000+j)
        }
    }
}


@SuppressLint("DrawAllocation") //чтобы не было варнингов лишних
class Field @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        val FieldCoords = Array(10) {Array(10) {0} }
        paint.setColor(1070109000)
        paint.style = Paint.Style.FILL_AND_STROKE

        MisterSandmanBringMeAField(FieldCoords,canvas,paint)
        paint.style = Paint.Style.STROKE
        MisterSandmanBringMeAField(FieldCoords,canvas,paint)
    }
}