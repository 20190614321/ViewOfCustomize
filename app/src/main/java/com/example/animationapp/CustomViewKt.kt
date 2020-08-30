package com.example.animationapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.security.AccessControlContext

class CustomViewKt(context:Context, attrs:AttributeSet?, defStyleAttr:Int): View(context,attrs,defStyleAttr) {
    private var mWidth = 0
    private var mHeight = 0
    private var radius = 0f
    private val path:Path by lazy {
        Path().apply {
            moveTo(20f,30f)
            //lineTo(400f,30f)
            //二阶贝塞尔曲线
           //quadTo(700f,180f,400f,330f)
            //三阶贝塞尔曲线
            //moveTo(100f,800f)
            //cubicTo(200f,300f,800f,1300f,900f,800f)
            //圆弧
            moveTo(100f,1200f)
            val rectf = RectF(100f,900f,900f,1500f)
            arcTo(rectf,0f,180f)
            close()
            //画圆
            addCircle(300f,300f,200f,Path.Direction.CCW)

        }
    }
    private val circlePaint:Paint by lazy {
        Paint().apply {
            //设置颜色
            //color = Color.LTGRAY
            //color = Color.parseColor("#B990F7")
            // setARGB(15,175,202,253)
            setShader(LinearGradient(
                mWidth/2f,0f,mWidth/2f,mHeight.toFloat(),Color.RED,Color.BLUE,
                Shader.TileMode.CLAMP
            ))
            //填充样式
            style = Paint.Style.FILL
            //画笔粗细
            strokeWidth = 5f
        }
    }
    constructor(context:Context):this(context,null,0){

    }
    constructor(context:Context, attrs:AttributeSet):this(context,attrs,0){

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = measuredWidth
        mHeight = measuredHeight
        radius = if(mWidth > mHeight) mHeight/2f else mWidth/2f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        //setBackgroundColor(Color.BLUE)
        //画圆
        //canvas?.drawCircle(mWidth/2f,mHeight/2f,radius,circlePaint)
        //画直线
        //canvas?.drawLine(0f,0f,200f,0f,circlePaint)
        canvas?.drawPath(path,circlePaint)
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
    }
}