package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.FundDetailsBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FundDetailsRepo : JpaRepository<FundDetailsBean,Int>{
    fun findByAmfiId(amfiId:String):List<FundDetailsBean>

    @Query("select distinct fund_type from fund_details_mst",nativeQuery = true)
    fun findFundTypes():List<String>

    @Query("select distinct fund_name from fund_details_mst",nativeQuery = true)
    fun findFundNames():List<String>

    @Query("select distinct fund_house from fund_details_mst",nativeQuery = true)
    fun findFundHouses():List<String>

    fun findByFundNameIgnoreCaseContaining(fundName:String):List<FundDetailsBean>
}