package com.hr.cloud.service;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * Created by jiangshang on 2017/3/8.
 */
@Component
public class DecimalUtil {
  
  private static final String CHAR_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  public String convertDecimalToBase62(long number) {
    long rest = number;
    Stack<Character> stack = new Stack<>();
    while (rest != 0) {
      stack.push(CHAR_62.charAt((int) rest % 62));
      rest = rest / 62;
    }
    
    StringBuilder sb = new StringBuilder();
    while (! stack.isEmpty()) {
      sb.append(stack.pop());
    }
    
    return sb.toString();
  }
  
  public long convertBase62ToDecimal(String st) {
    long result = 0;
    if (st == null || st.isEmpty()) {
      return result;
    }
    if (! st.matches("[0-9a-zA-Z]+")) {
      return result;
    }
    int length = st.length();
    char[] chars = st.toCharArray();
    
    for (int i = 0; i < length; i++) {
      result += CHAR_62.indexOf(chars[i]) * (Math.pow(62, (length - i - 1)));
    }
    
    return result;
  }
  
  
  public byte[] long2bytes(long num) {
    byte[] b = new byte[8];
    for (int i = 0; i < 8; i++) {
      b[i] = (byte) (num >>> (56 - (i * 8)));
    }
    return b;
  }
  
  public long bytes2long(byte[] b) {
    long temp = 0;
    long res = 0;
    for (int i = 0; i < 8; i++) {
      res <<= 8;
      temp = b[i] & 0xff;
      res |= temp;
    }
    return res;
  }
  
}
