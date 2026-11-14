class Solution {
    private String getSignature(String s) {
        char[] carr = s.toCharArray();
        Arrays.sort(carr);
        return new String(carr);
    }

    private String getSignature1(String s) {
        int[] carr = new int[26];
        for (char c : s.toCharArray()) {
            carr[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < 26; i++) {
            if (carr[i] > 0) {
                char c = (char) ('a' + i);
                sb.append(c).append(carr[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> reslist = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sign = getSignature(s);
            if (! map.containsKey(sign)) {
                map.put(sign, new ArrayList<>());
            }
            map.get(sign).add(s);
        }
        return map.values().stream().toList();
    }
}
