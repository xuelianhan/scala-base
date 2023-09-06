package org.ict.base.design
import scala.collection.mutable.{HashMap, Map}
/**
 * @author sniper
 * @date 05 Sep 2023 
 */


class UndergroundSystem() {

    private val checkInIdName: Map[Int, CheckIn] = Map()

    private val fromTo: Map[String, CheckOut] = Map()

    def checkIn(id: Int, stationName: String, t: Int) {
        checkInIdName(id) = new CheckIn(stationName, t)
    }

    def checkOut(id: Int, stationName: String, t: Int) {
        val checkIn = checkInIdName(id)
        val trip = s"${checkIn.stationName}->${stationName}"
        val timeCost = t - checkIn.time
        fromTo.getOrElseUpdate(trip, new CheckOut(0, 0))
        val checkOut = fromTo(trip)
        checkOut.numberOfTrips += 1
        checkOut.totalTimeCost += timeCost
    }

    def getAverageTime(startStation: String, endStation: String): Double = {
        val trip = s"${startStation}->${endStation}"
        val checkOut = fromTo(trip)
        checkOut.totalTimeCost.toDouble / checkOut.numberOfTrips
    }

}

class CheckIn(val stationName: String, val time: Int)

class CheckOut(var totalTimeCost: Int, var numberOfTrips: Int)

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = new UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */