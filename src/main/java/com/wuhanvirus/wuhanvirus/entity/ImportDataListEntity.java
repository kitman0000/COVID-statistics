package com.wuhanvirus.wuhanvirus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by zhong on 2020-1-23.
 */
@Data
public class ImportDataListEntity {
    @JsonProperty("importDataListEntityList")
    List<ImportDataEntity> importDataListEntityList;
}
