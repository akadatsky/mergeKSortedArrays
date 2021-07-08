package com.akadatsky.iterators

import java.util.*

class IteratorMinHeap(lists: List<List<Int>>) : MyIterator {

    private val minHeap: PriorityQueue<Wrapper> by lazy {
        PriorityQueue<Wrapper>().apply {
            addAll(lists.map { Wrapper(it, 0) })
        }
    }

    override fun hasNext() = minHeap.isNotEmpty()

    override fun next() = minHeap.poll().let {
        if (it.index < it.list.size - 1) {
            minHeap.add(Wrapper(it.list, it.index + 1))
        }
        it.list[it.index]
    }

    class Wrapper(val list: List<Int>, val index: Int) : Comparable<Wrapper> {
        override fun compareTo(other: Wrapper) = this.list[this.index] - other.list[other.index]
    }

}

