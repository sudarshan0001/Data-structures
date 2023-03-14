class MergeSort {
    //merge sort can be achieved through divide and conquer method
    //step 1 divide the array until the size becomes 1
    //then conquer those divided arrays into an array in a sorted manner

    public static void divide(int[] arr,int si,int ei){
        if(si >= ei){
            return;
        }

        int mid = si + (ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }

    public static void conquer(int[] arr,int si,int mid,int ei){
        int[] merged = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int x = 0;

        while(idx1 <= mid && idx2 <= ei){
            if(arr[idx1] <= arr[idx2]){
                merged[x] = arr[idx1];
                x++;
                idx1++;
            }else{
                merged[x] = arr[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1<=mid){
            merged[x] = arr[idx1];
            x++;
            idx1++;
        }
        while(idx2<=ei){
            merged[x] = arr[idx2];
            x++;idx2++;
        }

        for(int i=0, j=si;i<merged.length; i++,j++){
            arr[j] = merged[i];
        }

    }

    public static void main(String[] args){
        int[] arr = {3,2,5,4,6,1,0};

        divide(arr,0,6);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }    
}
