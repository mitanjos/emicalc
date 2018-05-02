package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.NAVStgBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface NAVStgRepo:JpaRepository<NAVStgBean,Int>{

    @Query(value = "select * from nav_stg where amfi_id=:amfiId",nativeQuery = true)
    fun findByAmfiId(@Param("amfiId")amfiId:String):NAVStgRepo
}