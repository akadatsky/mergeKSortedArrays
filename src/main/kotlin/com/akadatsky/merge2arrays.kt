package com.akadatsky

fun main() {
    val a = intArrayOf(1, 3, 5)
    val b = intArrayOf(2, 4, 6, 7, 8)
    val c = merge(a, b)
    println(c.contentToString())
}

fun merge(a: IntArray, b: IntArray) = IntArray(a.size + b.size).also {
    var i = 0
    var j = 0
    var k = 0
    while (i < a.size && j < b.size) it[k++] = if (a[i] < b[j]) a[i++] else b[j++]
    while (i < a.size) it[k++] = a[i++]
    while (j < b.size) it[k++] = b[j++]
}

