package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.FundDetailsBean
import com.finapp.kjoshi.bean.KeyValPair
import com.finapp.kjoshi.repository.FundDetailsRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/fund")
class FundDetailsController{

    @Autowired
    lateinit var fundDetailsRepo: FundDetailsRepo

    private val logger = LoggerFactory.getLogger(FundDetailsController::class.java)

    @RequestMapping(path = ["/{amfiId}"],method = [RequestMethod.GET])
    fun getFundDetail(@PathVariable("amfiId") amfiId:String): List<FundDetailsBean> {
        logger.info("Getting fund details for {}",amfiId)
        return fundDetailsRepo.findByAmfiId(amfiId)
    }

    @RequestMapping("/fundTypes")
    fun getFundTypes(): List<String> {
        logger.info("Getting distinct fund types")
        return fundDetailsRepo.findFundTypes()
    }

    @RequestMapping("/fundNames")
    fun getFundNames(): List<String> {
        logger.info("Getting distinct fund names")
        return fundDetailsRepo.findFundNames()
    }

    @RequestMapping("/search/fundName/{fundName}")
    fun getFundNameByFundName(@PathVariable("fundName")fundName:String): List<FundDetailsBean> {
        logger.info("Finding funds with name containing:{}",fundName)
        return fundDetailsRepo.findByFundNameIgnoreCaseContaining(fundName)
    }
}