package com.wuhanvirus.wuhanvirus.spiderManager.impl;

import com.wuhanvirus.common.util.HttpClientUtil;
import com.wuhanvirus.common.util.JsonUtil;
import com.wuhanvirus.wuhanvirus.DO.ImportDataDo;
import com.wuhanvirus.wuhanvirus.dao.DataDao;
import com.wuhanvirus.wuhanvirus.entity.ImportDataEntity;
import com.wuhanvirus.wuhanvirus.entity.ImportDataListEntity;
import com.wuhanvirus.wuhanvirus.spiderManager.IImportDataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhong on 2020-1-23.
 */

@Service
public class ImportDataManagerImpl implements IImportDataManager {

    Logger logger = LoggerFactory.getLogger(ImportDataManagerImpl.class);

    @Override
    public ImportDataListEntity getRealTimeData() {
        Map<String, String> headerMap = new LinkedHashMap<>();
        String str = HttpClientUtil.httpGet("https://3g.dxy.cn/newh5/view/pneumonia", headerMap, "utf-8");
        str = str.split("window.getAreaStat = ")[1];
        str = str.split("}catch")[0];

        str = "{\"importDataListEntityList\":" + str + "}";

        return (ImportDataListEntity) JsonUtil.jsonToObject(str, ImportDataListEntity.class);
    }

    //System.out.println(str);

}
