package cn.ict.base.sfti
/**
 * [hanxuelian@ict scala]$ scalac  ./cn/ict/base/sfti/Chapter1.scala 
 * [hanxuelian@ict scala]$ scala  cn.ict.base.sfti.Chapter1
 * crazycrazycrazy
 * [hanxuelian@ict scala]$ pwd
 * /home/hanxuelian/Public/scala-base/src/main/scala
 *
 */


import BigInt.probablePrime
import util.Random
object Chapter1 extends App {
  println("crazy*3:"+"crazy"*3)
  println("BigInt(2).pow(1024):"+BigInt(2).pow(1024))
  println("probablePrime(100, Random):"+probablePrime(100,Random)) 
  println("BigInt.apply(Random.nextInt).toString(36):"+BigInt.apply(Random.nextInt).toString(36))
  
  var hello : String = "Hello, World!"
  println("hello content:"+hello)
  println("hello.head:"+hello.head)
  println("hello.last:"+hello.last)
  println("hello.take(1):"+hello.take(1))
  println("hello.takeRight(1):"+hello.takeRight(1))
  println("hello.drop(6):"+hello.drop(6))
  println("hello.dropRight(7)"+hello.dropRight(7))
}
