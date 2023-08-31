package org.ict.base.dfs

/**
 * @author sniper
 * @date 31 Aug 2023
 * LC200, Medium, frequency=306
 */
object NumberOfIslands {

  /**
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
