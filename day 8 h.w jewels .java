import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();

        // Store all jewels in a HashSet
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int count = 0;

        // Count stones that are jewels
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
