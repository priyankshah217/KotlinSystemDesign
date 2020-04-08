import com.coding.challenge.exceptions.EmptyListException
import com.coding.challenge.model.*
import com.coding.challenge.services.ExpenseService
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExpenseServiceTest {

    @Test
    fun `calculate monthly subscription for all news papers`() {
        val expenseService = ExpenseService()
        val actualMonthlyExpense = expenseService.calculateMonthlyExpense(
            listOf(
                TOI(),
                ET(),
                BM(),
                Hindu(),
                HT(),
                CarWash(),
                Amul()
            )
        )
        assertThat(actualMonthlyExpense).isEqualTo(1270.0)
    }

    @Test
    fun `calculate annual subscription for all news papers`() {
        val expenseService = ExpenseService()
        val actualMonthlyExpense = expenseService.calculateAnnualExpense(
            listOf(
                TOI(),
                ET(),
                BM(),
                Hindu(),
                HT(),
                Amul()
            )
        )
        assertThat(actualMonthlyExpense).isEqualTo(12840.0)
    }

    @Test
    fun `calculate weekly subscription for all news papers`() {
        val expenseService = ExpenseService()
        val actualWeeklyExpense = expenseService.calculateWeeklyExpense(
            listOf(
                TOI(),
                ET(),
                BM(),
                Hindu(),
                HT()
            )
        )
        assertThat(actualWeeklyExpense).isEqualTo(97.0)
    }

    @Test
    fun `calculate only one news paper`() {
        val expenseService = ExpenseService()
        val actualWeeklyExpense = expenseService.calculateWeeklyExpense(listOf(TOI()))
        assertThat(actualWeeklyExpense).isEqualTo(26.0)
    }

    @Test
    fun `exception when list has no items`() {
        val expenseService = ExpenseService()
        assertThrows<EmptyListException> { expenseService.calculateWeeklyExpense(emptyList()) }
    }
}