package org.ict.base.stack

import scala.collection.mutable.ArrayDeque


/**
 * @author sniper
 * @date 05 Sep 2023
 * LC150, Medium, frequency=75
 */
object EvaluateReversePolishNotation {
    /**
     * Time Cost 489ms
     * @param tokens
     * @return
     */
    def evalRPN(tokens: Array[String]): Int = {
        if (tokens.length == 1) {
            return tokens(0).toInt
        }

        val stack = new ArrayDeque[Int]()

        for (s <- tokens) {
            s match {
                case "+" =>
                    val numberOne = stack.removeLast()
                    val numberTwo = stack.removeLast()
                    stack += (numberTwo + numberOne)

                case "-" =>
                    val numberOne = stack.removeLast()
                    val numberTwo = stack.removeLast()
                    stack += (numberTwo - numberOne)

                case "*" =>
                    val numberOne = stack.removeLast()
                    val numberTwo = stack.removeLast()
                    stack += (numberTwo * numberOne)

                case "/" =>
                    val numberOne = stack.removeLast()
                    val numberTwo = stack.removeLast()
                    stack += (numberTwo / numberOne)
                case _ =>
                    stack += (s.toInt)
            }
        }

        stack.removeLast()
    }
}
