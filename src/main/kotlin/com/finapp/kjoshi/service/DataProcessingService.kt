package com.finapp.kjoshi.service

import com.finapp.kjoshi.bean.NAVStgBean
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DataProcessingService{

    private val logger = LoggerFactory.getLogger(DataProcessingService::class.java)

    fun createStagingData(rawData:List<String>): MutableList<NAVStgBean> {
        var returnList:MutableList<NAVStgBean> = ArrayList()
        rawData.stream().forEach{
            x -> val rowData = x.split(';')
            var stgBean = NAVStgBean()
            stgBean.fundType = rowData[0]
            stgBean.fundHouse = rowData[1]
            stgBean.amfiId = rowData[2]
            stgBean.isinGrowth = rowData[3]
            stgBean.isinDiv = rowData[4]
            stgBean.fundName = rowData[5]
            stgBean.nav = rowData[6]
            stgBean.navDate = rowData[7]
            returnList.add(stgBean)
        }
        logger.info("Returning {} results",returnList.size)
        return returnList
    }
}