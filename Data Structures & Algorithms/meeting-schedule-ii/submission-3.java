/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    private void sort(List<Interval> intervals) {
        Comparator<Interval> sortOrder = Comparator
            .comparingInt((Interval intvl) -> intvl.start)
            .thenComparingInt(intvl -> intvl.end);
        intervals.sort(sortOrder);
        return;
    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) { return 0; }
        sort(intervals);
        List<Interval> rooms = new ArrayList<>();
        rooms.add(intervals.get(0));
        for (int i=1; i < intervals.size(); i++) {
            boolean found = false;
            for (int j=0; (j < rooms.size()) && (! found); j++) {
                if (intervals.get(i).start >= rooms.get(j).end) {
                    found = true;
                    rooms.get(j).start = intervals.get(i).start;
                    rooms.get(j).end = intervals.get(i).end;
                }
            }
            if (! found) {
                rooms.add(intervals.get(i));
            }
        }
        return rooms.size();
    }
}
