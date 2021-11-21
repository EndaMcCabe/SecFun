/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AES {

    /*
    When the encrypt button clicked
        GUI creates instance of this AES class if the AES radio button is selected
        passes plainText to the class then calls 2 methods based on input
        generateKey()
        encrypt()
    
    If the user pressed the decrypt button decrypt()method is called. 
    */
    
    
    Cipher cipher;
    SecretKey secretKey;
    String encryptedText;
    String decryptedText;
    String plainText;
    static KeyGenerator keyGenerator;

    public AES(String plainText, SecretKey secretKey, Cipher cipher) {

        this.plainText = plainText;
        this.secretKey = secretKey;
        this.cipher = cipher;
    }

    public AES() {
    }

    public SecretKey generateKey() throws NoSuchAlgorithmException {

        return secretKey = KeyGenerator.getInstance("AES").generateKey();
    }

    public String encrypt(String plainText, SecretKey secretKey, Cipher cipher) {

        try {
            cipher = Cipher.getInstance("AES");
            System.out.println("from encrypt method plaintext value is " + plainText);
            System.out.println("key value is from encrypt method" + secretKey);
            byte[] plainTextByte = plainText.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedByte = cipher.doFinal(plainTextByte);
            Base64.Encoder encoder = Base64.getEncoder();
            encryptedText = encoder.encodeToString(encryptedByte);
            return encryptedText;
        } catch (InvalidKeyException e) {
            System.out.println("Invalid key");
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error" + e.getMessage());
        } catch (NoSuchPaddingException e) {
            System.out.println(e.getStackTrace());
        }
        return encryptedText;
    }

    public String decrypt(String encryptedText, SecretKey secretKey, Cipher cipher) {
        //String decryptedText = "";
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encryptedTextByte = decoder.decode(encryptedText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
            decryptedText = new String(decryptedByte);
            return decryptedText;
        } catch (InvalidKeyException e) {
            System.out.println("Invalid key");
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }
        return decryptedText;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public String getPlainText() {
        return plainText;
    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }

    public void setDecryptedText(String decryptedText) {
        this.decryptedText = decryptedText;
    }

}
