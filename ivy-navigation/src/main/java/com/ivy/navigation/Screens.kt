package com.ivy.navigation

import com.ivy.core.data.db.entity.TransactionType
import com.ivy.core.data.model.Transaction
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.util.UUID

object Main : Screen

object Onboarding : Screen

data class CSVScreen(
    val launchedFromOnboarding: Boolean
) : Screen

data class EditTransaction(
    val initialTransactionId: UUID?,
    val type: TransactionType,

    // extras
    val accountId: UUID? = null,
    val categoryId: UUID? = null
) : Screen

data class ItemStatistic(
    val accountId: UUID? = null,
    val categoryId: UUID? = null,
    val unspecifiedCategory: Boolean? = false,
    val transactionType: TransactionType? = null,
    val accountIdFilterList: List<UUID> = persistentListOf(),
    val transactions: List<Transaction> = persistentListOf()
) : Screen

data class PieChartStatistic(
    val type: TransactionType,
    val filterExcluded: Boolean = true,
    val accountList: ImmutableList<UUID> = persistentListOf(),
    val transactions: ImmutableList<Transaction> = persistentListOf(),
    val treatTransfersAsIncomeExpense: Boolean = false
) : Screen

data class EditPlanned(
    val plannedPaymentRuleId: UUID?,
    val type: TransactionType,
    val amount: Double? = null,
    val accountId: UUID? = null,
    val categoryId: UUID? = null,
    val title: String? = null,
    val description: String? = null,
) : Screen {
    fun mandatoryFilled(): Boolean {
        return amount != null && amount > 0.0 &&
                accountId != null
    }
}

object BalanceScreen : Screen

object PlannedPayments : Screen

object Categories : Screen

object Settings : Screen

data class Import(
    val launchedFromOnboarding: Boolean
) : Screen

object Report : Screen

object BudgetScreen : Screen

object Loans : Screen

object Search : Screen

data class LoanDetails(
    val loanId: UUID
) : Screen

object Test : Screen

object ExchangeRatesScreen : Screen

object DonateScreen : Screen