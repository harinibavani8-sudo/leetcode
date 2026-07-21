class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                seenDigit = true;
                if (seenExponent) {
                    digitAfterExponent = true;
                }
            } 
            else if (ch == '+' || ch == '-') {
                // Sign is valid only at the beginning or immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (ch == '.') {
                // Dot cannot appear after exponent or more than once
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } 
            else if (ch == 'e' || ch == 'E') {
                // Exponent cannot appear twice or before any digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                digitAfterExponent = false;
            } 
            else {
                return false;
            }
        }

        return seenDigit && digitAfterExponent;
    }
}
