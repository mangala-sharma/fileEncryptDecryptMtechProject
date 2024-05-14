
package com.thesis.enrdcr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Mangala sharma
 */
public class AesEncryption {
    
    public static SecretKey getKeyFromPassword(String password, String salt)
    throws NoSuchAlgorithmException, InvalidKeySpecException {
    
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 128);
    SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    return secret;
}

public static IvParameterSpec generateIv() {
    byte[] iv = new byte[16];
    new SecureRandom().nextBytes(iv);
    return new IvParameterSpec(iv);
}

 public static void encryptFile(String algorithm, SecretKey key, IvParameterSpec iv,
        File inputFile, File outputFile) throws IOException, NoSuchPaddingException,
        NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
        BadPaddingException, IllegalBlockSizeException {
    
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
    FileInputStream inputStream = new FileInputStream(inputFile);
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    
    byte[] buffer = new byte[64];
    int bytesRead;
    while ((bytesRead = inputStream.read(buffer)) != -1) {
        byte[] output = cipher.update(buffer, 0, bytesRead);
        if (output != null) {
            outputStream.write(output);
        }
    }
    byte[] outputBytes = cipher.doFinal();
    if (outputBytes != null) {
        outputStream.write(outputBytes);
    }
    inputStream.close();
    outputStream.close();
}
 public static void decryptFile(String algorithm, SecretKey key, IvParameterSpec iv,
        File inputFile, File outputFile) throws IOException, NoSuchPaddingException,
        NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
        BadPaddingException, IllegalBlockSizeException {
    
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.DECRYPT_MODE, key, iv);
    FileInputStream inputStream = new FileInputStream(inputFile);
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    
    byte[] buffer = new byte[64];
    int bytesRead;
    while ((bytesRead = inputStream.read(buffer)) != -1) {
        byte[] output = cipher.update(buffer, 0, bytesRead);
        if (output != null) {
            outputStream.write(output);
        }
    }
    
    byte[] outputBytes = cipher.doFinal();
    if (outputBytes != null) {
        outputStream.write(outputBytes);
    }
    
    inputStream.close();
    outputStream.close();
}}

//public static void givenFile_whenEncrypt_thenSuccess() 
//    throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException, 
//    InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, 
//    NoSuchPaddingException {
//    
//    SecretKey key = AesEncryption.generateKey(128);
//    String algorithm = "AES/CBC/PKCS5Padding";
//    IvParameterSpec ivParameterSpec = AesEncryption.generateIv();
//     File file = new File("C:\\Users\\Mangala sharma\\Documents\\NetBeansProjects\\AEStestingg\\folder\\document.pdf");
//    File inputFile = file.getAbsoluteFile();
//    File encryptedFile = new File("pp.encrypted");
//    File decryptedFile = new File("document.decrypted");
//    AesEncryption.encryptFile(algorithm, key, ivParameterSpec, inputFile, encryptedFile);
//    AesEncryption.decryptFile(
//      algorithm, key, ivParameterSpec, encryptedFile, decryptedFile);
//   
//}
//}
