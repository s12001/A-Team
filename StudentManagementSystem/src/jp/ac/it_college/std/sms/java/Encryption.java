package jp.ac.it_college.std.sms.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    private MessageDigest mSHA;

    public Encryption() {
        try {
            mSHA = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
    }

    public byte[] toHashValue(String password) {
        mSHA.update(password.getBytes());
        return mSHA.digest();
    }

    public String toEncryptedString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String hex = String.format("%02x",b);
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }
}
