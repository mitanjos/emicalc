package com.finapp.kjoshi.bean

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "portfolio")
class PortfolioBean{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id=0

    @Column(name="customer_profile_id")
    lateinit var customerProfileId:String

    @Column(name="amfi_id")
    lateinit var amfiId:String

    @Column(name="no_of_units")
    var units=0.0

    @Column(name="created_by")
    var createdBy = "SYSTEM"

    @Column(name="created_on")
    var createdOn = LocalDate.now()
}