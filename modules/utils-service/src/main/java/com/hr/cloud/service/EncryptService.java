package com.hr.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by huanglei on 2017/1/7.
 */
@Service
public class EncryptService {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(EncryptService.class);
  
  private static final Charset CHARSET = Charset.forName("utf-8");
  
  private static final String DES_KEY = "dcc509aDes3820";
  
  /**
   * @Description:加密-16位小写
   * @author:liuyc
   * @time:2016年5月23日 上午11:15:33
   */
  public String md5Encrypt16(String encryptStr) {
    return md5(encryptStr).substring(8, 24);
  }
  
  public String md5(String input) {
    return md5(input.getBytes());
  }
  
  public String md5(byte[] input) {
    char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    MessageDigest md5 = null;
    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      LOGGER.error(e.getMessage());
    }
    
    md5.update(input);
    input = md5.digest();
    StringBuilder sb = new StringBuilder(input.length * 2);
    for (int i = 0; i < input.length; i++) {
      sb.append(hexChar[(input[i] & 0xf0) >>> 4]);
      sb.append(hexChar[input[i] & 0x0f]);
    }
    return sb.toString();
  }
  
  /**
   * One-stop md5 string encrypting.
   */
  public String md5crypt(String input) {
    return this.md5crypt(input.getBytes());
  }
  
  public String md5crypt(byte[] input) {
    try {
      char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.update(input);
      input = md5.digest();
      StringBuilder sb = new StringBuilder(input.length * 2);
      for (int i = 0; i < input.length; i++) {
        sb.append(hexChar[(input[i] & 0xf0) >>> 4]);
        sb.append(hexChar[input[i] & 0x0f]);
      }
      return sb.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * BASE64加密
   */
  public String EncrotpptytptencodeBASE64(byte[] key) {
    return Base64Utils.encodeToString(key);
  }
  
  /**
   * Encode a string using algorithm specified in web.xml and return the resulting encrypted
   * password. If exception, the plain credentials string is returned
   *
   * @param password  Password or other credentials to use in authenticating this username
   * @param algorithm Algorithm used to do the digest
   * @return encypted password based on the algorithm.
   */
  public String encodePassword(String password, String algorithm) {
    byte[] unencodedPassword = password.getBytes();
    MessageDigest md = null;
    try {
      // first create an instance, given the provider
      md = MessageDigest.getInstance(algorithm);
    } catch (Exception e) {
      return password;
    }
    md.reset();
    // call the update method one or more times
    // (useful when you don't know the size of your data, eg. stream)
    md.update(unencodedPassword);
    // now calculate the hash
    byte[] encodedPassword = md.digest();
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < encodedPassword.length; i++) {
      if ((encodedPassword[i] & 0xff) < 0x10) {
        buf.append("0");
      }
      buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
    }
    return buf.toString();
  }
  
  /**
   * sha1加密
   */
  public String SHA1(String inputStr) {
    MessageDigest mDigest = null;
    try {
      mDigest = MessageDigest.getInstance("SHA1");
      
    } catch (NoSuchAlgorithmException e) {
      LOGGER.error(e.getMessage());
    }
    
    byte[] result = mDigest.digest(inputStr.getBytes());
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < result.length; i++) {
      sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }
  
  /**
   * BASE64解密
   *
   * @param key
   * @return
   * @throws IOException
   * @throws Exception
   */
  public byte[] decodeBASE64(String key) throws IOException {
    return Base64Utils.decodeFromString(key);
  }
  
  /**
   * BASE64加密
   *
   * @param key
   * @return
   * @throws Exception
   */
  public static String encodeBASE64(byte[] key) {
    return Base64Utils.encodeToString(key);
  }
  
  public byte[] pKCS7Encoder(int count) {
    int amountToPad = 32 - count % 32;
    if (amountToPad == 0) {
      amountToPad = 32;
    }
    
    char padChr = chr(amountToPad);
    String tmp = new String();
    
    for (int index = 0; index < amountToPad; ++ index) {
      tmp = tmp + padChr;
    }
    
    return tmp.getBytes(CHARSET);
  }
  
  public byte[] pKCS7decoder(byte[] decrypted) {
    byte pad = decrypted[decrypted.length - 1];
    if (pad < 1 || pad > 32) {
      pad = 0;
    }
    
    return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
  }
  
  public char chr(int a) {
    byte target = (byte) (a & 255);
    return (char) target;
  }
  
  
  /**
   * 手机号加密,转换成ascii码加50的字母
   *
   * @param mobile 手机号码
   * @return 加密后的手机号码
   */
  public String encryptMobileByAscii(String mobile) {
    StringBuffer stringBuffer = new StringBuffer();
    char[] chars = mobile.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int charInt = (int) chars[i] + 50;
      stringBuffer.append((char) charInt);
    }
    return stringBuffer.toString();
  }
  
  /**
   * 手机号解密,转换成ascii码减50的字母
   *
   * @param encryptMobile 已加密的手机号码
   * @return 手机号码
   */
  public String decryptMobileByAscii(String encryptMobile) {
    StringBuffer stringBuffer = new StringBuffer();
    char[] chars = encryptMobile.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int charInt = (int) chars[i] - 50;
      stringBuffer.append((char) charInt);
    }
    return stringBuffer.toString();
  }
  
  public byte[] desDecrypt(byte[] src) throws Exception {
    // DES算法要求有一个可信任的随机数源
    SecureRandom random = new SecureRandom();
    // 创建一个DESKeySpec对象
    DESKeySpec desKey = new DESKeySpec(DES_KEY.getBytes());
    // 创建一个密匙工厂
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    // 将DESKeySpec对象转换成SecretKey对象
    SecretKey securekey = keyFactory.generateSecret(desKey);
    // Cipher对象实际完成解密操作
    Cipher cipher = Cipher.getInstance("DES");
    // 用密匙初始化Cipher对象
    cipher.init(Cipher.DECRYPT_MODE, securekey, random);
    // 真正开始解密操作
    return cipher.doFinal(src);
  }
  
  public byte[] desCrypto(byte[] datasource) {
    try {
      SecureRandom random = new SecureRandom();
      DESKeySpec desKey = new DESKeySpec(DES_KEY.getBytes());
      //创建一个密匙工厂，然后用它把DESKeySpec转换成
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey securekey = keyFactory.generateSecret(desKey);
      //Cipher对象实际完成加密操作
      Cipher cipher = Cipher.getInstance("DES");
      //用密匙初始化Cipher对象
      cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
      //现在，获取数据并加密
      //正式执行加密操作
      return cipher.doFinal(datasource);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return null;
  }
  
}
