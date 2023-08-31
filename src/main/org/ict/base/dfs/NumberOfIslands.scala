package org.ict.base.dfs

import scala.collection.mutable.Queue

/**
 * @author sniper
 * @date 31 Aug 2023
 * LC200, Medium, frequency=306
 */
object NumberOfIslands {

  /**
   * BFS Solution
   * Time Cost 581ms
   * @param grid
   * @return
   */
  def numIslandsV1(grid: Array[Array[Char]]): Int = {
        var res = 0
        val m = grid.length
        val n = grid(0).length
        for (i <- 0 until m; j <- 0 until n) {
            if (grid(i)(j) == '1') {
                bfs(grid, i, j)
                res += 1
            }
        }
        res
    }

    private def bfs(grid: Array[Array[Char]], i: Int, j: Int) {
      grid(i)(j) = '0'
      val queue = Queue[(Int, Int)]()
      queue.enqueue((i, j))
      val dir = Array(-1, 0, 1, 0, -1)
      val m = grid.length
      val n = grid(0).length
      while (!queue.isEmpty) {
          val (x, y) = queue.dequeue()
          for (k <- 0 until 4) {
              val nx = x + dir(k)
              val ny = y + dir(k + 1)
              if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid(nx)(ny) != '1') {
                  // Skip visited or out-of-bounds cells
                  ()
              } else {
                  grid(nx)(ny) = '0'
                  queue.enqueue((nx, ny))
              }
          }
      }
    }

  /**
   * DFS Solution
   * Time Cost 556ms
   * @param grid
   * @return
   */
    def numIslands(grid: Array[Array[Char]]): Int = {
          if (grid == null) {
              return 0
          }
          var res = 0
          val m = grid.length
          val n = grid(0).length
          for (i <- 0 until m) {
              for (j <- 0 until n) {
                  if (grid(i)(j) == '1') {
                      dfs(grid, i, j)
                      res += 1
                  }
              }
          }
          res
      }

      private def dfs(grid: Array[Array[Char]], i: Int, j: Int): Unit = {
          if (i < 0 || j < 0 || i >= grid.length || j >= grid(0).length || grid(i)(j) != '1') {
              return
          }
          grid(i)(j) = '0'
          dfs(grid, i - 1, j)
          dfs(grid, i + 1, j)
          dfs(grid, i, j - 1)
          dfs(grid, i, j + 1)
      }

}
