package Top_Interview_Questions_2;

public class Question48_旋转矩阵 {

    //更方便的解法 ， 可以先转置，然后对每一行逆序， 就可以得到旋转矩阵

    public static void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
            return;

        int rows = matrix.length;
        
        int time = rows/2;          //每次对最外层进行旋转处理，对于整个矩阵只需要旋转rows/2次
        
        for (int i = 0; i < time ;i++)
            oneRotate(matrix,i);
        
        return;
    }

    private static void oneRotate(int[][] matrix, int level) {
        
        int start = level;
        int end = matrix.length - start - 1;
        
        for (int i = start ;i < end ;i++)                   //对于每一层，旋转end-start-1次，每次依次交换
        {                           
            int tmp = matrix[start][i];
            matrix[start][i] = matrix[end+start-i][start];
            matrix[end+start-i][start] = matrix[end][end+start-i];
            matrix[end][end+start-i] = matrix[i][end];
            matrix[i][end] = tmp;
            
        }
        
    }
    
    
    public static void main(String[] args) {

        int[][] nums = new int[][]{{5,1, 9, 11}, {2,4, 8, 10}, {13,3,6,7},{15,14,12,16}};
        rotate(nums);

        for (int[] num : nums){
            for (int x:num)
                System.out.println(x);
            System.out.println();
        }
    
    }
}
