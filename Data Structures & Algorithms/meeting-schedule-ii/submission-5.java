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
        int minRooms = 1;
        PriorityQueue<Interval> rooms = new PriorityQueue<>(Comparator.comparingInt(iv -> iv.end));
        rooms.offer(intervals.get(0));
        for (int i=1; i < intervals.size(); i++) {
            while ((! rooms.isEmpty()) && (rooms.peek().end <= intervals.get(i).start)) {
                rooms.poll();
            }
            rooms.offer(intervals.get(i));
            minRooms = Math.max(minRooms, rooms.size());
        }
        return minRooms;
    }
}
