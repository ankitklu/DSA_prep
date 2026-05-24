class Solution {
    class VowelData {
        char ch;
        int firstIdx;
        int freq;
        
        VowelData(char ch) {
            this.ch = ch;
            this.firstIdx = -1;
            this.freq = 0;
        }
    }

    public String sortVowels(String s) {
        VowelData[] nums = new VowelData[26];
        for (int i = 0; i < 26; i++) {
            nums[i] = new VowelData((char)('a' + i));
        }

        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                nums[c - 'a'].ch = c;
                nums[c - 'a'].freq++;
                if (nums[c - 'a'].firstIdx == -1) {
                    nums[c - 'a'].firstIdx = j;
                }
                chars[j] = '*';
            }
        }

        // Sort based on the custom comparator: frequency descending, then first index ascending
        Arrays.sort(nums, (a, b) -> {
            if (a.freq != b.freq) {
                return Integer.compare(b.freq, a.freq);
            }
            return Integer.compare(a.firstIdx, b.firstIdx);
        });

        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                chars[i] = nums[j].ch;
                nums[j].freq--;
                if (nums[j].freq == 0) {
                    j++;
                }
            }
        }
        
        return new String(chars);
    }
}