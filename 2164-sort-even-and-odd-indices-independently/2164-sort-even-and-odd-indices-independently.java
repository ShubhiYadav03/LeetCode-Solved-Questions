class Solution {
    public int[] sortEvenOdd(int[] nums) {
      int n = nums.length,l=0;
if((n&1)==1){
l=1;}
int[] a = new int[n/2+l];
int[] b = new int[n/2];


    int s=0,e=0;
    for(int i=0;i<n;i++){
        if((i&1)==0){
            a[s++]=nums[i];
        }else{
            b[e++]=nums[i];
        }
    }
    Arrays.sort(a);
    Arrays.sort(b);
    int ss=0,ee=b.length-1;
    for(int i=0;i<n;i++){
       if((i&1)==0){
            nums[i]=a[ss++];
        }else{
            nums[i]=b[ee--];
        } 
    }
    return nums;

    }
}