package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.FundNAVBean
import com.finapp.kjoshi.bean.NAVStgBean
import com.finapp.kjoshi.repository.FundNAVRepo
import com.finapp.kjoshi.repository.NAVStgRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/nav")
class FundNAVController{

    private val logger = LoggerFactory.getLogger(FundNAVController::class.java)

    @Autowired
    lateinit var repo:FundNAVRepo

    @RequestMapping("/{amfiId}")
    fun getNAVDataByAmfiId(@PathVariable("amfiId")amfiId:String): List<FundNAVBean> {
        logger.info("Getting data for amfiId:{}",amfiId)
        return repo.findByAmfiIdOrderByNavDateDesc(amfiId)
    }
}