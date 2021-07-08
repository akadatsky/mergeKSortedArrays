package com.akadatsky

import com.akadatsky.iterators.IteratorMin
import com.akadatsky.iterators.IteratorMinHeap
import com.akadatsky.iterators.IteratorSimple
import com.akadatsky.iterators.MyIterator

fun checkCorrectness() {
    val lists = listOf(
        listOf(1, 3, 5),
        listOf(2, 2, 3, 6),
        listOf(1, 3, 7)
    )
    check(checkIterator(IteratorSimple(lists))) { "IteratorSort failed" }
    check(checkIterator(IteratorMin(lists))) { "IteratorSort failed" }
    check(checkIterator(IteratorMinHeap(lists))) { "IteratorSort failed" }
}

fun checkIterator(iterator: MyIterator): Boolean {
    val result = mutableListOf<Int>()
    while (iterator.hasNext()) {
        result.add(iterator.next())
    }
    return result == listOf(1, 1, 2, 2, 3, 3, 3, 5, 6, 7)
}