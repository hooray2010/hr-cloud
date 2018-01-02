package com.hr.cloud.mapper;

import com.hr.cloud.entity.InsuranceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hurui on 2018/1/2.
 */
@Mapper
public interface InsuranceMapper {
  
  List<InsuranceEntity> findAll();
  
}
