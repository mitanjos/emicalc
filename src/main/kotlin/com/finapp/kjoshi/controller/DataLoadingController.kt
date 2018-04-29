package com.finapp.kjoshi.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/api/v1/data")
class DataLoadingController{

    @Autowired
    lateinit var restTemplate:RestTemplate

    private val logger = LoggerFactory.getLogger(DataLoadingController::class.java)

    @RequestMapping("/load")
    fun loadData(): List<String> {
        logger.info("Loaing data from remote url")
        val response = restTemplate.getForEntity("https://www.amfiindia.com/spages/NAVOpen.txt?t=29042018074901",String::class.java)
        if(response.statusCode == HttpStatus.OK)
        {
            logger.info("Got the data from response")
            return parseData(response.body)
        }else{
            logger.warn("Error occured while loading data and status is {}",response.statusCode)
            return listOf("ERROR")
        }
    }

    private fun parseData(str:String): MutableList<String> {
        var lastStr = ""
        var fundHouseName= ""
        var fundType = ""
        logger.info(str.split('\n').size.toString())
        var returnArrayList:MutableList<String> = ArrayList()
        str.split('\n').stream().filter{x -> !x.trim().isEmpty() }.skip(1).forEach{
            x -> if(lastStr.isEmpty())
            fundType = x
            if(x.indexOf(';')<0){
                if(lastStr.indexOf(';')<0){
                    fundHouseName = x
                    fundType = lastStr
                }else{
                    fundHouseName = lastStr
                }
            }
            else{
                if(lastStr.indexOf(';')<0){
                    fundHouseName = lastStr
                }
                val retString = "${fundType.trim()};${fundHouseName.trim()};${x.trim()}"
                returnArrayList.add(retString)
                logger.info(retString)
            }
            lastStr = x

        }
        return returnArrayList
    }

}