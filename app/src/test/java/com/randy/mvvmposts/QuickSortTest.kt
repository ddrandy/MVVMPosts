package com.randy.mvvmposts

import org.junit.Test
import java.util.*

/**
 * @author randy
 * @since 7/16/18 2:58 PM
 */
class QuickSortTest {
    @Test
    fun quickSortTest() {
        val rawArray = listOf(1, 2, 3, 4, 5, 6, 8, 9, 7, 10, 11,
                12, 13, 14, 16, 15, 17, 18, 19, 20, 21)
                .shuffled().toIntArray()
        println("raw array:\t\t${Arrays.toString(rawArray)}")
        quickSort(rawArray, 0, rawArray.size - 1)
        println("sorted array:\t${Arrays.toString(rawArray)}")
    }

    private fun quickSort(array: IntArray, left: Int, right: Int) {
        val index: Int
        if (array.size > 1) {
            index = partition(array, left, right)
            if (left < index - 1) {
                quickSort(array, left, index - 1)
            }
            if (right > index + 1) {
                quickSort(array, index + 1, right)
            }
        }
    }

    private fun partition(array: IntArray, left: Int, right: Int): Int {
        if (left == right) return left
        val pivot = array[Math.floorDiv(left + right, 2)]
        var i = left
        var j = right
        while (i < j) {
            while (array[i] < pivot) {
                i++
            }
            while (array[j] > pivot) {
                j--
            }
            if (i < j) {
                array.swap(i, j)
            }
        }
        return Math.min(i, j)
    }
}

fun IntArray.swap(first: Int, second: Int) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}