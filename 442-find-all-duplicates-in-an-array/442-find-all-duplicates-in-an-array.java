class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        int i=0;
        while(i<n){
            int correct =nums[i]-1;
          if(nums[i]!=nums[correct]){
              swap(nums,i,correct);
          }else i++;
        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }
    
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 
    }
