package com.hr.cloud.mapper;

import com.hr.cloud.entity.InsuranceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hurui on 2018/1/2.
 */
@Mapper
public interface InsuranceMapper {
  
  List<InsuranceEntity> findAll();
  
  @Select("select id, name, short_name, interface_code, status from newtank_plg_product_insurance where id = #{1}")
  InsuranceEntity findOne(long insuranceId);
  
}
