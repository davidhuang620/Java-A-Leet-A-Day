

## Rabin Karp

https://leetcode.com/problems/implement-strstr/  

> Generate a hash code for the whole String such that we can compare Strings in constant time.

```Java
int hashCode = 0;
for (int i = 0; i < str.length(); i++){
  hashCode = (hashCode + str.charAt(i)) * 31 % 100000;
}
```

Finding a string in another bigger string,  
Time Complexity: O(m + n)  
m = string a length  
n = string b length  

## Palindrome

Operate on the two pointers left and right  
str.charAt(left) == str.charAt(right)

https://leetcode.com/problems/longest-palindromic-substring/  (tricky boundary)  
https://leetcode.com/problems/longest-palindrome/  
https://leetcode.com/problems/valid-palindrome/
