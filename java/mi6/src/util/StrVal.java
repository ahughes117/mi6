package util;

import java.security.MessageDigest;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Utility Class. Various helper functions lie here.
 *
 * @author Alex Hughes
 */
public class StrVal {

    /**
     * This function removes all quotes characters(')
     *
     * @param input
     * @return
     */
    public static String sntS(String input) {
        StringBuilder r = new StringBuilder(input.length());
        r.setLength(input.length());

        int current = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur != '\'' && cur != '\"') {
                r.setCharAt(current++, cur);
            }
        }
        return r.toString();
    }

    /**
     * Creates an alias for the feed, making use of the title. Rules: No special
     * characters are allowed. Spaces are converted to dashes Also, max string
     * length is 255 characters
     *
     * @param aTitle
     * @return
     */
    public static String createAlias(String aTitle) {
        //regular expression that only allows alphanumerics and whitespace
        String alias = aTitle.replaceAll("[^a-zA-Z0-9 ]+", "");
        alias = alias.replaceAll(" ", "-");

        if (alias.length() >= 255) {
            alias = alias.substring(0, 255);
        }

        return alias;
    }

    /**
     * Converts a String into a valid sha256 hash
     *
     * @param base
     * @return
     */
    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * This function returns the result of the subtraction of our desired limit
     * and the string length.
     *
     * @param input
     * @param aLimit
     * @return
     */
    public static int measureString(String input, int aLimit) {
        int result = input.length() - aLimit;
        return result;
    }

    /**
     * This function returns whether a string has a valid length.
     *
     * @param input
     * @param aLimit
     * @return
     */
    public static boolean validStringLength(String input, int aLimit) {
        boolean isValid;

        if (aLimit - input.length() >= 0) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }

    public static boolean hasDuplicates(ArrayList<String> aStrings, String aString) {
        boolean hasDuplicates = false;

        for (int i = 0; i < aStrings.size(); i++) {
            if (aStrings.get(i).equalsIgnoreCase(aString)) {
                hasDuplicates = true;
                break;
            }
        }
        return hasDuplicates;
    }

    public static String formatTimestamp(Timestamp aTStamp) {
        String formatted;

        if (aTStamp != null) {
            formatted = new SimpleDateFormat("dd/MM/yyyy || HH:mm:ss").format(aTStamp);
        } else {
            formatted = null;
        }
        return formatted;
    }
    
    public static String formatDate(java.sql.Date aDate) {
        String formatted;
        
        if(aDate != null) {
            formatted = new SimpleDateFormat("dd/MM/yyyy").format(aDate);
        } else {
            formatted = null;
        }
        return formatted;
    }

    /**
     * Gets a user friendly date format and returns a date object
     * 
     * @param aDate
     * @return
     * @throws Exception 
     */
    public static Date dateParser(String aDate) throws Exception {
        java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(aDate);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
    
    /**
     * Parses an integer from a String.
     * 
     * @param aString
     * @return 
     */
    public static int parseIdFromString(String aString) {
        int id = -1;
        
        Pattern intPattern = Pattern.compile("\\d++");
        Matcher intMatcher = intPattern.matcher(aString);
        
        while(intMatcher.find()){
            id = Integer.parseInt(intMatcher.group());
        }
        
        return id;
    }

    /**
     * Tiny helper function
     *
     * @param anInt
     * @return
     */
    public static boolean intToBool(int anInt) {
        if (anInt == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tiny helper function
     * 
     * @param aValue
     * @return 
     */
    public static int boolToInt(boolean aValue) {
        if (aValue) {
            return 1;
        } else {
            return 0;
        }
    }
}
