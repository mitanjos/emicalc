package com.finapp.kjoshi.bean

import javax.persistence.*

@Entity
@Table(name = "nav_stg")
class NAVStgBean{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0

    @Column(name = "fund_type")
    var fundType=""

    @Column(name = "fund_house")
    var fundHouse=""

    @Column(name = "amfi_id")
    var amfiId=""

    @Column(name = "isin_div")
    var isinDiv=""

    @Column(name = "isin_growth")
    var isinGrowth=""

    @Column(name = "fund_name")
    var fundName=""

    @Column(name = "nav")
    var nav=""

    @Column(name = "price_repurchase")
    var priceRepurchase=""

    @Column(name = "price_sell")
    var priceSell=""

    @Column(name = "nav_date")
    var navDate=""
}