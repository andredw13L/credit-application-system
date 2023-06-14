package me.dio.credit.application.system.service.implemented

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.exceptions.BusinessException
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*


@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {

        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }

        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerID: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerID)


    override fun findByCreditCode(customerID: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("Credit code $creditCode  not found"))

        return if (credit.customer?.id == customerID) credit
        else throw IllegalArgumentException("Contact admin")
    }
}