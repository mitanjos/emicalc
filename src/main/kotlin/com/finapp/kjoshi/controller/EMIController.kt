package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.EMIDetails
import com.finapp.kjoshi.service.EMICalculationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/emi")
class EMIController{

    @Autowired
    lateinit var emiCalcSvc:EMICalculationService

    @RequestMapping("/calculate")
    fun calculateEMI(@RequestParam("principal") p:Int,
                     @RequestParam("rate")r:Double,
                     @RequestParam("term")n:Int): List<EMIDetails> {

        val emi = emiCalcSvc.calculateEMI(p,r,n)

        return emiCalcSvc.generateAmmortizationSchedule(p,r,emi)
    }
}