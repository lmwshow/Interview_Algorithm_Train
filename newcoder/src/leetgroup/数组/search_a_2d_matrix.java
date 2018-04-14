package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/15.
 */
public class search_a_2d_matrix {



//    Don't treat it as a 2D matrix, just treat it as a sorted list
//    Use binary search.
//
//            n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
//
//    an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
//    直接看成一个list， 用一次二分


    /*
    class Solution {
        public:
            bool searchMatrix(vector<vector<int> > &matrix, int target) {
                int n = matrix.size();
                int m = matrix[0].size();
                int l = 0, r = m * n - 1;
                while (l != r){
                    int mid = (l + r - 1) >> 1;
                    if (matrix[mid / m][mid % m] < target)
                        l = mid + 1;
                    else
                        r = mid;
                }
                return matrix[r / m][r % m] == target;
            }
        };
     */

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0)
            return false;

        int n = matrix[0].length;
        int targetrow = 0;
        for (int i = 0 ; i < m ; i++)
        {
            if (target <= matrix[i][n-1]) {
                targetrow = i;
                break;
            }
        }

        int left = 0;
        int right = n - 1;

        while (left <= right)
        {
            int mid = (left + right)/2;
            if (matrix[targetrow][mid] == target)
                return true;

            if (matrix[targetrow][mid] < target)
                left = mid +1;
            else
                right = mid - 1;
        }

        return false;
    }

}
