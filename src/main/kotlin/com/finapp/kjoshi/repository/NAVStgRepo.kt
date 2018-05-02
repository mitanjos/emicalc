package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.NAVStgBean
import org.springframework.data.jpa.repository.JpaRepository

interface NAVStgRepo:JpaRepository<NAVStgBean,Int>{
    fun findByAmfiId(amfiId:String):NAVStgRepo
}