class Solution
{
    public int NthRoot(int n, int m)
    {
        int left = 1;
        int right = m;
        
        int ans = 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            
            int val = getValue(mid,n,m);
            
            if(val==1) return mid;
            else if(val==0) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
    
    public int getValue(int mid, int n, int m){
        int ans = 1;
        
        for(int i=1;i<=n;i++){
            ans = ans * mid;
            if(ans>m) return 2;
        }
        
        if(ans == m) return 1;
        return 0;
    }
}
