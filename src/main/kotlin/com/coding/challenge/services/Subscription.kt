package com.coding.challenge.services

import com.coding.challenge.model.Category

interface Subscription {
    fun monthlySubscriptionCost(category: Category): Double
    fun annualSubscriptionCost(category: Category): Double
    fun weeklySubscriptionCost(category: Category): Double
}
