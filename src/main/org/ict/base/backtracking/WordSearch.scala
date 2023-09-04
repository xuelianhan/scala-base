package org.ict.base.backtracking

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC79, Medium, frequency=123
 */
object WordSearch {

    /**
     * Time Cost 560ms
     * @param board
     * @param word
     * @return
     */
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        if (word == null || word.isEmpty) {
            return false
        }
        val m = board.length
        val n = board(0).length
        for (i <- 0 until m) {
            for (j <- 0 until n) {
                if (backtrack(board, word, m, n, i, j, 0)) {
                    return true
                }
            }
        }
        false
    }

    def backtrack(board: Array[Array[Char]], word: String, m: Int, n: Int, i: Int, j: Int, pos: Int): Boolean = {
        if (i < 0 || i >= m || j < 0 || j >= n || board(i)(j) != word.charAt(pos)) {
            return false
        }

        if (pos == word.length - 1) {
            return true
        }

        val cur = board(i)(j)
        board(i)(j) = '#'

        val found = backtrack(board, word, m, n, i + 1, j, pos + 1) ||
          backtrack(board, word, m, n, i - 1, j, pos + 1) ||
          backtrack(board, word, m, n, i, j + 1, pos + 1) ||
          backtrack(board, word, m, n, i, j - 1, pos + 1)

        board(i)(j) = cur

        found
    }


}
