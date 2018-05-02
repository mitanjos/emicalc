package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.ProductBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepo : JpaRepository<ProductBean, Int>