package com.hr.cloud.util;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 扩展集合in操作, 但集合不可为空!
 * <p>
 * Created by hurui on 2018/1/1.
 */
public class SelectInLanguageDriver extends XMLLanguageDriver implements LanguageDriver {
  
  private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");
  
  @Override
  public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
    Matcher matcher = inPattern.matcher(script);
    if (matcher.find()) {
      //script = matcher.replaceAll("(<foreach collection=\"$1\" item=\"__item\" separator=\",\" >#{__item}</foreach>)");
      script = matcher.replaceAll("" +
          "<foreach item=\"item\" index=\"index\" collection=\"$1\" open=\"(\" separator=\",\" close=\")\">\n" +
          "  #{item}\n" +
          "</foreach>");
    }
    script = "<script>" + script + "</script>";
    return super.createSqlSource(configuration, script, parameterType);
  }
  
}
