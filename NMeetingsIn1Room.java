import java.util.*;

class Meeting {
    int start;
    int end;
    int index;
}

public class NMeetingsIn1Room {
    public int maxMeetings(int[] start, int[] end) {
       Meeting[] arr = new Meeting[start.length];

       for (int i=0; i<start.length; i++) {
            arr[i].start = start[i];
            arr[i].end = end[i];
            arr[i].index = i;
       }

       Arrays.sort(arr, (a, b) -> b.end - a.end);

        int endTime = arr[0].end;
        int totalMeetings = 1;
       for (int i=1; i<start.length; i++) {
            int starting = arr[i].start;
            int ending = arr[i].end;

            if (starting > endTime) {
                totalMeetings++;
                endTime = ending;
            }
       }

       return totalMeetings;
    }
}
