package com.wuhanvirus.wuhanvirus.service.impl;

import com.wuhanvirus.wuhanvirus.DO.ImportDataDo;
import com.wuhanvirus.wuhanvirus.dao.DataDao;
import com.wuhanvirus.wuhanvirus.entity.ImportDataEntity;
import com.wuhanvirus.wuhanvirus.entity.ImportDataListEntity;
import com.wuhanvirus.wuhanvirus.service.ImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhong on 2020-1-24.
 */
@Service
public class ImportDataImpl implements ImportDataService {

    @Autowired
    DataDao dataDao;

    @Override
    public void importData(ImportDataListEntity importDataListEntity) {
        ImportDataDo nationImportDataDo = new ImportDataDo();
        int nationConfirm = 0;
        int nationSuspect = 0;
        int nationDead = 0;
        int nationHeal = 0;

        for (ImportDataEntity importDataEntity : importDataListEntity.getImportDataListEntityList()) {
            ImportDataDo importDataDo = new ImportDataDo();
            importDataDo.setProvince(importDataEntity.getProvinceShortName());
            importDataDo.setConfirm(importDataEntity.getConfirmedCount());
            importDataDo.setDead(importDataEntity.getDeadCount());
            importDataDo.setHeal(importDataEntity.getHealCount());
            importDataDo.setSuspect(importDataEntity.getSuspectedCount());

            nationConfirm += importDataDo.getConfirm();
            nationSuspect += importDataDo.getSuspect();
            nationDead += importDataDo.getDead();
            nationHeal += importDataDo.getHeal();
            dataDao.insertData(importDataDo);
            //System.out.println(importDataDo);
        }

        // 统计全国情况
        nationImportDataDo.setProvince("全国");
        nationImportDataDo.setConfirm(nationConfirm);
        nationImportDataDo.setSuspect(nationSuspect);
        nationImportDataDo.setDead(nationDead);
        nationImportDataDo.setHeal(nationHeal);
        dataDao.insertData(nationImportDataDo);
    }
}
