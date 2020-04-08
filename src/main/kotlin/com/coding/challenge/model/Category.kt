package com.coding.challenge.model

import com.coding.challenge.enums.Frequency
import com.coding.challenge.services.NonPeriodicSubscriptionService
import com.coding.challenge.services.PeriodicSubscriptionService
import com.coding.challenge.services.Subscription
import java.time.DayOfWeek
import java.util.*

abstract class Category(var defaultUnitCost: Double, var hasFreq: Frequency) {
    var name: String = ""
    var subscription: Subscription? = null
    var dayWisePrice: EnumMap<DayOfWeek, Double> = EnumMap(DayOfWeek::class.java)

    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SUNDAY] = defaultUnitCost
    }
}

abstract class PeriodicCategory(defaultUnitCost: Double, hasFreq: Frequency) : Category(defaultUnitCost, hasFreq) {
    init {
        this.subscription = PeriodicSubscriptionService()
    }
}

abstract class NonPeriodicCategory(defaultUnitCost: Double, hasFreq: Frequency = Frequency.NONPERIODIC) :
    Category(defaultUnitCost, hasFreq) {
    init {
        this.subscription = NonPeriodicSubscriptionService()
    }
}

abstract class NewsPaper(defaultUnitCost: Double, hasFreq: Frequency) : PeriodicCategory(defaultUnitCost, hasFreq)

abstract class VehicleWash(defaultUnitCost: Double) : NonPeriodicCategory(defaultUnitCost)

abstract class Dairy(defaultUnitCost: Double, hasFreq: Frequency) : PeriodicCategory(defaultUnitCost, hasFreq)

class Amul(defaultUnitCost: Double = 22.0, hasFreq: Frequency = Frequency.DAILY) : Dairy(defaultUnitCost, hasFreq)

class TOI(defaultUnitCost: Double = 3.0, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = 5.0
        dayWisePrice[DayOfWeek.SUNDAY] = 6.0
    }
}

class Hindu(defaultUnitCost: Double = 2.5, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = 4.0
        dayWisePrice[DayOfWeek.SUNDAY] = 4.0
    }
}

class ET(defaultUnitCost: Double = 2.0, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SUNDAY] = 10.0
    }
}

class BM(defaultUnitCost: Double = 1.5, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SUNDAY] = defaultUnitCost
    }
}

class HT(defaultUnitCost: Double = 2.0, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = 4.0
        dayWisePrice[DayOfWeek.SUNDAY] = 4.0
    }
}

class CarWash(defaultUnitCost: Double = 200.0) : VehicleWash(defaultUnitCost)