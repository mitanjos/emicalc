package com.finapp.kjoshi.bean

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="fund_nav_mst")
class FundNAVBean:Comparable<FundNAVBean>{
    override fun compareTo(other: FundNAVBean): Int {
        return if(navDate.isBefore(other.navDate)) {
            -1
        }
        else if (!navDate.isAfter(other.navDate)) {
            1
        } else {
            0
        }
    }

    @Id
    @Column
    var id=0;

    @Column(name="amfiId")
    var amfiId=""

    @Column(name="nav_date")
    var navDate=LocalDate.now()

    @Column(name="nav_value")
    var navValue=0.0

    @Column(name="price_repurchase")
    var repurchasePrice=0.0

    @Column(name="price_sell")
    var sellPrice=0.0
}