package com.finapp.kjoshi.bean

import java.time.LocalDate
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
    var navValue:Double=0.0

    @Column(name="price_repurchase")
    var repurchasePrice:Double=0.0

    @Column(name="price_sell")
    var sellPrice:Double=0.0
}