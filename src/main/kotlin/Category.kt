import java.time.DayOfWeek
import java.time.LocalDate
import java.util.*

abstract class Category(var defaultUnitCost: Float, var hasFreq: Frequency) : Subscription {
    var name: String = ""
}

abstract class PeriodicCategory(defaultUnitCost: Float, hasFreq: Frequency) : Category(defaultUnitCost, hasFreq) {
    override fun monthlySubscriptionCost(): Float {
        return this.defaultUnitCost * hasFreq.value
    }

    override fun weeklySubscriptionCost(): Float {
        return this.defaultUnitCost * 1
    }
}

abstract class NonPeriodicCategory(defaultUnitCost: Float, hasFreq: Frequency = Frequency.NONPERIODIC) :
    Category(defaultUnitCost, hasFreq) {
    override fun monthlySubscriptionCost(): Float {
        return this.defaultUnitCost * 1
    }

    override fun weeklySubscriptionCost(): Float {
        return this.defaultUnitCost * 1
    }
}

abstract class NewsPaper(defaultUnitCost: Float, hasFreq: Frequency) :
    PeriodicCategory(defaultUnitCost, hasFreq) {
    var dayWisePrice: EnumMap<DayOfWeek, Float> = EnumMap(DayOfWeek::class.java)

    override fun monthlySubscriptionCost(): Float {
        val listOfFloatValues = CalenderUtils.getDayOfMonth(LocalDate.now().year, LocalDate.now().month.value)
            ?.map { return@map dayWisePrice[it] }
        val listOfCostForAdditionalDays =
            listOfFloatValues?.stream()?.reduce { t: Float?, u: Float? -> u?.let { t?.plus(it) } }
        return listOfCostForAdditionalDays?.get()?.plus(4 * weeklySubscriptionCost())!!
    }

    override fun weeklySubscriptionCost(): Float {
        return dayWisePrice.map { it.value }.sum()
    }
}

abstract class VehicleWash(defaultUnitCost: Float) : NonPeriodicCategory(defaultUnitCost)

abstract class Dairy(defaultUnitCost: Float, hasFreq: Frequency) : PeriodicCategory(defaultUnitCost, hasFreq) {

}

class Amul(defaultUnitCost: Float = 22.0f, hasFreq: Frequency = Frequency.DAILY) : Dairy(defaultUnitCost, hasFreq)

class TOI(defaultUnitCost: Float = 3.0f, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = 5.0f
        dayWisePrice[DayOfWeek.SUNDAY] = 6.0f
    }
}

class Hindu(defaultUnitCost: Float = 2.5f, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = 4.0f
        dayWisePrice[DayOfWeek.SUNDAY] = 4.0f
    }
}

class ET(defaultUnitCost: Float = 2.0f, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SUNDAY] = 10.0f
    }
}

class BM(defaultUnitCost: Float = 1.5f, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
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

class HT(defaultUnitCost: Float = 2.0f, hasFreq: Frequency = Frequency.DAILY) : NewsPaper(defaultUnitCost, hasFreq) {
    init {
        dayWisePrice[DayOfWeek.MONDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.TUESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.WEDNESDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.THURSDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.FRIDAY] = defaultUnitCost
        dayWisePrice[DayOfWeek.SATURDAY] = 4.0f
        dayWisePrice[DayOfWeek.SUNDAY] = 4.0f
    }
}

class CarWash(defaultUnitCost: Float = 200.0f) : VehicleWash(defaultUnitCost)