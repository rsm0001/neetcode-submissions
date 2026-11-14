class CountSquares {
    private static final int MAXDIM = 1000;
    private final Map<Integer, Integer> map = new HashMap<>();
    private final Map<Integer, List<Integer>> xmap = new HashMap<>();
    private final Map<Integer, List<Integer>> ymap = new HashMap<>();

    public CountSquares() {}
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        int num = ((x * MAXDIM) + y);
        int cnt = map.getOrDefault(num, 0);
        map.put(num, (cnt + 1));
        List<Integer> ylist = xmap.getOrDefault(x, new ArrayList<>());
        ylist.add(y); xmap.put(x, ylist);
        List<Integer> xlist = ymap.getOrDefault(y, new ArrayList<>());
        xlist.add(x); ymap.put(y, xlist);
        return;
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        if ((null == xmap.get(x)) || (null == ymap.get(y))) {
            return 0;
        }
        int cnt = 0;
        for (int y1 : xmap.get(x)) {
            if (y != y1) {
                for (int x1 : ymap.get(y)) {
                    if (x != x1) {
                        int num = ((x1 * MAXDIM) + y1);
                        cnt += map.getOrDefault(num, 0);
                    }
                }
            }
        }
        return cnt;
    }
}
