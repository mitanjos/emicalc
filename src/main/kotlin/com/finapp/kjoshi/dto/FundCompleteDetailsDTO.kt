package com.finapp.kjoshi.dto

import com.finapp.kjoshi.bean.FundDetailsBean
import com.finapp.kjoshi.bean.FundNAVBean

class FundCompleteDetailsDTO{

     var amfiId:String
     var fundName:String
     var growthISIN:String
     var dividentISIN:String
     var priceHistory:List<FundNavDTO>


    constructor(fundDetailsBean: FundDetailsBean,fundNAVBeanList: List<FundNAVBean>){
        amfiId = fundDetailsBean.amfiId
        fundName = fundDetailsBean.fundName
        growthISIN = fundDetailsBean.growthISIN
        dividentISIN = fundDetailsBean.repayISIN
        var priceList:MutableList<FundNavDTO> = ArrayList()
        fundNAVBeanList.stream().forEach {
            fundNavBean -> priceList.add(FundNavDTO(fundNavBean.navDate,fundNavBean.navValue))
        }
        priceHistory = priceList
    }
}