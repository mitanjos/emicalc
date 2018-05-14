package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.CustomerBean
import com.finapp.kjoshi.repository.CustomerRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
class CustomerController{

    private val logger = LoggerFactory.getLogger(CustomerController::class.java)

    @Autowired
    lateinit var customerRepo:CustomerRepo

    //@RequestMapping("/",method = [RequestMethod.POST])
    fun createCustomer(@RequestBody customerBean:CustomerBean): CustomerBean? {
        logger.info("Creating customer entry")
        return customerRepo.save(customerBean)
    }

    //@RequestMapping("/{profileId}",method = [RequestMethod.GET])
    fun getCustomerDetails(@PathVariable("profileId")profileId:String): CustomerBean {
        logger.info("Getting information about customer:{}",profileId)
        return customerRepo.findByProfileId(profileId)
    }
}