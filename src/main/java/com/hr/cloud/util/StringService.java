package com.hr.cloud.util;

import java.util.List;

/**
 * Created by hurui on 2018/1/1.
 */
public class StringService {
  
  /**
   * 拼接sql ids, (1,2,3)
   */
  public static String getSqlIdIn(List<Long> idList) {
    String cIds = " (";
    for (int i = 0; i < idList.size(); i++) {
      if (i == 0) {
        cIds = cIds + idList.get(i);
      } else {
        cIds = cIds + ',' + idList.get(i);
      }
    }
    return cIds + ") ";
  }
  
}
