package com.akadatsky

import com.akadatsky.iterators.IteratorMin
import com.akadatsky.iterators.IteratorMinHeap
import com.akadatsky.iterators.IteratorSimple
import com.akadatsky.iterators.MyIterator
import kotlin.random.Random

const val K = 3
const val COUNT = 20_000_000
const val RANDOM_RANGE = Int.MAX_VALUE

fun main() {
    checkCorrectness()
    println("Prepare test data")
    val lists = prepareTestData()
    println("Start measure time")
    measureTime(IteratorSimple(lists))
    System.gc()
    measureTime(IteratorMinHeap(lists))
    System.gc()
    measureTime(IteratorMin(lists))
}

fun measureTime(iterator: MyIterator) {
    var time = System.currentTimeMillis()
    var sum: Long = 0
    while (iterator.hasNext()) {
        sum += iterator.next()
    }
    time = System.currentTimeMillis() - time
    println("Time ${iterator::class.simpleName}: ${time / 1000.0} seconds")
    println("Sum: $sum")
}

fun prepareTestData() = mutableListOf<List<Int>>().apply {
    repeat(K) {
        add(List(COUNT) {
            Random.nextInt(RANDOM_RANGE)
        }.sorted())
    }
}


