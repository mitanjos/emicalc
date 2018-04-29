package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.ProductBean
import com.finapp.kjoshi.repository.ProductRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/product")
class ProductController{

    @Autowired
    lateinit var repo:ProductRepo

    @RequestMapping("/")
    fun listProducts(): MutableList<ProductBean>? {
        return repo.findAll()
    }
}