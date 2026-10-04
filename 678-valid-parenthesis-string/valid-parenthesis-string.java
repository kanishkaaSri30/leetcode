class Solution {

    public boolean checkValidString(String s) {
        int l = 0, h = 0;

        for (int i = 0; i < s.length(); i++) {

            // Minimum possible balance
            l += s.charAt(i) == '(' ? 1 : -1;

            // Maximum possible balance
            h += s.charAt(i) == ')' ? -1 : 1;

            // Even the maximum balance is invalid
            if (h < 0) return false;

            // Minimum balance cannot be negative
            l = Math.max(l, 0);
        }

        return l == 0;
    }
}