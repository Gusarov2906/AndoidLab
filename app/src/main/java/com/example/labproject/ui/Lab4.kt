package com.example.labproject.ui

import kotlin.math.abs

fun Calculate(first: Double, second: Double, op: Char): String {
    var res: Double
    val resStr: String
    when (op) {
        '+' -> res = first + second
        '-' -> res = first - second
        '*' -> res = first * second
        '/' -> res = first / second
        else -> {
            resStr = "Error! operator is not correct"
            return resStr
        }
    }
    if (abs(res) == 0.0) {
        res = abs(res)
    }
    return res.toString()
}