package com.finapp.kjoshi.dto

import com.finapp.kjoshi.bean.FundDetailsBean
import com.finapp.kjoshi.bean.FundNAVBean
import java.time.LocalDate

class FundCompleteDetailsDTO{

    lateinit var amfiId:String
    lateinit var fundName:String
    lateinit var growthISIN:String
    lateinit var dividentISIN:String
    private var navValue = 0.0
    lateinit var navDate:LocalDate


    constructor(fundDetailsBean: FundDetailsBean,fundNAVBean: FundNAVBean){
        amfiId = fundDetailsBean.amfiId
        fundName = fundDetailsBean.fundName
        growthISIN = fundDetailsBean.growthISIN
        dividentISIN = fundDetailsBean.repayISIN
        navValue = fundNAVBean.navValue
        navDate = fundNAVBean.navDate
    }
}