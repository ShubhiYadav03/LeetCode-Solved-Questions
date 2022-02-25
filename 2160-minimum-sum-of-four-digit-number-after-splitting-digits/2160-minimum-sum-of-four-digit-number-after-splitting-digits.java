class Solution {
    public int minimumSum(int num) {
        int[] arr=new int[4];
        int i=0;
        while(num!=0&&i<4){
            arr[i]=num%10;
            num=num/10;
            i++;
         
        }
        
        Arrays.sort(arr);
        for(int j=0;j<4;j++) System.out.println(arr[j]);
        return (arr[3]+arr[2])+(arr[1]+arr[0])*10;
    }
}