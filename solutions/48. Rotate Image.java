class Solution {
    /*
        Notes:
        
            => Outer Iteration
                Q: How many iterations I wanna do?
                We need to reduce the iteration by two in every iteration
                The total number of iteration can be (Matrix.length / 2)
                
        
            => Inner Iteration:
                to shrink the window of iteration and move to next layer
                start iteration from current layer index
                and end iteration up to (size - layer)
                
            => getting cells values
                            Row                                                 column
                    top     changing in every outer iteration                      changing in every inner iteration
                            [layer]                                             [j]
                    
                    right   changing in every inner iteration                    chanign inward in every outer iteration
                            [j]                                                  [size - layer]
                            
                    bottom  changing in every outer iteration inward             changing in every inner iteration inward
                            [size - layer]                                       [size - j]
                            
                    left    changing in every inner iteration inward             changing in every outer iteration
                            [size - j]                                           [layer]
                            
    */
    
    public void rotate(int[][] matrix) {
       int size = matrix.length - 1;
        for(int layer = 0; layer < (matrix.length / 2); layer++){
            for(int j = layer; j < (size - layer); j++){
                int top = matrix[layer][j];
                int right = matrix[j][size-layer] ;
                int bottom = matrix[size -layer][size-j] ;
                int left = matrix[size -j][layer] ;
                
                matrix[ layer][j] = left;
                matrix[j][size-layer] = top;
                matrix[size-layer][size-j] = right ;
                matrix[ size -j][layer]=bottom ;
            }
        }
    }
    
    // for tracing
    private void printMatrix(int[][] matrix) {
        System.out.println("--------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("  " + matrix[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
}
​
​
​
​
​
​
​
​
