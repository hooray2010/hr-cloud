package com.hr.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hurui on 2017/12/25.
 */
@RestController
@RequestMapping(value = "item")
public class ItemController {
  
  @GetMapping(value = "/get/{itemId}")
  public String findOneItem(@PathVariable long itemId) {
    return "" + itemId;
  }
  
}
