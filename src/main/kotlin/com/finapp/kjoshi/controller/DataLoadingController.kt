package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.NAVStgBean
import com.finapp.kjoshi.service.DataLoadingService
import com.finapp.kjoshi.service.DataProcessingService
import com.finapp.kjoshi.service.NavStgService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/data")
class DataLoadingController{

    @Autowired
    lateinit var loadingService: DataLoadingService

    @Autowired
    lateinit var dataProcessingService: DataProcessingService

    @Autowired
    lateinit var navStgService: NavStgService

    private val logger = LoggerFactory.getLogger(DataLoadingController::class.java)

    @RequestMapping("/load")
    fun loadData(): MutableList<NAVStgBean>? {
        logger.info("Loaing data from remote url")
        val rawData = loadingService.loadDataFromUrl()
        logger.info("Data loaded from remote url")
        val stgData = dataProcessingService.createStagingData(rawData)
        return navStgService.loadData(stgData)
    }

}