package com.ankangban.health.core.risk

import android.content.Context
import org.json.JSONObject
import kotlin.math.exp

class RiskInference(private val context: Context) {
    private var coef: DoubleArray = doubleArrayOf()
    private var intercept: Double = 0.0

    fun loadFromAssets(filename: String = "risk_model_export.json") {
        val text = context.assets.open(filename).bufferedReader().use { it.readText() }
        val obj = JSONObject(text)
        val arr = obj.getJSONArray("coef").getJSONArray(0)
        coef = DoubleArray(arr.length()) { i -> arr.getDouble(i) }
        intercept = obj.getJSONArray("intercept").getDouble(0)
    }

    fun predict(features: DoubleArray): Pair<Double, String> {
        require(features.size == coef.size)
        var z = intercept
        for (i in features.indices) z += coef[i] * features[i]
        val p = 1.0 / (1.0 + exp(-z))
        val level = when {
            p >= 0.7 -> "高"
            p >= 0.4 -> "中"
            else -> "低"
        }
        return p to level
    }
}

