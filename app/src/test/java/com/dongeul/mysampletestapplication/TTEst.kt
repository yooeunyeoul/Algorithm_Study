package com.dongeul.mysampletestapplication

import org.junit.Test

class TTEst {

    @Test
    fun `해보장`() {
        val card = arrayOf(
            "ABACDEFG",
            "NOPQRSTU",
            "HIJKLKMM"
        )


//        val isContains = Array(array.size) { false }


        val word = arrayOf("GPQM,GPMZ,EFU,MMNA")

        val isContainsArrayList = mutableListOf<Array<Boolean>>()
        for (i in word.indices) {
            isContainsArrayList.add(Array(card.size) { false })
        }

        // [ false, false, false ],
        // [ false, false, false ],
        // [ false, false, false ],
        // [ false, false, false ]

        var answer = arrayOf("-1")


        // word를 2차원 배열로 만들어야할듯
        val chunkWordList = mutableListOf<Array<String>>()

        for (i in word.indices) {
            val word = word[i]
            val chunkedWordArray = word.chunked(1).toTypedArray()
//            chunkWordList[i] = chunkedWord
            chunkWordList.add(chunkedWordArray)
        }
        // [G, P , Q , M ] ,[ G , P ,M ,Z ] , [E,F,U] , [M,M,N,A]

        var removePositionList = mutableListOf<Int>()

        for (i in 0 until chunkWordList.size) {
            var chunkedArray = chunkWordList[i] // [G, P , Q , M ]
            val tempCard = Array(card.size) { "" }
            for (i in card.indices) {
                tempCard[i] = card[i]
            }
            for (j in chunkedArray.indices) {
                val char = chunkedArray[j] // G

                var isContain = false // 해당 문자가 포함되어있는지 체크
                for (n in tempCard.indices) {
                    val characterString = tempCard[n] // ABCDEFG
                    //  포함되어있음
                    if (characterString.contains(char)) {
//                        val index =characterString.indexOf(char)
                        val changedString=characterString.replaceFirst(char,"")

                        tempCard[n]=changedString
                        // [ true, false, false ],
                        // [ false, false, false ],
                        // [ false, false, false ],
                        // [ false, false, false ]
                        isContainsArrayList[i][n] = true
                        isContain = true
                        break
                    }
                    if (n == tempCard.size - 1) {
                        if (isContain == false) {
                            removePositionList.add(i)
                        }
                    }
                }
            }
        }

        var resultList = mutableListOf<String>()
        for (i in 0 until isContainsArrayList.size) {
            val booleanArray = isContainsArrayList[i] // [ true, true, false ]
            if (booleanArray.contains(false) == false) {
                if (removePositionList.contains(i) == false) {
                    resultList.add(word[i])
                }
            }

        }

        if (resultList.size == 0) {
            resultList.add("-1")
        }

        println("과연 정답은 $resultList")
    }

}