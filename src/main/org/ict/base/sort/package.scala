package org.ict.base

import scala.annotation.tailrec

/**
 * @author sniper
 * @date 28 Nov, 2022 
 */
package object sort {

    def msort[A](xs: List[A])(implicit ord: Ordering[A]): List[A] = {

        /** returns if a less than b */
        def less(a: A, b: A): Boolean = ord.lt(a, b)

        @tailrec /** prepend smaller element to accumulator then return it when one half is empty */
        def merge(xs: List[A], ys: List[A], acc: List[A]): List[A] = (xs, ys) match {
            case (Nil, _) => ys.reverse ::: acc
            case (_, Nil) => xs.reverse ::: acc
            case (x :: xs1, y :: ys1) =>
              if (less(x, y)) merge(xs1, ys, x :: acc) else merge(xs, ys1, y :: acc)
        }

        val n = xs.length / 2
        if (n == 0) xs else {
            val (ys, zs) = xs splitAt n
            merge (msort(ys), msort(zs), Nil).reverse
        }
    }

}
