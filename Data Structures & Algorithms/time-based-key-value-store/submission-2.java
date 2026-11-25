class TimeMap {
    private final Map<String, List<Integer>> tmap;
    private final Map<String, List<String>> vmap;
    public TimeMap() {
        tmap = new HashMap<>(); vmap = new HashMap<>();
    }
    
    // All the timestamps of set are strictly increasing.
    // Hence no need to find an insertion point.
    public void set(String key, String value, int timestamp) {
        List<Integer> timelist = tmap.getOrDefault(key, new ArrayList<>());
        timelist.add(timestamp); tmap.put(key, timelist);
        List<String> valuelist = vmap.getOrDefault(key, new ArrayList<>());
        valuelist.add(value); vmap.put(key, valuelist);
        // System.out.println(key + "_" + timestamp + ": " + value);
        return;
    }
    
    public String get(String key, int timestamp) {
        if (tmap.containsKey(key)) {
            List<Integer> tlist = tmap.get(key);
            if (! tlist.isEmpty()) {
                List<String> vlist = vmap.get(key);
                int indx = Collections.binarySearch(tlist, timestamp);
                // System.out.println("INDX: <" + indx + ">");
                if (indx < 0) { indx = (-indx - 2); }
                if (indx >= 0) { return vlist.get(indx); }
            }
        }
        return "";
    }
}
