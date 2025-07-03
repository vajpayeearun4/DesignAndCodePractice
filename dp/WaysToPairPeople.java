package dp;

public class WaysToPairPeople {
	static int findWaysToPair(int p)  
	{  
	    // To store count of number of ways.  
	    int dp[] = new int[p + 1];  
	  
	    dp[1] = 1;  
	    dp[2] = 2;  
	  
	    // Using the recurrence defined find  
	    // count for different values of p.  
	    for (int i = 3; i <= p; i++) 
	    {  
	        dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];  
	    }  
	  
	    return dp[p];  
	}  
	  
	// Driver code  
	public static void main(String args[]) 
	{  
	    int p = 3;  
	    System.out.println(findWaysToPair(p)); 
	}  

}
