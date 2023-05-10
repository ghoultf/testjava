package com.github.ghoultf.test.java.encrypt;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException,
        NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        // region generate publicKey and privateKey
        // KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        // rsa.initialize(512);
        // KeyPair keyPair = rsa.generateKeyPair();
        // PublicKey publicKey = keyPair.getPublic();
        // PrivateKey privateKey = keyPair.getPrivate();
        // String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        // String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        // endregion

        String publicKeyStr =
            "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALFHh4WjXFG4IzojRJCJljnrEiKuEv9qoki6OFOnA3tLnINOILaotQAhsgNNhf2teo4DzQaUCNtFXiBp8AFZVssCAwEAAQ";
        String privateKeyStr =
            "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAsUeHhaNcUbgjOiNEkImWOesSIq4S/2qiSLo4U6cDe0ucg04gtqi1ACGyA02F/a16jgPNBpQI20VeIGnwAVlWywIDAQABAkBEaP/pGBMmDdK6OqXYyN9J1maXL2lxWuro+cOGtGpphyuOHr1nITatdcSBXfNK9PZoHlI58i5rcgdGPLauuoNBAiEA+bB33omx23B92slMrsEPhuvJxXxcNLbJa2uZWETvpNsCIQC1wo6OE3goWTI+2ZyKIlDig/5IUluJlViseSHY84dA0QIgUBd4+9szP+5/kFSN0mh/MIoluMFBWm9fgKONFrFWJY0CIAyELk7oVlDo+4XKdHYqsMk4b61JRpZt22JdIRCQjJLRAiBT7PrS5zMrd+74sLXwP+ta41gqCHfCXuvXSf2MtcUPHg==";
        // MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALFHh4WjXFG4IzojRJCJljnrEiKuEv9qoki6OFOnA3tLnINOILaotQAhsgNNhf2teo4DzQaUCNtFXiBp8AFZVssCAwEAAQ
        System.out.println("publicKeyStr  " + publicKeyStr);
        // MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAsUeHhaNcUbgjOiNEkImWOesSIq4S/2qiSLo4U6cDe0ucg04gtqi1ACGyA02F/a16jgPNBpQI20VeIGnwAVlWywIDAQABAkBEaP/pGBMmDdK6OqXYyN9J1maXL2lxWuro+cOGtGpphyuOHr1nITatdcSBXfNK9PZoHlI58i5rcgdGPLauuoNBAiEA+bB33omx23B92slMrsEPhuvJxXxcNLbJa2uZWETvpNsCIQC1wo6OE3goWTI+2ZyKIlDig/5IUluJlViseSHY84dA0QIgUBd4+9szP+5/kFSN0mh/MIoluMFBWm9fgKONFrFWJY0CIAyELk7oVlDo+4XKdHYqsMk4b61JRpZt22JdIRCQjJLRAiBT7PrS5zMrd+74sLXwP+ta41gqCHfCXuvXSf2MtcUPHg==
        System.out.println("privateKeyStr " + privateKeyStr);

        PublicKey publicKey2 = generatePublicKeyFromStr(publicKeyStr);
        PrivateKey privateKey2 = generatePrivateKeyFromStr(privateKeyStr);

        // 使用publicKey2加密，privateKey2解密
        String pwd = "123456";
        System.out.println("source " + pwd);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey2);
        byte[] encryptedBytes = cipher.doFinal(pwd.getBytes());
        System.out.println("encrypted string " + Base64.getEncoder().encodeToString(encryptedBytes));

        cipher.init(Cipher.DECRYPT_MODE, privateKey2);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        System.out.println("decrypted string " + new String(decryptedBytes));
    }

    private static PublicKey generatePublicKeyFromStr(String publicKeyStr)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    private static PrivateKey generatePrivateKeyFromStrError(String privateKeyStr)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        // 异常 Only RSAPrivate(Crt)KeySpec and PKCS8EncodedKeySpec supported for RSA private keys
        return keyFactory.generatePrivate(keySpec);
    }

    private static PrivateKey generatePrivateKeyFromStr(String privateKeyStr)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}
