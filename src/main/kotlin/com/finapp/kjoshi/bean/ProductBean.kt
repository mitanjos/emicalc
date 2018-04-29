package com.finapp.kjoshi.bean

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Product")
class ProductBean
{

    @Id
    lateinit var id:Number

    @Column
    lateinit var name:String
}