package com.finapp.kjoshi.controller

import com.finapp.kjoshi.bean.ProductBean
import com.finapp.kjoshi.repository.ProductRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/product")
class ProductController{

    private val logger = LoggerFactory.getLogger(ProductController::class.java)

    @Autowired
    lateinit var repo:ProductRepo

    @RequestMapping("/", method = [(RequestMethod.GET)])
    fun listProducts(): MutableList<ProductBean>? {
        logger.info("Getting all product list")
        return repo.findAll()
    }

    @RequestMapping("/", method = [(RequestMethod.POST)])
    fun createProducts(@RequestBody productBean: ProductBean): ProductBean? {
        logger.info("Returingin product for productId: {} and productName:{}",productBean.id,productBean.name)
        return repo.save(productBean)
    }

}