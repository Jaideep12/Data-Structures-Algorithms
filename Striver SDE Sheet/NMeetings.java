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
