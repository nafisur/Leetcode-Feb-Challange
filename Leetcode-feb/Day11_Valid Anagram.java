/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

*/
class Solution {
    public boolean isAnagram(String s, String t) {
            int[] arr = new int[26];
            for(char c: s.toCharArray()){
                arr[c-'a']++;
            }
            for(char c: t.toCharArray()){
                arr[c-'a']--;
            }
            for(int a: arr){
                if(a!=0)
                    return false;
            }
            return true;
        }
    }