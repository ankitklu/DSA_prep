import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Sort_Vowels_in_a_String {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Set<Character> set= new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                pq.add(s.charAt(i));
            }
        }
        String ans="";
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                ans+=s.charAt(i);
            }
            else{
                int retrievedChar = pq.poll();
                ans += (char) (retrievedChar);
            }
        }
        return ans;
    }
}
/*
 * 2785. Sort Vowels in a String
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a 0-indexed string s, permute s to get a new string t such that:

All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
Return the resulting string.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.

 

Example 1:

Input: s = "lEetcOde"
Output: "lEOtcede"
Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
Example 2:

Input: s = "lYmpH"
Output: "lYmpH"
Explanation: There are no vowels in s (all characters in s are consonants), so we return "lYmpH".
 

Constraints:

1 <= s.length <= 105
s consists only of letters of the English alphabet in uppercase and lowercase.
 */
