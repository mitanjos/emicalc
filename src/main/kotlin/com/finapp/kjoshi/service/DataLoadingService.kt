package com.finapp.kjoshi.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDateTime

@Service
class DataLoadingService{

    @Autowired
    lateinit var restTemplate: List<RestTemplate>

    private val logger = LoggerFactory.getLogger(DataLoadingService::class.java)


    fun loadDataFromUrl(): List<String> {
        val response = restTemplate[0].getForEntity("https://www.amfiindia.com/spages/NAVOpen.txt?t=29042018074901",String::class.java)
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
        logger.info("Response \n {}",str)
        logger.info("No of lines: {}",str.split('\n').size.toString())
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
        logger.info("Returning {} records",returnArrayList.size)
        return returnArrayList
    }


}