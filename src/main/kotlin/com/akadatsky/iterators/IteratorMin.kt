package com.akadatsky.iterators

class IteratorMin(private val lists: List<List<Int>>) : MyIterator {
    private val indexes: IntArray by lazy {
        IntArray(lists.size)
    }
    private var nextListIndex: Int? = null

    override operator fun hasNext(): Boolean {
        nextListIndex = minListIndex
        return nextListIndex != null
    }

    override operator fun next(): Int {
        var result: Int? = null
        nextListIndex?.let {
            result = lists[it][indexes[it]]
            indexes[it]++
        }
        return result ?: throw RuntimeException("Call next on completed Iterator")
    }

    private val minListIndex: Int?
        get() {
            var result: Int? = null
            for (i in lists.indices) {
                if (indexes[i] < lists[i].size) {
                    if (result == null || lists[i][indexes[i]] < lists[result][indexes[result]]) {
                        result = i
                    }
                }
            }
            return result
        }
}