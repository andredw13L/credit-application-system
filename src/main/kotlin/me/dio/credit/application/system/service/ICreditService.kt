package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerID: Long): List<Credit>

    fun findByCreditCode(customerID: Long ,creditCode: UUID): Credit?
}