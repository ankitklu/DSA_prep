class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            int n = sb.length();
            for (int i = 0; i < n; i++){
                sb.append(sb.charAt(i) != 'z' ? (char) (sb.charAt(i) + 1) : 'a');
            }
        }
        return sb.charAt(k - 1);
    }
}