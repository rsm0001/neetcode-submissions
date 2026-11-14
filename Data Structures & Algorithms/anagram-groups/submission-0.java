class Solution {
    private String getSignature(String s) {
        char[] carr = s.toCharArray();
        Arrays.sort(carr);
        return new String(carr);
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
