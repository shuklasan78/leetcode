package com.sandeep.cryptography.tutorialsoint;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

//https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm
public class TutorialsPoint {

    public static void main(String[] args) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, UnrecoverableEntryException {
       //algorithms such as SHA-1, SHA 256, MD5 algorithms to convert an arbitrary length message to a message digest.


        storeKeystore();
        retrieveFromKeystore();

    }

    static void createMessageDigest() throws NoSuchAlgorithmException {
        String message = "Hello how are you";
        //Creating the MessageDigest object
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        //Passing data to the created MessageDigest Object
        md.update(message.getBytes());
        //Compute the message digest
        byte[] digest = md.digest();
        System.out.println(digest);
        //Converting the byte array in to HexString format
        StringBuffer hexString = new StringBuffer();
        System.out.println(hexString);
    }
    static void messageAuthenticationCode() throws NoSuchAlgorithmException, InvalidKeyException {
        //Creating a KeyGenerator object
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");

        //Creating a SecureRandom object
        SecureRandom secRandom = new SecureRandom();

        //Initializing the KeyGenerator
        keyGen.init(secRandom);

        //Creating/Generating a key
        Key key = keyGen.generateKey();

        //Creating a Mac object
        Mac mac = Mac.getInstance("HmacSHA256");

        //Initializing the Mac object
        mac.init(key);

        //Computing the Mac
        String msg = new String("Hi how are you");
        byte[] bytes = msg.getBytes();
        byte[] macResult = mac.doFinal(bytes);

        System.out.println("Mac result:");
        System.out.println(new String(macResult));
    }

    static void storeKeystore() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {

        String path = "usr/libexec/java_home/lib/security/cacerts";
        path = "/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/lib/security/cacerts";

        //Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //Loading the KeyStore object
        char[] password = "changeit".toCharArray();

        java.io.FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        //Creating the KeyStore.ProtectionParameter object
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        //Creating SecretKey object
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        //Creating SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        //Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);
        System.out.println("data stored");
    }

    static void retrieveFromKeystore() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        String path = "usr/libexec/java_home/lib/security/cacerts";
        path = "/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/lib/security/cacerts";
        //Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //Loading the the KeyStore object
        char[] password = "changeit".toCharArray();
        java.io.FileInputStream fis = new FileInputStream(path);

        keyStore.load(fis, password);

        //Creating the KeyStore.ProtectionParameter object
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        //Creating SecretKey object
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        //Creating SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        //Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);

        //Creating the KeyStore.SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEnt = (KeyStore.SecretKeyEntry)keyStore.getEntry("secretKeyAlias", protectionParam);

        //Creating SecretKey object
        SecretKey mysecretKey = secretKeyEnt.getSecretKey();
        System.out.println("Algorithm used to generate key : "+mysecretKey.getAlgorithm());
        System.out.println("Format used for the key: "+mysecretKey.getFormat());
    }
}
