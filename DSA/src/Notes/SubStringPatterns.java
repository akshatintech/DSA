package Notes;

public class SubStringPatterns {
    public int findSubstring(String s) {
        int[] map = new int[128];
        int counter =0; // check whether the substring is valid
        int begin = 0, end = 0; // two pointers, one point to tail and one head
        int d = 0; // the length of substring

        // initialize the hash map here
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                // modify counter here
                counter++;
            }

            while (/* counter condition */ 1< 2) {

                // update d here if finding minimum

                // increase begin to make it invalid/valid again
                if (map[s.charAt(begin++)]++ >= 0) {
                    // modify counter here
                    counter--;
                }
            }

            // update d here if finding maximum
        }
        return d;
    }

}
