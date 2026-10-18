class Solution {
    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        String s = str.toLowerCase();
        while (left < right) {
            while (left < right &&
                    !Character.isLetterOrDigit(str.charAt(left)))
                left++;
            while (left < right &&
                    !Character.isLetterOrDigit(str.charAt(right)))
                right--;
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}