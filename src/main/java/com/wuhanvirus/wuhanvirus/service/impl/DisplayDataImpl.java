package com.wuhanvirus.wuhanvirus.service.impl;

import com.wuhanvirus.wuhanvirus.DO.ImportDataDo;
import com.wuhanvirus.wuhanvirus.dao.DataDao;
import com.wuhanvirus.wuhanvirus.service.DisplayDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by zhong on 2020-1-24.
 */
@Service
public class DisplayDataImpl implements DisplayDataService {
    @Autowired
    DataDao dataDao;

    @Override
    public List<ImportDataDo> getData(String province) {
        List<ImportDataDo> importDataDoList = dataDao.getData(province);
        for(ImportDataDo importDataDo:importDataDoList){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH点");
            importDataDo.setUpdateTimeStr(formatter.format(importDataDo.getUpdateTime()));
        }
        return importDataDoList;
    }
}
