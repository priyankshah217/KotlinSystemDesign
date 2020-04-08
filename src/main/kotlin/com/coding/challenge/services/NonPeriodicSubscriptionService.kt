package com.coding.challenge.services

import com.coding.challenge.model.Category

class NonPeriodicSubscriptionService : Subscription {
    override fun monthlySubscriptionCost(category: Category): Double {
        return category.defaultUnitCost
    }

    override fun annualSubscriptionCost(category: Category): Double {
        return category.defaultUnitCost
    }

    override fun weeklySubscriptionCost(category: Category): Double {
        return category.defaultUnitCost
    }
}