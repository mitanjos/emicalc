package com.finapp.kjoshi.bean

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="fund_details_mst")
class FundDetailsBean{

    @Id
    @Column
    var id=0;

    @Column(name="amfiId")
    var amfiId=""

    @Column(name="fund_name")
    var fundName=""

    @Column(name="fund_type")
    var fundType=""

    @Column(name="fund_house")
    var fundHouse=""

    @Column(name="isin_growth")
    var growthISIN=""

    @Column(name="isin_div")
    var repayISIN=""


}
