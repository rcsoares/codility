import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverlapIntervals {

    public static void main(String[] args) {
        int[] a = new int[]{1, 12, 42, 70, 36, -4, 43, 15};
        int[] b = new int[]{5, 15, 44, 72, 36, 2, 69, 24};
        System.out.println(solution(a, b));
    }

    static int solution(int[] A, int[] B) {


        List<Interval> intervals = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            intervals.add(new Interval(A[i], B[i]));
        }

        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);


        for (int i = 1; i < intervals.size(); i++) {

            if (intervals.get(i - 1).end <= intervals.get(i).start) {
                count++;
            }
        }

        return count;
    }
}

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + start + "," + end + "}";
    }
}
