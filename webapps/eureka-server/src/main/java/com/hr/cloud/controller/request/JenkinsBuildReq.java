package com.hr.cloud.controller.request;

import lombok.Data;

/**
 * @author hurui on 2018/9/21.
 */
@Data
public class JenkinsBuildReq {

    private String gitUrl;

    private String branch;

}
