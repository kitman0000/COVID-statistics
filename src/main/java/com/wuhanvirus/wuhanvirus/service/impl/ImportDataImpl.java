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
            String tag = importDataEntity.getTags();
            if (tag.contains("确诊")) {
                try {
                    String confirm = tag.split("确诊")[1].split("例")[0].replace(" ", "");
                    importDataDo.setConfirm(Integer.parseInt(confirm));
                    nationConfirm += importDataDo.getConfirm();
                } catch (Exception ex) {
                    importDataDo.setConfirm(-1);
                }
            }
            if (tag.contains("疑似")) {
                try {
                    String confirm = tag.split("疑似")[1].split("例")[0].replace(" ", "");
                    importDataDo.setSuspect(Integer.parseInt(confirm));
                    nationSuspect += importDataDo.getSuspect();
                } catch (Exception ex) {
                    importDataDo.setSuspect(-1);
                }
            }
            if (tag.contains("死亡")) {
                try {
                    String confirm = tag.split("死亡")[1].split("例")[0].replace(" ", "");
                    importDataDo.setDead(Integer.parseInt(confirm));
                    nationDead += importDataDo.getDead();
                } catch (Exception ex) {
                    importDataDo.setDead(-1);
                }
            }
            if (tag.contains("治愈")) {
                try {
                    String confirm = tag.split("治愈")[1].split("例")[0].replace(" ", "");
                    importDataDo.setHeal(Integer.parseInt(confirm));
                    nationHeal += importDataDo.getHeal();
                } catch (Exception ex) {
                    importDataDo.setHeal(-1);
                }
            }

            importDataDo.setProvince(importDataEntity.getProvinceShortName());
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
