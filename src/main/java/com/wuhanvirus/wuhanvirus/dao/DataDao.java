package com.wuhanvirus.wuhanvirus.dao;

import com.wuhanvirus.wuhanvirus.DO.ImportDataDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhong on 2020-1-23.
 */
@Mapper
@Repository
public interface DataDao {
    void insertData(@Param("importDataDo") ImportDataDo importDataDo);

    List<ImportDataDo> getData(String province);
}
