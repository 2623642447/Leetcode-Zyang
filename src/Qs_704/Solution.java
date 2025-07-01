package Qs_704;

class Solution {

    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12};
        int target = 9;
        Solution s = new Solution();
        s.mySearch(nums, target);

        nums = new int[]{-1,0,3,5,9,12};
        target = 2;
        s.mySearch(nums, target);
    }

    public int mySearch(int[] nums, int target) {
        int j = nums.length-1;
        int i = 0;
        int result = -1;
        //边界条件有问题，当数组只有相同元素时条件错误
        while(target > nums[i] && target < nums[j] && i != j){
            int k = (i+j)/2;
            if(k == i || k == j){
                return result;
            }
            if(target > nums[k]){
                i = k;
            }else if(target < nums[k]){
                j = k;
            }else{
                result = k;
                break;
            }
        }
        return result;
    }

    public int fixMySearch(int[] nums, int target) {
        int j = nums.length-1;
        int i = 0;
        int result = -1;
        //这里要是<= 如果是<存在当数组只有一个元素的情况
        while(i <= j){
            int k = (i+j)/2;
            if(target > nums[k]){
                //这里+1、-1是为了防止(i+j)/2 = i || j，使得代码无限循环
                i = k+1;
            }else if(target < nums[k]){
                j = k-1;
            }else{
                result = k;
                break;
            }
        }
        return result;
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}