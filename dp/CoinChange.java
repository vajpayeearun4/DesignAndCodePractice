package dp;
class CoinChange 
{ 
	public static int countWays( int S[], int m, int n ) 
	{ 
	    // table[i] will be storing the number of solutions for 
	    // value i. We need n+1 rows as the table is constructed 
	    // in bottom up manner using the base case (n = 0) 
	    int table[]=new int[n+1]; 
	  
	    // Base case (If given value is 0) 
	    table[0] = 1; 
	  
	    // Pick all coins one by one and update the table[] values 
	    // after the index greater than or equal to the value of the 
	    // picked coin 
	    for(int i=0; i<m; i++) 
	        for(int j=S[i]; j<=n; j++) 
	            table[j] += table[j-S[i]]; 
	  
	    return table[n]; 
	}
  
    // Driver Function to test above function 
    public static void main(String args[]) 
    { 
        int arr[] = {1, 2, 3}; 
        int m = arr.length; 
        int n = 4; 
        System.out.println(countWays(arr, m, n)); 
    } 
}