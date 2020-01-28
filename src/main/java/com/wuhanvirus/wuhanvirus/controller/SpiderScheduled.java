package com.wuhanvirus.wuhanvirus.controller;

import com.wuhanvirus.wuhanvirus.entity.ImportDataListEntity;
import com.wuhanvirus.wuhanvirus.service.ImportDataService;
import com.wuhanvirus.wuhanvirus.service.impl.ImportDataImpl;
import com.wuhanvirus.wuhanvirus.spiderManager.IImportDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时爬虫程序
 * Created by zhong on 2020-1-23.
 */
@Component
public class SpiderScheduled {

    @Autowired
    IImportDataManager importDataManager;

    @Autowired
    ImportDataService importDataService;

    /**
     * 开始时10秒钟一次
     */

    //@Scheduled(cron = "0/10 * * * * ?")
    //@Scheduled(cron = "0 0 0/1 * * ?")
    public void importRealTimeData(){
       ImportDataListEntity dataListEntity = importDataManager.getRealTimeData();
       importDataService.importData(dataListEntity);
    }
}
