import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Minimum_Number_of_People_to_Teach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        Map<Integer, Set<Integer>> personLanguages = new HashMap<>();
        for (int i = 0; i < m; i++) {
            personLanguages.put(i + 1, new HashSet<>());
            for (int lang : languages[i]) {
                personLanguages.get(i + 1).add(lang);
            }
        }

        Set<Integer> candidates = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0];
            int v = f[1];
            Set<Integer> langU = personLanguages.get(u);
            Set<Integer> langV = personLanguages.get(v);

            boolean canCommunicate = false;
            for (int lang : langU) {
                if (langV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }

            if (!canCommunicate) {
                candidates.add(u);
                candidates.add(v);
            }
        }

        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int teachCount = 0;
            for (int person : candidates) {
                if (!personLanguages.get(person).contains(lang)) {
                    teachCount++;
                }
            }
            minTeach = Math.min(minTeach, teachCount);
        }

        return minTeach;
    }
}
/*
 * 1733. Minimum Number of People to Teach
Solved
Medium
Topics
premium lock icon
Companies
Hint
On a social network consisting of m users and some friendships between users, two users can communicate with each other if they know a common language.

You are given an integer n, an array languages, and an array friendships where:

There are n languages numbered 1 through n,
languages[i] is the set of languages the i​​​​​​th​​​​ user knows, and
friendships[i] = [u​​​​​​i​​​, v​​​​​​i] denotes a friendship between the users u​​​​​​​​​​​i​​​​​ and vi.
You can choose one language and teach it to some users so that all friends can communicate with each other. Return the minimum number of users you need to teach.

Note that friendships are not transitive, meaning if x is a friend of y and y is a friend of z, this doesn't guarantee that x is a friend of z.
 

Example 1:

Input: n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
Output: 1
Explanation: You can either teach user 1 the second language or user 2 the first language.
Example 2:

Input: n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
Output: 2
Explanation: Teach the third language to users 1 and 3, yielding two users to teach.
 

Constraints:

2 <= n <= 500
languages.length == m
1 <= m <= 500
1 <= languages[i].length <= n
1 <= languages[i][j] <= n
1 <= u​​​​​​i < v​​​​​​i <= languages.length
1 <= friendships.length <= 500
All tuples (u​​​​​i, v​​​​​​i) are unique
languages[i] contains only unique values
 */
