package com.finapp.kjoshi.bean

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Product")
class ProductBean : Serializable
{

    @Id
    @Column(name="id")
    lateinit var id:Number

    @Column
    lateinit var name:String
}