package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.CustomerBean
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepo : JpaRepository<CustomerBean,Int>
{
    fun findByProfileId(profileId:String):CustomerBean
}