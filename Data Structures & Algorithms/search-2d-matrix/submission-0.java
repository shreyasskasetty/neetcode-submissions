class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bot = matrix.length - 1;
        int top = 0;
        int right = matrix[0].length - 1;
        int left = 0;
        while(top <= bot){
            int m = (bot + top)/ 2;
            if(target < matrix[m][0]){
                bot = m - 1;
            }else if(target > matrix[m][matrix[0].length - 1]){
                top = m + 1;
            }else{
                break;
            }
        }

        if(!(top <= bot)){
            return false;
        }

        int row = (top + bot) / 2;
        while(left <= right){
            int m = (left + right)/2;
            
            if(target > matrix[row][m]){
                left = m + 1;
            }else if(target < matrix[row][m]){
                right = m - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
