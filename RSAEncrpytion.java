/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.encryption;

import java.security.*;
import java.security.*;
import javax.crypto.*;



public class RSAEncrpytion {
    
    // when the user selects the RSA option for encryption a object of this class will be called 
    // to follow through on encrypting and decrytping the plain text to the user for viewing or 
    // securing...
    
    private PrivateKey PRKey;
    private PublicKey PBkey;
    String EncrpytedMSG;
    String DecryptedMSG;
    String Ptext;
    Cipher RSA_Cipher;

    public RSAEncrpytion(PrivateKey PRKey, PublicKey PBkey, String EncrpytedMSG, String Ptext, Cipher RSA_Cipher) {
        this.PRKey = PRKey;
        this.PBkey = PBkey;
        this.Ptext = Ptext;
        this.RSA_Cipher = RSA_Cipher;
    }
    
    
    public RSAEncrpytion(){
        
        
        
        
    }
    //ecnrption process for encrpyting the plain text
    public String RSAEncyption (String Ptext) throws Exception{
       
        
        
        
        
        
        
        return null;
    }
    //decrryption process for decrypting the hidden message back into plaintext
    public String RSADecryption (String EncryptedMSG) throws Exception{
       
        
        
        
        
        
        
        
        
        return null;
    }
    
    
}
