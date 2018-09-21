package com.hr.cloud.controller.request;

import lombok.Data;

import java.util.Date;

/**
 * @author hurui on 2018/9/21.
 */
@Data
public class SonarCallBackReq {

    private Date analyseAt;

    private SonarProject project;

    private Object properties;

    private SonarQualityGate qualityGate;

    private String serverUrl;

    private String status;

    private String taskId;

}
