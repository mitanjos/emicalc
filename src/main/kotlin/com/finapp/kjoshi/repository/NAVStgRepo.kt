package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.NAVStgBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface NAVStgRepo:JpaRepository<NAVStgBean,Int>{
    fun findByAmfiId(@Param("amfiId")amfiId:String):List<NAVStgBean>
}