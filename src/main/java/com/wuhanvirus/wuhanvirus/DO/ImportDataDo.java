package com.wuhanvirus.wuhanvirus.DO;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhong on 2020-1-23.
 */
@Data
public class ImportDataDo {
    String province;
    int suspect;
    int confirm;
    int dead;
    int heal;
    Date updateTime;
    String updateTimeStr;
}
