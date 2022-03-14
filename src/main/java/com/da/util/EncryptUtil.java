package com.da.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncryptUtil {

	static String aesKey;
	
	@Value("${est.dealing.aes.key}")
	public void setKey(String value) {
		aesKey = value;
	}

	public static byte[] hexToByteArray(String hex) {
    	
		if (hex == null || hex.length() == 0) {
			return null;
		}

		byte[] ba = new byte[hex.length() / 2];
        
		for (int i = 0; i < ba.length; i++) {
			ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
        
		return ba;
	}

    public static String byteArrayToHex(byte[] ba) {

        if (ba == null || ba.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer(ba.length * 2);
        String hexNumber;

        for (int x = 0; x < ba.length; x++) {
            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
            sb.append(hexNumber.substring(hexNumber.length() - 2));
        }

        return sb.toString();
    }

    /**
     * AES ����� ��ȣȭ
     *
     * @param message
     * @return
     * @throws Exception
     */
     public static String encrypt(String message) throws Exception {

	 	SecretKeySpec skeySpec = new SecretKeySpec(aesKey.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(message.getBytes());
         
		return byteArrayToHex(encrypted);
     }

     /**
      * AES ����� ��ȣȭ
      *
      * @param message
      * @return
      * @throws Exception
      */
     public static String decrypt(String encrypted) throws Exception {

    	SecretKeySpec skeySpec = new SecretKeySpec(aesKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(hexToByteArray(encrypted));
        String originalString = new String(original);

        return originalString;
     }
}
