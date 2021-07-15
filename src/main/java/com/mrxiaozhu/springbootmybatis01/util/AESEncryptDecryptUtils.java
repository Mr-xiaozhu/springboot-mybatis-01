package com.mrxiaozhu.springbootmybatis01.util;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
public class AESEncryptDecryptUtils {

    /**
     * 1、AES加密 2、BASE64 转码
     *
     * @param sSrc 准备加密内容
     * @param sKey 密钥
     * @return 加密后内容
     * @throws Exception
     */
    public static String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
            log.error("【加密失败】：密钥配置错误，密钥为空null。。");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            log.error("【加密失败】：密钥配置错误，密钥长度不是16位。。");
            return null;
        }
        byte[] encrypted = new byte[0];
        try {
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        } catch (Exception e) {
            log.error("【加密失败】：计算错误。。error:{}", e);
        }

        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    /**
     * 1、AES解密 2、BASE64 转码
     *
     * @param sSrc 准备解密内容
     * @param sKey 密钥
     * @return 解密后内容
     * @throws Exception
     */
    public static String decrypt(String sSrc, String sKey) {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                log.error("【解密失败】：密钥配置错误，密钥为空null。。");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                log.error("【解密失败】：密钥配置错误，密钥长度不是16位。。");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
