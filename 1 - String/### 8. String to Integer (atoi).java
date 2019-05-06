/*

Key Number to remember:

Integer.MAX_VALUE = (2^31 − 1) = 2147483647

Integer.MIN_VALUE = (- 2^31) = -2147483648


Pre Check on Int Ranges
check it first with (int MAX or MIN) / 10 
then do the multiplication


*/

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        
        char[] strArr = str.toCharArray();
        int firstInd = 0;
        int sign = 1;
        while (firstInd < strArr.length){
            if (Character.isDigit(strArr[firstInd])){
                break;
            }
            if (strArr[firstInd] == '-'){
                sign = -1;
                firstInd++;
                break;
            }
            if (strArr[firstInd] == '+'){
                firstInd++;
                break;
            }
            if (strArr[firstInd] != ' ') return 0;
            firstInd++;
        }
        
        double ans = 0;
        for (int i = firstInd; i < strArr.length; i++){
            if (!Character.isDigit(strArr[i])){
                break;
            }
            ans = ans + Integer.parseInt(strArr[i] + "") * 0.1;
            if (sign * ans >= Integer.MAX_VALUE / 10.0){
                return Integer.MAX_VALUE;
            }
            if (sign * ans <= Integer.MIN_VALUE / 10.0){
                return Integer.MIN_VALUE;
            }
            ans *= 10;
        }
        return (int) (sign * ans);
    }
}
