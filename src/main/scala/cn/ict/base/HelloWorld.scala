package cn.ict.scala

/**
 * @author hanxuelian
 */
object HelloWorld extends App{
  var x = "123456".apply(5)
  var c = "S".count(_.isUpper)
  var s = "Harry".patch(1, "ung", 2)
  println("hello world!"+x+","+c+","+s)
}