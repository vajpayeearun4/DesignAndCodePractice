package array;
public class PrintMatrixInSpiralForm {

 public static void main(String[] args) {
  new PrintMatrixInSpiralForm();
 }

 public PrintMatrixInSpiralForm() {
  int[][] matrix = {
   {1,  2,  3,  4,  5},
   {6,  7,  8,  9,  10},
   {11, 12, 13, 14, 15},
   {16, 17, 18, 19, 20},
   {21, 22, 23, 24, 25}
  };
  
  printMatrixInSpiralWay(matrix);
 }
 
 private void printMatrixInSpiralWay(int[][] matrix){

  int rowStart=0;
  int rowLength=matrix.length-1;
  
  int colStart=0;
  int colLength = matrix[0].length-1;
  
  while(rowStart <= rowLength && colStart <= colLength){
  
   for (int i = rowStart; i <= colLength; i++) {
    System.out.print(matrix[rowStart][i] + " ");
   }

   for (int j = rowStart+1; j <= rowLength; j++) {
    System.out.print(matrix[j][colLength] + " ");
   }
   
   if(rowStart+1 <= rowLength){
    for (int k = colLength-1; k >= colStart; k--) {
     System.out.print(matrix[rowLength][k] + " ");
    }
   }
   if(colStart+1 <= colLength){
    for (int k = rowLength-1; k > rowStart; k--) {
     System.out.print(matrix[k][colStart] + " ");
    }
   }
   
   rowStart++;
   rowLength--;
   colStart++;
   colLength--;
  }
 }
}