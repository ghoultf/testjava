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
//         KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
//         rsa.initialize(1536);
//         KeyPair keyPair = rsa.generateKeyPair();
//         PublicKey publicKey = keyPair.getPublic();
//         PrivateKey privateKey = keyPair.getPrivate();
//         String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//         String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        // endregion

        String publicKeyStr =
            "MIHfMA0GCSqGSIb3DQEBAQUAA4HNADCByQKBwQCwfe8jbao+7txAb8ZXDbFr9gJnnxBgKVWnmmxqMPotwQnNA1vYyLeo7hQZACQYTXrBtkvsi4To5dVcRVZQyKtmNDBE/Oa/3gtKM2Q5ynLX4aZYxuZ3q7udv9H8JO1GO0AKA0tRmqRuuS7mr4MKR/hOsb3ysZOxSfiOwIbq4togtZ3odbFxFfDxHTS8LW6TPuSXvZLQ7TzzhDQ17iHoMDbLE6/tNK9Tg1tfO26RmTXVJfQH44p6Fro0x1AWlRr2K1ECAwEAAQ==";
        String privateKeyStr =
            "MIIDlgIBADANBgkqhkiG9w0BAQEFAASCA4AwggN8AgEAAoHBALB97yNtqj7u3EBvxlcNsWv2AmefEGApVaeabGow+i3BCc0DW9jIt6juFBkAJBhNesG2S+yLhOjl1VxFVlDIq2Y0MET85r/eC0ozZDnKctfhpljG5neru52/0fwk7UY7QAoDS1GapG65LuavgwpH+E6xvfKxk7FJ+I7Ahuri2iC1neh1sXEV8PEdNLwtbpM+5Je9ktDtPPOENDXuIegwNssTr+00r1ODW187bpGZNdUl9AfjinoWujTHUBaVGvYrUQIDAQABAoHAPmhplTeECbjgvRBJLCM1Z52YABgo7Dfxh9B9IZer/13RH2NeqOtgtiVpieWY3dcX30Oc2UoEd2494eDKwsoSgZNWti5PUe0sRNKjUCQcM+Ygsiey+wII16EqmWRdWoY8adCmB3G11cBMBr4QQLuYefMramiMrV21jQUTmIAeTaQuZJJ7vIpi1Gx3qSdHlnK1jiGVQYeyZyCDvaXj+YlT+VuYEZ02qtbk9EmTUVRelcNZT4GfIvETMzwVx3dP+xgBAmEA6X81EjnwTTALkoQpm6KEBfgv6bvUB9f6yWZEroAHwhuohCp3pK/5YZldfsXT/S/uTnHPM+P+TW3zeVENWAOa9qX4CeUvQqs1nao4U9KJNnyDBB9CtFK5R6sVYGGUcMMRAmEAwYBPg3OOu3YS1dvHYkaGtxvmqFgvszqA+jzu/cwzL9iBadoO7N/ubUyxo/m5O7EbnYyBaIfopqEO5DtR24WE7uEqE7nP6XTABgejfBseEdCrBfzmREWgPZsJP7NYAmRBAmEAi/591lCwl8bPmWft/mcg2udj6rJ3vMAsl6XeVfVjMWkdzygbFb2AOpkWKlT39dxP9+5aedUfelMK4FjNNFDtDyaRIXWssT8vZTlSjkczh1x9vPH1L2JNvf+AUIoQ0s7RAmAU5eywf7x8loX2PuRLwt4tzH+e0tdj/f+MBySwmGs20aU4b2qJPq4bc9sDoKbWwYv/+frH9VW1GVPoZley47q1qe/HbZv81LUgcZbAgpU+y1CNNwEPgo2J2cKn9JCewYECYGeKjdSz89Nu+qtfINUeGPdD+oh3XqL7dpVhmWfR5gUuXTO1BUyb+AMYiSof42jYgh84XrXV0CC+PaBQcFyuTK4QYCXAXpr1ddcM0CYsqP3wQgMdQcyMBcaXUaa2EQVZTg==";
        // MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALFHh4WjXFG4IzojRJCJljnrEiKuEv9qoki6OFOnA3tLnINOILaotQAhsgNNhf2teo4DzQaUCNtFXiBp8AFZVssCAwEAAQ
        System.out.println("publicKeyStr  " + publicKeyStr);
        // MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAsUeHhaNcUbgjOiNEkImWOesSIq4S/2qiSLo4U6cDe0ucg04gtqi1ACGyA02F/a16jgPNBpQI20VeIGnwAVlWywIDAQABAkBEaP/pGBMmDdK6OqXYyN9J1maXL2lxWuro+cOGtGpphyuOHr1nITatdcSBXfNK9PZoHlI58i5rcgdGPLauuoNBAiEA+bB33omx23B92slMrsEPhuvJxXxcNLbJa2uZWETvpNsCIQC1wo6OE3goWTI+2ZyKIlDig/5IUluJlViseSHY84dA0QIgUBd4+9szP+5/kFSN0mh/MIoluMFBWm9fgKONFrFWJY0CIAyELk7oVlDo+4XKdHYqsMk4b61JRpZt22JdIRCQjJLRAiBT7PrS5zMrd+74sLXwP+ta41gqCHfCXuvXSf2MtcUPHg==
        System.out.println("privateKeyStr " + privateKeyStr);

        PublicKey publicKey2 = generatePublicKeyFromStr(publicKeyStr);
        PrivateKey privateKey2 = generatePrivateKeyFromStr(privateKeyStr);

        // 使用publicKey2加密，privateKey2解密
//        String pwd = "hzct@1234";
        String pwd = "root";
//        String pwd = "jdbc:mysql://192.168.2.104:3306/sio-20230504?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";
        System.out.println("source " + pwd);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey2);
        byte[] encryptedBytes = cipher.doFinal(pwd.getBytes());
        System.out.println("encrypted string " + Base64.getEncoder().encodeToString(encryptedBytes));

        cipher.init(Cipher.DECRYPT_MODE, privateKey2);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        // 123456 C6R48MZeXlWO2DdzO4CgKeOQIFOnI97nFBqu3fwlZMXpYtADDlppTa7IhZkFLUQ6WTYnT1jDgpOjOV10KmyA9g==
        // 1234567 DEPFHpLjT0vAbQojtDOeVSZsd+5LQ3QCNMU9Bw5pGd+4Up/a6fQ0571vOKd+gK6ZDJ4qlnUGgLUeWi+Y2CNmUA==
        // hzct@1234 cvYmoBA5On+0CJUcXA7b41tqsh4kUp5pHhN/4xJsncPPeNO2lIStThYug7t9GhPqmQVpy7q0JVZGITiRZwUrSw==
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
