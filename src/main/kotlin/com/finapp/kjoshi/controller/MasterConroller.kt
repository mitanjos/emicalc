package com.finapp.kjoshi.controller

import com.finapp.kjoshi.repository.FundDetailsRepo
import com.finapp.kjoshi.repository.FundNAVRepo
import com.finapp.kjoshi.repository.PortfolioRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.finapp.kjoshi.dto.FundCompleteDetailsDTO

@RestController
@RequestMapping("/api/v1/navdata/")
class MasterConroller{

    private val logger = LoggerFactory.getLogger(MasterConroller::class.java)

    @Autowired
    lateinit var portfolioRepo: PortfolioRepo

    @Autowired
    lateinit var fundDetailRepo: FundDetailsRepo

    @Autowired
    lateinit var fundNAVRepo: FundNAVRepo

    @RequestMapping("/portfolio/{profileId}")
    fun getFundInfoForProfileId(@PathVariable("profileId")profileId:String): MutableList<FundCompleteDetailsDTO> {
        logger.info("Getting data for profile:{}",profileId)
        val portfolioDetails = portfolioRepo.findByCustomerProfileId(profileId)
        var retList:MutableList<FundCompleteDetailsDTO> = ArrayList<FundCompleteDetailsDTO>()
        portfolioDetails.stream().map{
            portfoio -> {
                val amfiId = portfoio.amfiId
                logger.info("Getting data for AMFI ID:{}",amfiId)
                val fundDetails = fundDetailRepo.findByAmfiId(amfiId)
                logger.info("fund Details:{}",fundDetails)
                val fundNav = fundNAVRepo.getNAVForFunds(amfiId)
                logger.info("fund nav:{}",fundNav)
                if(fundDetails!=null && !fundDetails.isEmpty() && fundNav != null && !fundNav.isEmpty())
                {
                    val retDto = FundCompleteDetailsDTO(fundDetails[0],fundNav[0])
                    retList.add(retDto);
                }else{
                    throw Exception("Can not get information about portfolio")
                }
            }
        }
        logger.info("Got {} for profileId:{}",portfolioDetails,profileId)
        return retList
    }

    @RequestMapping("/amfiId/{amfiId}")
    fun getFundInfoForAMFIId(@PathVariable("amfiId")amfiId:String): FundCompleteDetailsDTO {
        logger.info("Getting all information for amfiId:{}",amfiId)
        val fundDetails = fundDetailRepo.findByAmfiId(amfiId)
        logger.info("Got fund Details:{}",fundDetails)
        val fundNav = fundNAVRepo.findByAmfiIdOrderByNavDateDesc(amfiId)
        logger.info("Got fund Latest NAV:{}",fundNav)
        return FundCompleteDetailsDTO(fundDetails[0],fundNav[0])
    }
}