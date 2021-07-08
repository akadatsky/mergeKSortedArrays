package com.akadatsky.iterators

class IteratorSimple(lists: List<List<Int>>) : MyIterator {

    private val mergedList: List<Int> by lazy {
        lists.flatten().sorted()
    }
    private var index = 0

    override fun hasNext() = index < mergedList.size

    override fun next() = mergedList[index++]
}