package com.finapp.kjoshi.bean

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "customer")
class CustomerBean{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id=0

    @Column(name="profile_id")
    lateinit var profileId:String

    @Column(name="first_name")
    lateinit var firstName:String

    @Column(name="last_name")
    lateinit var lastName:String

    @Column(name="created_by")
    var createdBy = "SYSTEM"

    @Column(name="created_on")
    var createdOn = LocalDate.now()
}