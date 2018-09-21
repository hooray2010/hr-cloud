package com.hr.cloud.controller.request;

import lombok.Data;

/**
 * @author hurui on 2018/9/21.
 */
@Data
public class SonarCondition {

    private String errorThreshold;

    private String metric;

    private String onLeakPeriod;

    private String operator;

    private String status;

    private String value;

}
