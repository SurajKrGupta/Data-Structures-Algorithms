class Solution {
    public String functionCompare(String str1,String str2){
        int len=0;
        while(len<str1.length() && str1.charAt(len)==str2.charAt(len)){
            len++;
        }
        return str1.substring(0,len);
    }
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        return functionCompare(strs[0],strs[strs.length-1]);
        
    }
}