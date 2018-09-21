package com.hr.cloud.controller;

import lombok.Data;

/**
 * @author hurui on 2018/9/21.
 */
@Data
public class BuildReq {

    private String gitUrl;

    private String branch;

}
