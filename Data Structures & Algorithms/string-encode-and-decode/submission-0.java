class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> reslist = new ArrayList<>();
        if (str.length() > 0) {
            int pos = 0;
            while (pos < str.length()) {
                StringBuilder sb = new StringBuilder();
                int len = 0;
                while (str.charAt(pos) != '#') {
                    len *= 10;
                    len += (str.charAt(pos++) - '0');
                }
                pos++;
                for (int i=0; i < len; i++) {
                    sb.append(str.charAt(pos++));
                }
                reslist.add(sb.toString());
            }
        }
        return reslist;
    }
}
