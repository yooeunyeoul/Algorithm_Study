package com.dongeul.mysampletestapplication

import org.junit.Test

class CodingTest {

    private lateinit var distance: IntArray

    private lateinit var visited: BooleanArray

    private var startNode: Int = 0
    private var ganSunCount: Int=0
    private var nodeCount: Int=0

//    @Test
//    fun `다익스트라 알고리즘`() {
//
//         nodeCount = 6
//         ganSunCount = 11
//         startNode = 1
//
//        val inputNode = arrayOf(
//            intArrayOf(1, 2, 2),
//            intArrayOf(1, 3, 5),
//            intArrayOf(1, 4, 1),
//            intArrayOf(2, 3, 3),
//            intArrayOf(2, 4, 2),
//            intArrayOf(3, 2, 3),
//            intArrayOf(3, 6, 5),
//            intArrayOf(4, 3, 3),
//            intArrayOf(4, 5, 1),
//            intArrayOf(5, 3, 1),
//            intArrayOf(5, 6, 2)
//        )
//
//        // node 개수를 담을 리스트 생성
//         val graph = Array
//
//        // 방문한 적이 있는지 체크하는 목적의 리스트 만들기
//         visited = BooleanArray(nodeCount)
//
//        // 최단 거리를 담을 리스트 생성
//        distance = IntArray(nodeCount)
//    }

    fun `방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드의 번호를 반환`(): Int {
        var minValue = 0
        var index = 0

        for (i in 1..nodeCount) {
            if(distance[i]< minValue && !visited[i]){
                minValue = distance[i]
                index = i
            }
        }
        return index
    }

//    fun `다익스트라 알고리즘 로직`(start:Int){
//
//        // 시작 노드에 대해 초기화
//        distance[start] = 0
//
//        visited[start] = true
//
//        for (j in graph[start] .. graph[nodeCount]) {
//            distance[j[0]]
//        }
//        for (j in graph[start]){}
//    }





}