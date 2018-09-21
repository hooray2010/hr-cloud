package com.hr.cloud.controller.request;

import lombok.Data;

import java.util.List;

/**
 * @author hurui on 2018/9/21.
 */
@Data
public class SonarQualityGate {

    private String name;

    private String status;

    private List<SonarCondition> conditions;

}
