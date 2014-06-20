package jp.ac.it_college.std.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    public static String getEncryptedPassword(String password) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = toEncryption(toHashValue(md, password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String toEncryption(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String hex = String.format("%02x", b);
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }

    private static byte[] toHashValue(MessageDigest md, String password) {
        md.update(password.getBytes());
        return md.digest();
    }
}
