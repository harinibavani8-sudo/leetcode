class Solution {
    public String[] findWords(String[] words) {
        String[] row = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        java.util.List<String> ans = new java.util.ArrayList<>();

        for (String w : words) {
            String s = w.toLowerCase();
            String r = row[0].indexOf(s.charAt(0)) != -1 ? row[0]
                     : row[1].indexOf(s.charAt(0)) != -1 ? row[1]
                     : row[2];

            boolean ok = true;
            for (char c : s.toCharArray()) {
                if (r.indexOf(c) == -1) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans.add(w);
        }
        return ans.toArray(new String[0]);
    }
}
