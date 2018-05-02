package com.finapp.kjoshi.controller

import com.finapp.kjoshi.repository.NAVStgRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/nav")
class NAVController{

    private val logger = LoggerFactory.getLogger(NAVController::class.java)

    @Autowired
    lateinit var repo:NAVStgRepo

    @RequestMapping("/fund/{amfiId}")
    fun getNAVDataByAmfiId(@PathVariable("amfiId")amfiId:String): NAVStgRepo {
        logger.info("Getting data for amfiId:{}",amfiId)
        return repo.findByAmfiId(amfiId)
    }

    @RequestMapping("/cnt")
    fun getCountOfRecords(): Long {
        return repo.count()
    }
}