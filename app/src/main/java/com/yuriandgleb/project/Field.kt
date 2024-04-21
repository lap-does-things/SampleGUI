package com.yuriandgleb.project
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Handler
import android.os.HandlerThread
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.coroutines.delay

var CellCoords = Array(10) {Array(10) {Cell(false,false,false)} }
var setup = false
var path = Array(34) {IntArray(2) }
fun initialsetup(){
    path[0] = intArrayOf(1,0)
    path[1] = intArrayOf(1,1)
    path[2] = intArrayOf(1,2)
    path[3] = intArrayOf(2,2)
    path[4] = intArrayOf(2,3)
    path[5] = intArrayOf(3,3)
    path[6] = intArrayOf(4,3)
    path[7] = intArrayOf(4,2)
    path[8] = intArrayOf(5,2)
    path[9] = intArrayOf(5,1)
    path[10] = intArrayOf(6,1)
    path[11] = intArrayOf(7,1)
    path[12] = intArrayOf(7,2)
    path[13] = intArrayOf(8,2)
    path[14] = intArrayOf(8,3)
    path[15] = intArrayOf(8,4)
    path[16] = intArrayOf(8,5)
    path[17] = intArrayOf(8,6)
    path[18] = intArrayOf(8,7)
    path[19] = intArrayOf(8,8)
    path[20] = intArrayOf(8,9)
    path[21] = intArrayOf(7,9)
    path[22] = intArrayOf(6,9)
    path[23] = intArrayOf(5,9)
    path[24] = intArrayOf(5,8)
    path[25] = intArrayOf(5,7)
    path[26] = intArrayOf(4,7)
    path[27] = intArrayOf(4,6)
    path[28] = intArrayOf(3,6)
    path[29] = intArrayOf(2,6)
    path[30] = intArrayOf(2,7)
    path[31] = intArrayOf(1,7)
    path[32] = intArrayOf(1,8)
    path[33] = intArrayOf(1,9)

    //вот это моё.... невезучее место...
    //https://www.youtube.com/shorts/xJ4Tue7wtmA
    if (setup ==false) {
        //CellCoords[1][0].isMonster=true
        CellCoords[0][1].isWall = true
        CellCoords[0][2].isWall = true
        CellCoords[0][3].isWall = true
        CellCoords[0][4].isWall = true
        CellCoords[0][5].isWall = true
        CellCoords[0][6].isWall = true
        CellCoords[0][7].isWall = true
        CellCoords[0][8].isWall = true
        CellCoords[0][9].isWall = true
        CellCoords[0][0].isWall = true
        //первый ряд

        //второй ряд
        CellCoords[1][3].isWall = true
        CellCoords[1][4].isWall = true
        CellCoords[1][5].isWall = true
        CellCoords[1][6].isWall = true

        //третий ряд

        CellCoords[2][0].isWall = true
        CellCoords[2][1].isWall = true
        CellCoords[2][4].isWall = true
        CellCoords[2][5].isWall = true
        CellCoords[2][8].isWall = true
        CellCoords[2][9].isWall = true

        //4 ryad
        CellCoords[3][0].isWall = true
        CellCoords[3][1].isWall = true
        CellCoords[3][2].isWall = true
        CellCoords[3][4].isWall = true
        CellCoords[3][5].isWall = true
        CellCoords[3][7].isWall = true
        CellCoords[3][8].isWall = true
        CellCoords[3][9].isWall = true

        //5 ryad
        CellCoords[4][0].isWall = true
        CellCoords[4][1].isWall = true
        CellCoords[4][4].isWall = true
        CellCoords[4][5].isWall = true
        CellCoords[4][9].isWall = true
        CellCoords[4][8].isWall = true


        CellCoords[5][0].isWall = true
        CellCoords[5][3].isWall = true
        CellCoords[5][4].isWall = true
        CellCoords[5][5].isWall = true
        CellCoords[5][6].isWall = true

        CellCoords[6][0].isWall=true
        CellCoords[6][2].isWall=true
        CellCoords[6][3].isWall=true
        CellCoords[6][4].isWall=true
        CellCoords[6][5].isWall=true
        CellCoords[6][6].isWall=true
        CellCoords[6][7].isWall=true
        CellCoords[6][8].isWall=true

        CellCoords[7][0].isWall=true
        CellCoords[7][3].isWall=true
        CellCoords[7][4].isWall=true

        CellCoords[7][5].isWall=true
        CellCoords[7][6].isWall=true
        CellCoords[7][7].isWall=true
        CellCoords[7][8].isWall=true

        CellCoords[8][0].isWall=true
        CellCoords[8][1].isWall=true



        CellCoords[9][0].isWall=true
        CellCoords[9][1].isWall=true
        CellCoords[9][2].isWall=true
        CellCoords[9][3].isWall=true
        CellCoords[9][4].isWall=true
        CellCoords[9][5].isWall=true
        CellCoords[9][6].isWall=true
        CellCoords[9][7].isWall=true
        CellCoords[9][8].isWall=true
        CellCoords[9][9].isWall=true


        setup = true
    }}
var basehp=50
var a = Monster(apath=0, dmg = 1)
var mod = 50

fun DrawMeAMonter(CellCoords: Array<Array<Cell>>, canvas: Canvas,paint: Paint){
    for (i in 0..9) {
        for (j in 0..9) {
            if (CellCoords[i][j].isMonster) {
                //paint.setColor(1070108000)

                paint.setColor(1001001000)
                canvas.drawText(
                    a.hp.toString(),
                    0,
                    a.hp.toString().length,
                    ((i + 5) * mod).toFloat(),
                    ((j + 5) * mod + 20).toFloat(),
                    paint
                )
            }
        }
    }
}
fun MisterSandmanBringMeAField(CellCoords : Array<Array<Cell>>, canvas: Canvas, paint: Paint){
/*
Mr. Sandman, bring me a field
Make him the cutest that I've ever seen
Give him two indexes like i and j
Then tell him that his lonesome renders are over
Sandman, I'm so alone
Don't have no field to call my own
Please turn on your magic compiler
Mr. Sandman, bring me a field
 */
    for (i in 0..9){
        for (j in 0..9) {

            if (CellCoords[i][j].isTower == false)  {
                paint.setColor(1070108000)
                canvas.drawRect(
                    ((i + 5) * mod).toFloat(),
                    ((j + 5) * mod).toFloat(),
                    ((i + 6) * mod).toFloat(),
                    ((j + 6) * mod).toFloat(),
                    paint
                )

            }
            if (CellCoords[i][j].isWall){
                paint.setColor(1023458000)
                canvas.drawRect(
                    ((i + 5) * mod).toFloat(),
                    ((j + 5) * mod).toFloat(),
                    ((i + 6) * mod).toFloat(),
                    ((j + 6) * mod).toFloat(),

                    paint
                )

                paint.textSize = 24f
               //  ПРАВИЛЬНАЯ формула
                // canvas.drawText(stena,((i + 5) * mod).toFloat(),((j + 5) * mod+ 20).toFloat(),paint)
                paint.setColor(1070108000)
            }

        }

    }
}

class Cell (var isTower: Boolean, var isMonster: Boolean,var isWall : Boolean){

}
class Monster(var hp:Int = basehp, var apath:Int = 0, var dmg:Int) {
    fun walk(){
        if (CellCoords[path[apath][0]][path[apath][1]].isMonster == true && apath ==0){

        }
        else{
            CellCoords[path[apath][0]][path[apath][1]].isMonster = false
            apath = apath + 1
            CellCoords[path[apath][0]][path[apath][1]].isMonster = true
        }


    }

}
var m = MainActivity()
var btn : Boolean = false
@SuppressLint("DrawAllocation") //чтобы не было варнингов лишних
class Field @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var color = 1070108000
    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        initialsetup()


        paint.setColor(color)
        //color-=20
        paint.style = Paint.Style.FILL_AND_STROKE
        MisterSandmanBringMeAField(CellCoords,canvas,paint)
        paint.style = Paint.Style.STROKE
        MisterSandmanBringMeAField(CellCoords,canvas,paint)



            DrawMeAMonter(CellCoords, canvas, paint)
            a.walk()
            Thread.sleep(1000)
            postInvalidateOnAnimation()


    }
}