package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.enummeration.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val emailCostumer: String?,
    val incomeCostumer: BigDecimal?
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCostumer = credit.customer?.email,
        incomeCostumer = credit.customer?.income
    )
}
