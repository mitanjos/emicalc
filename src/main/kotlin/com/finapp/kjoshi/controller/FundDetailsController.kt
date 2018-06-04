package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.FundDetailsBean
import com.finapp.kjoshi.repository.FundDetailsRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/fund")
@CrossOrigin
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

    @RequestMapping("/fundHouses")
    fun getFundHouses(): List<String> {
        logger.info("Getting distinct fund names")
        return fundDetailsRepo.findFundHouses()
    }

    @RequestMapping("/search/fundName/{fundName}")
    fun getFundNameByFundName(@PathVariable("fundName")fundName:String): List<FundDetailsBean> {
        logger.info("Finding funds with name containing:{}",fundName)
        if(fundName == null || fundName.trim().length<3 || fundName.indexOf("%")>=0){
            return emptyList()
        }
        return fundDetailsRepo.findByFundNameIgnoreCaseContaining(fundName)
    }
}