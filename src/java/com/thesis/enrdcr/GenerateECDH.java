/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.enrdcr;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Mangala sharma
 */
public class GenerateECDH {
    public static SecretKey generateKey(int keySize) throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("ECDH");
    keyGenerator.init(keySize);
    return keyGenerator.generateKey();
}
}
