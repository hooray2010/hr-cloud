package com.hr.cloud.controller;

import com.hr.cloud.OrderSiteApplication;
import com.hr.cloud.model.Apple;
import com.hr.cloud.model.Fruit;
import com.hr.cloud.model.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by hurui on 2018/1/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(OrderSiteApplication.class)
@Slf4j
public class TestControllerTest {
  
  @Test
  public void testConstruct() {
    TestModel testModel = new TestModel();
    log.info(testModel.toString());
  }
  
  @Test
  public void testPECS() {
    List<? extends Fruit> eList = Arrays.asList(new Apple(), new Fruit());
    log.info(eList.get(0).toString());
    //elist.add(new Fruit());
    
    List<? super Fruit> sList = new ArrayList<>();
    sList.add(new Apple());
    sList.add(new Fruit());
    //get object
    log.info(sList.get(0).getClass().toString());
    
    Map<String, String> map = new HashMap<>();
    map.put("test_k", "test_v");
    map.forEach((k, v) -> log.info(k + " -- " + v));
  }
  
  @Test
  public void testSplit() {
    String str = "a,b,c,,";
    String[] ary = str.split(",");
    //预期大于 3，结果是 3
    log.info(ary.length + "");
  }
}
