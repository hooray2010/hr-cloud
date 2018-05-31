package com.hr.cloud.controller;

import com.hr.cloud.OrderApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hurui on 2017/12/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(OrderApp.class)
public class ItemControllerTest {
  
  @Test
  public void findOneItem() throws Exception {
    System.err.println("test1");
  }
  
}