// You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. 
// Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

// Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

class Meeting{
    int start;
    int end;
    public Meeting(int _start, int _end){
        this.start=_start;
        this.end=_end;
    }
}
class Solution {
    public int maxMeetings(int n, int start[], int end[]) {
        
        Meeting[] meetings = new Meeting[n];
        
        for(int i=0;i<n;i++){
            Meeting m = new Meeting(start[i],end[i]);
            meetings[i] = m;
        }
        
        Arrays.sort(meetings, (a,b)-> a.end - b.end);
        
        int count = 1;
        int endTime = meetings[0].end;
        
        for(int i=1;i<n;i++){
            if(meetings[i].start>endTime){
                count ++;
                endTime = meetings[i].end;
            }
        }
        return count;
    }
}
