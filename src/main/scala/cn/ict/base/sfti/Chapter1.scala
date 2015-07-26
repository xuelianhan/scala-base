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
  println("crazy"*3)
  println(BigInt(2).pow(1024))
  println(probablePrime(100,Random)) 
}
