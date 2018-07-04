package com.finapp.kjoshi.service

import com.finapp.kjoshi.bean.NAVStgBean
import com.finapp.kjoshi.repository.NAVStgRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class NavStgService{

    private val logger = LoggerFactory.getLogger(NavStgService::class.java)

    @Autowired
    lateinit var stgRepo: NAVStgRepo


    fun loadData(navStgList:List<NAVStgBean>): MutableList<NAVStgBean>? {
        logger.info("Loading data in staging table")
        val retVal = stgRepo.saveAll(navStgList)
        logger.info("Data loaded in staging table")
        return retVal
    }
}