class Solution {
    private void generateParenthesis(StringBuilder sb, List<String> reslist, int total, int lpar, int rpar) {
        if ((lpar == rpar) && (lpar == total)) {
            reslist.add(sb.toString());
            return;
        }

        if (lpar < total) {
            sb.append('(');
            generateParenthesis(sb, reslist, total, (lpar+1), rpar);
            sb.setLength(sb.length() - 1);
        }

        if (rpar < lpar) {
            sb.append(')');
            generateParenthesis(sb, reslist, total, lpar, (rpar+1));
            sb.setLength(sb.length() - 1);
        }

        return;
    }

    public List<String> generateParenthesis(int n) {
        List<String> reslist = new ArrayList<>();
        if (n > 0) {
            generateParenthesis(new StringBuilder(), reslist, n, 0, 0);
        }
        return reslist;
    }
}
