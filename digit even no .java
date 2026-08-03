import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];

        // Count frequency of each digit
        for (int d : digits) {
            count[d]++;
        }

        List<Integer> list = new ArrayList<>();

        // Check all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int[] temp = new int[10];
            int x = num;

            while (x > 0) {
                temp[x % 10]++;
                x /= 10;
            }

            boolean valid = true;
            for (int i = 0; i < 10; i++) {
                if (temp[i] > count[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                list.add(num);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
