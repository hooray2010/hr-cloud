package com.hr.cloud.controller;

import com.offbytwo.jenkins.JenkinsServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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

    @GetMapping("{gitUrl}/{branch}")
    public void build(@PathVariable String gitUrl, @PathVariable String branch) throws URISyntaxException, IOException {
        JenkinsServer jenkins = new JenkinsServer(new URI(JENKINS_URL), USER_NAME, PWD);
        // 判断jenkins是否running
        if (jenkins.isRunning()) {

            // 获取jenkins构建脚本
            String jobName = getJobName(gitUrl);
            String jobXml = jenkins.getJobXml(jobName);

            // 修改构建脚本
            String newJobName = jobName + JOB_SUFFIX;
            jenkins.createJob(newJobName, jobXml);
            // TODO: 2018/9/21 更新模板配置
            String newJobXml = "";
            jenkins.updateJob(newJobName, newJobXml);

            // 构建对应的job
            jenkins.getJob(newJobName).build();

            // 获取html格式日志
            jenkins.getJob(newJobName).getLastBuild().details().getConsoleOutputHtml();

            // 获取text格式日志
            jenkins.getJob(newJobName).getLastBuild().details().getConsoleOutputText();

            // 获取执行结果（是否成功）
            jenkins.getJob(newJobName).getLastBuild().details().getResult();
        }
    }

    private String getJobName(String gitUrl) {
        return gitUrl.split("\\/")[-1].split(".git")[0];
    }

}
