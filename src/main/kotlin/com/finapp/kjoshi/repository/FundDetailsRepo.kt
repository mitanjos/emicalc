package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.FundDetailsBean
import org.springframework.data.jpa.repository.JpaRepository

interface FundDetailsRepo : JpaRepository<FundDetailsBean,Int>{
    fun findByAmfiId(amfiId:String):List<FundDetailsBean>
}