class Solution {
    public int passwordStrength(String password) {

        Set<Character> set = new HashSet<>();

        for (char ch : password.toCharArray()) {
            set.add(ch);
        }

        int score = 0;

        for (char ch : set) {

            if (ch >= 'a' && ch <= 'z') {
                score += 1;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                score += 2;
            }
            else if (ch >= '0' && ch <= '9') {
                score += 3;
            }
            else if (ch == '!' || ch == '@' || ch == '#' || ch == '$') {
                score += 5;
            }
        }

        return score;
    }
}