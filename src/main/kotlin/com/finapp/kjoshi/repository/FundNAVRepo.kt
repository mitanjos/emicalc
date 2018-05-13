package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.FundNAVBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FundNAVRepo:JpaRepository<FundNAVBean,Int>{

    fun findByAmfiIdOrderByNavDateDesc(amfiId:String):List<FundNAVBean>

    @Query(value="select * from latest_nav_data where amfi_id=:amfiId", nativeQuery = true)
    fun getNAVForFunds(amfiId: String):List<FundNAVBean>
}