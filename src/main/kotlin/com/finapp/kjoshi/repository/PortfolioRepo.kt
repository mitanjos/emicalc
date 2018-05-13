package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.PortfolioBean
import org.springframework.data.jpa.repository.JpaRepository

interface PortfolioRepo : JpaRepository<PortfolioBean,Int>
{
    fun findByCustomerProfileId(profileId:String):List<PortfolioBean>
}