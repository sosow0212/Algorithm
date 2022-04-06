package com.sosow0212.test;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 출처
 https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=inho860&logNo=220314161466
 */

public class DES {
    private static Cipher c;
    private static String KSP = "64bitkey";  //64bit key 지정
    private static DESKeySpec desKeySpec;
    private static SecretKeyFactory keyFactory;
    private static Key key;

    public static void main(String[] args) throws Exception {
        SetEnc(); //key생성
        System.out.println();
        byte[] cStr = null;
        byte[] dStr = null;

        String ori = "1011010";
        System.out.println("평문: " + ori);


        cStr = Encrypts(ori);
        System.out.println("암호화 결과: " + new String(cStr));


        dStr = Decryptions(cStr);
        System.out.println("복호화 결과: " + new String(dStr));
    }



    public static void SetEnc() throws Exception {
        c = Cipher.getInstance("DES");
        desKeySpec = new DESKeySpec(KSP.getBytes());
        keyFactory = SecretKeyFactory.getInstance("DES");
        key = keyFactory.generateSecret(desKeySpec);
    }


    public static byte[] Encrypts(String str) throws Exception {
        c.init(Cipher.ENCRYPT_MODE, key);
        return c.doFinal(str.getBytes());
    }

    public static byte[] Decryptions(byte[] str) throws Exception {
        c.init(Cipher.DECRYPT_MODE, key);
        return c.doFinal(str);
    }

}