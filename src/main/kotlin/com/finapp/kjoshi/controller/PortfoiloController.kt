package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.PortfolioBean
import com.finapp.kjoshi.repository.PortfolioRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/v1/portfolio")
class PortfoiloController{

    private val logger = LoggerFactory.getLogger(PortfoiloController::class.java)

    @Autowired
    lateinit var portfolioRepo: PortfolioRepo

    //@RequestMapping("/",method = [RequestMethod.POST])
    fun createPortfolio(@RequestBody portfolioBean: PortfolioBean): PortfolioBean? {
        logger.info("Creating customer entry")
        return portfolioRepo.save(portfolioBean)
    }

    //@RequestMapping("/{profileId}",method = [RequestMethod.GET])
    fun getPortfolioDetails(@PathVariable("profileId")profileId:String): List<PortfolioBean> {
        logger.info("Getting information about customer:{}",profileId)
        return portfolioRepo.findByCustomerProfileId(profileId)
    }
}