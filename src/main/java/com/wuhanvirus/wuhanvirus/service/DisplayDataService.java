package com.wuhanvirus.wuhanvirus.service;

import com.wuhanvirus.wuhanvirus.DO.ImportDataDo;

import java.util.List;

/**
 * Created by zhong on 2020-1-24.
 */
public interface DisplayDataService {
    List<ImportDataDo> getData(String province);

    ImportDataDo getLastData(String province);
}
