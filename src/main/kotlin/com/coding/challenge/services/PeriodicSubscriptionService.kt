package com.coding.challenge.services

import com.coding.challenge.model.Category
import com.coding.challenge.utils.CalenderUtils

open class PeriodicSubscriptionService : Subscription {

    override fun monthlySubscriptionCost(category: Category): Double {
        val listOfFloatValues = CalenderUtils.getRemainingDaysToCompleteAWeekInMonth()
            .map { category.dayWisePrice[it] }
        val listOfCostForAdditionalDays =
            listOfFloatValues.sumByDouble { it!! }
        return listOfCostForAdditionalDays.plus(4 * weeklySubscriptionCost(category))
    }

    override fun annualSubscriptionCost(category: Category): Double {
        return 12 * monthlySubscriptionCost(category)
    }

    override fun weeklySubscriptionCost(category: Category): Double {
        return category.dayWisePrice.map { it.value }.sum()
    }
}