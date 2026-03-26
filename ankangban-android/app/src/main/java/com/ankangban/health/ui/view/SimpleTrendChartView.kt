package com.ankangban.health.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class SimpleTrendChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val linePaint = Paint().apply {
        color = Color.parseColor("#4CAF50") // Default Green
        strokeWidth = 5f
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    private val pointPaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        isAntiAlias = true
    }
    
    private val pointStrokePaint = Paint().apply {
        color = Color.parseColor("#4CAF50")
        strokeWidth = 3f
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    // 0 = Low, 1 = Medium, 2 = High
    private var dataPoints: List<Int> = listOf(1, 1, 2, 1, 0, 1, 1) // Demo data

    fun setData(data: List<Int>) {
        dataPoints = data
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        if (dataPoints.isEmpty()) return

        val width = width.toFloat()
        val height = height.toFloat()
        val padding = 40f
        
        val effectiveWidth = width - padding * 2
        val effectiveHeight = height - padding * 2
        
        val stepX = effectiveWidth / (dataPoints.size - 1).coerceAtLeast(1)
        
        // Y positions: High (top), Medium (middle), Low (bottom)
        // Map 0->Bottom, 2->Top
        val stepY = effectiveHeight / 2f
        
        val path = Path()
        
        dataPoints.forEachIndexed { index, value ->
            val x = padding + index * stepX
            // Value 0 -> y = padding + 2*stepY (bottom)
            // Value 2 -> y = padding + 0*stepY (top)
            val y = padding + (2 - value) * stepY
            
            if (index == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
            
            // Set color based on latest point or simple logic
            if (value == 2) pointStrokePaint.color = Color.RED
            else if (value == 1) pointStrokePaint.color = Color.parseColor("#FFC107") // Amber
            else pointStrokePaint.color = Color.parseColor("#4CAF50") // Green
            
            canvas.drawCircle(x, y, 12f, pointPaint)
            canvas.drawCircle(x, y, 12f, pointStrokePaint)
        }
        
        linePaint.color = Color.GRAY // Neutral line color
        canvas.drawPath(path, linePaint)
        
        // Redraw points on top
         dataPoints.forEachIndexed { index, value ->
            val x = padding + index * stepX
            val y = padding + (2 - value) * stepY
            
            if (value == 2) pointStrokePaint.color = Color.RED
            else if (value == 1) pointStrokePaint.color = Color.parseColor("#FFC107")
            else pointStrokePaint.color = Color.parseColor("#4CAF50")
            
            canvas.drawCircle(x, y, 12f, pointPaint)
            canvas.drawCircle(x, y, 12f, pointStrokePaint)
        }
    }
}
