package com.finapp.kjoshi.repository

import com.finapp.kjoshi.bean.ProductBean
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepo : JpaRepository<ProductBean, Int>