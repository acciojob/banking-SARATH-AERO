package com.driver;

import javax.swing.*;
import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
    }
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }


    public boolean checkValid(String lId) {
        for (int i = 0; i < lId.length() - 1; i++) {
            if (lId.substring(i, i + 1).equalsIgnoreCase(lId.substring(i + 1, i + 2))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPossible(String lId) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lId.length(); i++) {
            map.put(lId.charAt(i),map.getOrDefault(lId.charAt(i), 0) + 1);
        }
        char[] array = new char[lId.length()];
        int index = 0;
        for (Character j : map.keySet()) {
            for (int i = 1; i <= map.get(j); i++) {
                array[index++] = j;
                index++;
                if(index >= array.length )
                    index = 1;
            }
        }
        String ans = new String(array);
        if(checkValid(ans)) {
            this.tradeLicenseId = ans;
            return true;
        }
        else{
            return  false;
            }

    }
    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String lid = tradeLicenseId;

        if (!checkValid(lid)) {
            if(checkPossible(lid)){
                return;
            }else {
                throw new InvalidLicence("Valid License can not be generated");
            }
        }else
            return;
    }
}

class InvalidLicence extends Exception {
    public InvalidLicence(String message) {
        super(message);
    }
}

