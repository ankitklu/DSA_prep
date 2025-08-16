import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Word_Ladder {
    static class Pair{
        String str;
        int dist;
        public Pair(String str, int dist){
            this.str =str;
            this.dist = dist;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String ele: wordList){
            set.add(ele);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair top = q.poll();
            String curr= top.str;
            int dist = top.dist;
            if(curr.equals(endWord)){
                return dist;
            }

            for(int i=0;i<curr.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char arr[] = curr.toCharArray();
                    arr[i] = ch;
                    String newStr = new String(arr);
                    if(set.contains(newStr)){
                        set.remove(newStr);
                        q.add(new Pair(newStr, dist+1));
                    }
                }
            }

        }        
        return 0;
    }
}
/*
 * 127. Word Ladder
Solved

avatar
Discuss Approach
arrow-up
Hard
Topics
premium lock icon
Companies
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */
