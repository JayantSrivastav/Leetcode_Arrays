class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        Stack <Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for(int i = 0; i<2*n ; i++){
            int currentIndex = i % n;
            while (!st.isEmpty() && nums[currentIndex] > nums[st.peek()]) {
                int index = st.pop();
                result[index] = nums[currentIndex];
            }
            if(i< n){
                st.push(currentIndex);
            }
        }
        return result;
    }
}