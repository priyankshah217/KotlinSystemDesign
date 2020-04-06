class ExpenseService {

    fun calculateMonthlyExpense(list: List<Category>): Float {
        if (list.isEmpty())
            throw EmptyListException("List should not be empty")
        return list.map { it.monthlySubscriptionCost() }.sum()
    }

    fun calculateWeeklyExpense(list: List<Category>): Float {
        if (list.isEmpty())
            throw EmptyListException("List should not be empty")
        return list.map { it.weeklySubscriptionCost() }.sum()
    }
}

fun main() {
    val expenseService = ExpenseService()
    println(expenseService.calculateWeeklyExpense(listOf(TOI(), ET(), BM(), Hindu(), HT())))
    println(expenseService.calculateMonthlyExpense(listOf(TOI(), ET(), BM(), Hindu(), HT())))
}