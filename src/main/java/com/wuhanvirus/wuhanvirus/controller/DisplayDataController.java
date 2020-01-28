package com.wuhanvirus.wuhanvirus.controller;

import com.wuhanvirus.wuhanvirus.DO.ImportDataDo;
import com.wuhanvirus.wuhanvirus.service.DisplayDataService;
import com.wuhanvirus.wuhanvirus.service.ImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhong on 2020-1-24.
 */
@RestController
public class DisplayDataController {
    @Autowired
    DisplayDataService displayDataService;

    @RequestMapping(value = "/api/getData",method = RequestMethod.POST)
    public List<ImportDataDo> getData(String province) {
        return displayDataService.getData(province);
    }

    @RequestMapping(value = "/api/getLastData",method = RequestMethod.POST)
    public ImportDataDo getLastData(String province){
        return displayDataService.getLastData(province);
    }
}
