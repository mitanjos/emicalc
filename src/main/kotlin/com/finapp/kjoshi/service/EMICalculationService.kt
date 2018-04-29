package com.finapp.kjoshi.service

import com.finapp.kjoshi.bean.EMIDetails
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EMICalculationService{

    private val logger = LoggerFactory.getLogger(EMICalculationService::class.java)

    fun calculateEMI(principal: Int,r:Double,n:Int):Double{
        val temp = Math.pow((1+(r/1200)),n.toDouble())
        val numerator = principal * (r/1200) * temp
        val denominator = temp-1
        val emi = numerator/denominator
        logger.info("Calculated emi will be ${emi}")
        return emi
    }

    fun generateAmmortizationSchedule(p:Int,r:Double,emi:Double):List<EMIDetails>{
        var emiList:MutableList<EMIDetails> = ArrayList()
        var remainingPrincipal = p
        var calculatedEmi = emi
        while(remainingPrincipal>0){
            val interestPart = remainingPrincipal*r/1200
            if(calculatedEmi<remainingPrincipal+interestPart){
                val principalPart = emi.toInt() - interestPart.toInt()
                emiList.add(EMIDetails(calculatedEmi.toInt(),principalPart,interestPart.toInt()))
                remainingPrincipal = (remainingPrincipal - principalPart).toInt()
            }else{
                calculatedEmi = remainingPrincipal+interestPart
                emiList.add(EMIDetails(calculatedEmi.toInt(),remainingPrincipal,interestPart.toInt()))
                remainingPrincipal = 0
            }

            logger.debug("Remaining P: $remainingPrincipal")
        }
        return emiList
    }
}