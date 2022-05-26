package com.dongeul.mysampletestapplication

import org.junit.Assert.*
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        val s = Stack<Int>()

        s.push(1)
        s.push(3)

        s.peek()

    }



    @Test
    fun `큰 수의 법칙 그리디`() {
        val board = intArrayOf(2, 4, 5, 4, 6)
        val reverseBoard = board.sortDescending()
        val arraySize = 5
        val addCount = 8
        val maximumAddingCount = 3

        val maximumInt = board[0]
        val secondMaximumInt = board[1]

        var increaseCount = 0
        var sum = 0

        while (increaseCount != addCount) {
            if (increaseCount % (maximumAddingCount + 1) == 0) {
                sum = sum + secondMaximumInt
            } else {
                sum = sum + maximumInt
            }
            increaseCount += 1
        }
        println(sum)
    }

    //[500, 1000, -300, 200, -400, 100, -100]
    // [500, 500]

    //[500, 1000, 2000, -1000, -1500, 500]
    //[500, 500, 500]
    @Test
    fun asdf() {
        val inputList = intArrayOf(500, 1000, -300, 200, -400, 100, -100).toCollection(ArrayList())
        println(inputList)

        var resultList = arrayListOf<Int>()
        inputList.forEachIndexed { index, money ->

            if (money > 0) {
                resultList.add(money)
            } else {
                var roop = true
                var money = money
                while (roop) {
                    val lastIndexOfMoney = resultList[resultList.lastIndex]
                    resultList =
                        resultList.filterIndexed { index, i -> index != resultList.lastIndex } as ArrayList<Int>

                    val decreasedMoney = lastIndexOfMoney + money
                    money = decreasedMoney
                    if (decreasedMoney > 0) {
                        resultList.add(decreasedMoney)
                        roop = false
                    } else {
                        roop = true
                    }
                }
            }
        }

    }

    @Test
    fun `다이내믹 1만들기`() {
        val x = 4
        val list = IntArray(x + 1)

        for (i in 2..x) {

            list[i] = list[i - 1] + 1

            when {
                i % 2 == 0 -> {
                    list[i] = min(list[i], (list[i / 2] + 1))
                }
                i % 3 == 0 -> {
                    list[i] = min(list[i], (list[i / 3] + 1))
                }
                i % 5 == 0 -> {
                    list[i] = min(list[i], (list[i / 5] + 1))
                }
            }
        }

        print(list[x])
    }

    //10 ,20 ,30 ,40



    @Test
    fun `다이내믹 식량창고 개미`() {
        val x = intArrayOf(1, 3, 1)
        val list = IntArray(x.size+1)

        // <<<<<<<3일 때>>>>>>


        //0번째 + 2번째

        // 1번째


        // << 4 일 때 >>

        // 0번째 + 2번째

        // 1번째 + 3번째


        // << 5일 때 >>

        // 0번째 + 2번째 + 4번째

        // 1번쨰 + 3번째


        // << 6일 때 >>

        // 0번째 + 2번째 + 4번째

        // 1번째 + 3번째 + 5번째


        for (i in 3 until x.size+1) {
            when {
                i % 2 == 0 -> {
                    list[i] = max(x[i - i] + x[i - 2], x[i - 3] + x[i - 1])
                }
                else -> {
                    list[i] = max((x[i - i] + x[i - 1]), x[i - 2])
                }
            }

        }

    }

    fun ddfasdf() {
        val board = arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 0, 1, 0)
        )
        var answer = 0
        var row = board.size
        var col = board[0].size


        for (i in 1 until board.size) {
            for (j in 1 until board[0].size) {
                if (board[i][j] != 0) {
                    board[i][j] = minOf(board[i][j - 1], board[i - 1][j], board[i - 1][j - 1]) + 1
                    answer = Math.max(board[i][j], answer)
                }
            }
        }
        println(answer * answer)

        intArrayOf(2, 3)
    }

    @Test
    fun rotate() {
        val arr = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val n: Int = arr.size
        val m: Int = arr.get(0).size
        val rotate = Array(m) { IntArray(n) }

        for (i in rotate.indices) {
            for (j in 0 until rotate[i].size) {
                rotate[i][j] = arr.get(n - 1 - j).get(i)
            }
        }

        println(rotate)
    }

    @Test
    fun test222() {
        val list = intArrayOf(5, 7, 9, 0, 3, 1, 6, 2, 4, 8)
//        val list = intArrayOf(2, 4, 3)
//        val list = intArrayOf(6, 9, 7, 8)
        this.`퀵 정렬`(list, 0, list.size - 1)
//        this.`내가 만든 퀵 정렬`(list, 0,list.size-1)
        println(list)

    }

    @Test
    fun `두 배열의 원소 교체`() {
        var n = 5
        var k = 3

        val listA = intArrayOf(1, 2, 5, 4, 3)
        var listB = intArrayOf(5, 5, 6, 6, 5)

        listA.sort()
        listB.sortDescending()
        var maximumValue = 0

        // listA의 최소값을 k 번 만큼 꺼내서
        // listB의 최대값을 k 번 만큼 교체해준다
        for (i in 0 until k) {
            listA[i] = listB[i]
        }

        maximumValue = listA.sum()
        println(maximumValue)

    }

    @Test
    fun `이진탐색 호출`() {
        val array = arrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)
        val result = `이진탐색 로직`(array = array, target = 3, start = 0, end = array.size - 1)
        if (result == null) {
            "못찾음"
        } else {
            println(result + 1)
        }
    }


    fun `이진탐색 로직`(array: Array<Int>, target: Int, start: Int, end: Int): Int? {
        if (start > end) {
            return null
        }
        var mid = (start + end) / 2

        if (array[mid] == target) {
            return mid
        }

        return when {
            array[mid] == target -> {
                mid
            }
            array[mid] > target -> {
                this.`이진탐색 로직`(array = array, target = target, start = start, end = mid - 1)
            }
            array[mid] < target -> {
                this.`이진탐색 로직`(array = array, target = target, start = mid + 1, end = end)
            }
            else -> {
                null
            }
        }
    }

    @Test
    fun `역 순 정렬`() {
        val list = intArrayOf(3, 15, 27, 12)

        list.sortDescending()
        print(list)
    }

    @Test
    fun `성적 낮은 순으로 학생 출력하기`() {
        val map = mutableMapOf(Pair("홍길동", 95), Pair("이순신", 77))

        val tl = map.toList()

        val tl2 = tl.sortedBy { it.second }

    }


    fun `퀵 정렬`(list: IntArray, start: Int, end: Int) {


        if (start >= end) {
            return
        }

        var pivot = start
        var comparisonLeft = start + 1
        var comparisonRight = end
        // 왼쪽이 오른쪽보다 작으면 true
        while (comparisonLeft <= comparisonRight) {
            //피벗보다 큰 데이터를 찾을 때까지 반복
            while (comparisonLeft <= end && list[comparisonLeft] < list[pivot]) {
                comparisonLeft += 1
            }
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (comparisonRight > start && list[comparisonRight] > list[pivot]) {
                comparisonRight -= 1
            }


            if (comparisonLeft < comparisonRight) {
                list[comparisonLeft] =
                    list[comparisonRight].also { list[comparisonRight] = list[comparisonLeft] }
            } else {
                list[comparisonRight] = list[pivot].also { list[pivot] = list[comparisonRight] }
            }

        }

        `퀵 정렬`(list, start, comparisonRight - 1)
        `퀵 정렬`(list, comparisonRight + 1, end)


    }


    fun `내가 만든 퀵 정렬`(list: IntArray, start: Int, end: Int) {
        var pivot = start
        var left = pivot + 1
        var right = end

        if (start >= right) {
            return
        }

        while (left <= right) {

            // 왼쪽이 피벗보다 작으면 +1
            while (list[pivot] < list[left] && left <= end) {
                left += 1
            }
            // 오른쪽이 피벗보다 크면 +1
            while (list[pivot] > list[right] && right >= start) {
                right -= 1
            }

            // 왼쪽이 오른쪽 보다 더 크면 pivot 과 right 스왑
            if (left > right) {
                var temp = list[pivot]
                list[pivot] = list[right]
                list[right] = temp

                // 왼쪽이 오른쪽 보다 더 크면 right 와 left 스왑
            } else {
                var temp = list[right]
                list[right] = list[left]
                list[left] = temp
            }

        }

        // 기준점을 중심으로 left 분할
        this.`내가 만든 퀵 정렬`(list = list, start = start, end = right - 1)
        // 기준점을 중심으로 right 분할
        this.`내가 만든 퀵 정렬`(list = list, start = right + 1, end = end)

    }


}

fun solution(board: Array<IntArray>) {
    val board = arrayOf(
        intArrayOf(0, 1, 1, 1, 1),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, 1, 1),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 0, 1, 1, 1)
    )


}

