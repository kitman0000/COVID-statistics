package com.wuhanvirus.wuhanvirus.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * Created by zhong on 2020-1-23.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportDataEntity {
    private int id;

    private Date createTime;

    private Date modifyTime;

    private String tags;

    private int countryType;

    private String provinceId;

    private String provinceName;

    private String provinceShortName;

    private int sort;

    private String operator;
}
