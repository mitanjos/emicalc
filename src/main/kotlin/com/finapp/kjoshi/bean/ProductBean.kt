package com.finapp.kjoshi.bean

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Product")
internal data class ProductBean(@Id
                                @Column(name="id")
                                var id:Number,
                                @Column
                                var name:String)
