package com.finapp.kjoshi.service

import com.finapp.kjoshi.bean.NAVStgBean
import org.springframework.stereotype.Service

@Service
class DataProcessingService{

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
            stgBean.priceRepurchase = rowData[7]
            stgBean.priceSell = rowData[8]
            stgBean.navDate = rowData[9]
            returnList.add(stgBean)
        }
        return returnList
    }
}