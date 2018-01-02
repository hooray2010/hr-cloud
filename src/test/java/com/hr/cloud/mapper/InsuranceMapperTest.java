package com.hr.cloud.mapper;

import com.hr.cloud.CloudApplication;
import com.hr.cloud.entity.InsuranceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hurui on 2018/1/2.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(CloudApplication.class)
public class InsuranceMapperTest {
  
  @Autowired
  private InsuranceMapper insuranceMapper;
  
  @Test
  public void findAll() throws Exception {
    List<InsuranceEntity> insuranceEntityList = insuranceMapper.findAll();
    for (InsuranceEntity insuranceEntity : insuranceEntityList) {
      System.err.println(insuranceEntity);
    }
  }
  
}