package com.coding.challenge.services

import com.coding.challenge.exceptions.EmptyListException
import com.coding.challenge.model.*

class ExpenseService {

    fun calculateAnnualExpense(list: List<Category>): Double {
        if (list.isEmpty())
            throw EmptyListException("List should not be empty")
        return list.map {
            val subscription = when (it) {
                is PeriodicCategory -> {
                    PeriodicSubscriptionService()
                }
                else -> {
                    NonPeriodicSubscriptionService()
                }
            }
            subscription.annualSubscriptionCost(it)
        }.sum()
    }

    fun calculateMonthlyExpense(list: List<Category>): Double {
        if (list.isEmpty())
            throw EmptyListException("List should not be empty")
        return list.map {
            val subscription = when (it) {
                is PeriodicCategory -> {
                    PeriodicSubscriptionService()
                }
                else -> {
                    NonPeriodicSubscriptionService()
                }
            }
            subscription.monthlySubscriptionCost(it)
        }.sum()
    }

    fun calculateWeeklyExpense(list: List<Category>): Double {
        if (list.isEmpty())
            throw EmptyListException("List should not be empty")
        return list.map {
            val subscription = when (it) {
                is PeriodicCategory -> {
                    PeriodicSubscriptionService()
                }
                else -> {
                    NonPeriodicSubscriptionService()
                }
            }
            subscription.weeklySubscriptionCost(it)
        }.sum()
    }
}

fun main() {
    val expenseService = ExpenseService()
    println(
        expenseService.calculateWeeklyExpense(
            listOf(
                TOI(),
                ET(),
                BM(),
                Hindu(),
                HT()
            )
        )
    )
    println(
        expenseService.calculateMonthlyExpense(
            listOf(
                TOI(),
                ET(),
                BM(),
                Hindu(),
                HT()
            )
        )
    )
}