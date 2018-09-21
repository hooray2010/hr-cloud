package com.hr.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author hurui on 2018/9/21.
 */
@RestController("jenkins")
@Slf4j
public class JenkinsController {

    private static final String JENKINS_URL = "http://39.106.176.242:8081";
    private static final String USER_NAME = "admin";
    private static final String PWD = "admin303";
    private static final String JOB_SUFFIX = "_cp";

    @PostMapping("build")
    public void build(@RequestBody BuildReq buildReq) throws URISyntaxException, IOException {
        JenkinsServer jenkins = new JenkinsServer(new URI(JENKINS_URL), USER_NAME, PWD);

        // 判断jenkins是否running
        if (jenkins.isRunning()) {

            // 获取jenkins构建脚本
            String jobName = this.getJobName(buildReq.getGitUrl());
            log.warn(jobName);
            Map<String, Job> jobs = jenkins.getJobs();
            log.warn("jobs = {}", JSONObject.toJSONString(jobs));
            String jobXml = jenkins.getJobXml(jobName);
            log.warn("job xml = {}", jobXml);

            // 修改构建脚本
            String newJobName = jobName + JOB_SUFFIX;
            String newJobXml = jobXml + "";

            jenkins.createJob(newJobName, newJobXml);
            jenkins.updateJob(newJobName, newJobXml);
            jenkins.disableJob(newJobName);
            jenkins.enableJob(newJobName);

            // 构建对应的job
            jenkins.getJob(newJobName).build();

            // 获取html格式日志
            log.warn(jenkins.getJob(newJobName).getLastBuild().details().getConsoleOutputHtml());
            // 获取text格式日志
            log.warn(jenkins.getJob(newJobName).getLastBuild().details().getConsoleOutputText());
            // 获取执行结果（是否成功）
            log.warn(JSON.toJSONString(jenkins.getJob(newJobName).getLastBuild().details().getResult()));
        }
    }

    private String getJobName(String gitUrl) {
        return gitUrl.substring(gitUrl.lastIndexOf("/") + 1, gitUrl.length()).replace(".git", "");
    }

}
