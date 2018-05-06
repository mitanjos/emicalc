package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.FundNAVBean
import org.springframework.data.jpa.repository.JpaRepository

interface FundNAVRepo:JpaRepository<FundNAVBean,Int>{
    fun findByAmfiIdOrderByNavDateDesc(amfiId:String):List<FundNAVBean>
}