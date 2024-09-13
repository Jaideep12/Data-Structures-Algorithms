class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int [] ans = new int [2];
        ans[0] = getFloor(x,arr);
        ans[1] = getCeil(x,arr);
        
        return ans;
    }
    
    public int getFloor(int x, int[] arr){
        int left=0;
        int right = arr.length-1;
        int ans = -1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(arr[mid]==x){
                ans = arr[mid];
                break;
            }else if(arr[mid]>x){
                right = mid-1;
            }else{
                ans = arr[mid];
                left=mid+1;
            }
        }
        return ans;
    }
    
    public int getCeil(int x, int[] arr){
        int left=0;
        int right = arr.length-1;
        int ans = -1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(arr[mid]==x){
                ans = arr[mid];
                break;
            }else if(arr[mid]>x){
                ans = arr[mid];
                right = mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}
