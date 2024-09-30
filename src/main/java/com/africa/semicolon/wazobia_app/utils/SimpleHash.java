package com.africa.semicolon.wazobia_app.utils;

import java.util.HashMap;
import java.util.Map;

public class SimpleHash {

    private static Map<String, Long> lookupTable = new HashMap<>();

    public static String hash(long id) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String hashed = "";

        long hashValue = id * 31 + 17;

        for (int i = 0; i < 10; i++) {
            hashed += chars.charAt((int) (hashValue % chars.length()));
            hashValue /= 3;
        }

        lookupTable.put(hashed, id); // store hashed value and original ID
        return hashed;
    }

    public static Long decrypt(String hashed) {
        return lookupTable.get(hashed);
    }

    public static void main(String[] args) {
        long id = 40L;
        String hashed = hash(id);
        System.out.println("Hashed ID: " + hashed);

        Long decryptedId = decrypt(hashed);
        System.out.println("Decrypted ID: " + decryptedId);
    }
    }
