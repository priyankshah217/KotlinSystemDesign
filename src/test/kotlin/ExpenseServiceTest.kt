import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExpenseServiceTest {

    @Test
    fun `calculate monthly subscription for all news papers`() {
        val expenseService = ExpenseService()
        val actualWeeklyExpense = expenseService.calculateMonthlyExpense(
            listOf(
                TOI(),
                ET(), BM(), Hindu(), HT(), CarWash(), Amul()
            )
        )
        assertThat(actualWeeklyExpense).isEqualTo(632.0f)
    }

    @Test
    fun `calculate weekly subscription for all news papers`() {
        val expenseService = ExpenseService()
        val actualWeeklyExpense = expenseService.calculateWeeklyExpense(listOf(TOI(), ET(), BM(), Hindu(), HT()))
        assertThat(actualWeeklyExpense).isEqualTo(97.0f)
    }

    @Test
    fun `calculate only one news paper`() {
        val expenseService = ExpenseService()
        val actualWeeklyExpense = expenseService.calculateWeeklyExpense(listOf(TOI()))
        assertThat(actualWeeklyExpense).isEqualTo(26.0f)
    }

    @Test
    fun `exception when list has no items`() {
        val expenseService = ExpenseService()
        assertThrows<EmptyListException> { expenseService.calculateWeeklyExpense(emptyList()) }
    }
}