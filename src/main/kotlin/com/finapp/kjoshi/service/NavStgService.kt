package com.finapp.kjoshi.service

import com.finapp.kjoshi.bean.NAVStgBean
import com.finapp.kjoshi.repository.NAVStgRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
open class NavStgService{

    private val logger = LoggerFactory.getLogger(NavStgService::class.java)

    @Autowired
    lateinit var stgRepo: NAVStgRepo

    fun loadData(navStgList:List<NAVStgBean>){
        logger.info("Loading data in tables")
        stgRepo.saveAll(navStgList)
    }
}