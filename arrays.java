import java.util.*;
public class arrays 
{
    public static int linearSearch(int n[],int key)
    {
        
        for(int i=0;i<n.length; i++)
        {
            if(n[i]==key)
            {
                return i;
            }
        }
        return -1;


    }

    // public static int getLargest(int n[])
    // {
    //     int largest = Integer.MIN_VALUE;//-infinity
    //     int smallest = Integer.MAX_VALUE;//+infinity
    //     for(int i=0;i<n.length;i++)
    //     {
    //         if(largest<n[i])
    //         {
    //             largest=n[i];
    //         }
    //         if(smallest>n[i])
    //         {
    //             smallest=n[i];
    //         }
    //     }
    //     System.out.println(" Smallest value is :"+smallest);
    //     return largest;
    // }

    // public static int binarySearch(int n[], int key)
    // {
    //     int start =0 ,end = n.length-1;
    //     while(start<= end)
    //     {
    //         int mid =(start+end)/2;
    //         //comparisons

    //         if(n[mid]==key)//found
    //         {
    //             return mid;
    //         }
    //         if(n[mid]<key)//right
    //         {
    //             start = mid+1;
                
    //         }
    //         else
    //         {
    //             end = mid -1;//left
    //         }
    //     }
    //     return -1;
    // }

    // public static void reverseArray(int n[])
    // {
    //     int first =0, last= n.length-1;
    //     while(first<last)
    //     {
    //         //swap
    //         int temp = n[last];
    //         n[last]=n[first];
    //         n[first]=temp;
    //         first++;
    //         last--;
    //     }
    // }

    // public static void printPairs(int n[])
    // {
    //     int total=0;
    //     for(int i=0; i<n.length; i++)
    //     {
    //         int curr = n[i];
    //         for(int j= i+1;j<n.length; j++)
    //         {
    //             System.out.print("(" +curr+ ","+n[j]+ ")");
    //             total++;
    //         }
    //         System.out.println();
    //     }
    //     System.out.println("Total pairs:"+total);
    // }

    // public static void printSubarrays(int n[])
    // {
    //     int ts=0;
    //     for(int i=0; i<n.length; i++)
    //     {
    //         int start =i;
    //         for(int j=i; j<n.length; j++)
    //         {
    //             int end =j;
    //             for(int k= start; k<=end; k++)//printing subarray
    //             {
    //                 System.out.print(n[k]+" ");
    //                 ts++;
    //             }
    //             System.out.println();
    //         }
    //         System.out.println();
    //     }
    //     System.out.print("Total subarrays="+ts);
    // }
    
    // public static boolean containsDuplicate(int n[])
    // {
    //     for(int i=0; i< n.length-1; i++)
    //     {
    //         for(int j=i+1 ; j<n.length; j++)
    //         {
    //             if(n[i]==n[j])
    //             {
    //                 return true;
    //             }
    //         }

    //     }
    //     return false;
            
    // }
    // public static int maxProfit( int n[])
    // {
    //     int buy = n[0];
    //     int profit =0;

    //     for( int i=0; i<n.length-1; i++)
    //     {
    //         if(buy<n[i])
    //         {
    //             profit = Math.max(n[i]-buy,profit);
    //         }
    //         else
    //         {
    //             buy = n[i];
    //         }
    //     }
    //     return profit;

    // }
    // public static void maxSubarraySumUsingBruteForce(int n[])
    // {
    //     int currSum =0;
    //     int maxSum= Integer.MIN_VALUE;  

    //     for(int i=0; i<n.length;i++)
    //     {
    //         int start=i;
    //         for(int j=i; j<n.length; j++)
    //         {
    //             int end =j;
    //             for(int k =start; k<=end; k++)
    //             {
    //                 //subarray sum
    //                 currSum += n[k];

    //             }
    //             System.out.println(currSum);
    //             if(maxSum < currSum)
    //             {
    //                 maxSum = currSum;
    //             }
    //         }
            
    //     }
    //     System.out.println("MAXIMUM SUM = "+maxSum);
    // }

    // public static void maxSubarraySumUsingPrefix(int n[])
    // {
    //     int currSum =0;
    //     int maxSum = Integer.MIN_VALUE;
    //     int prefix[] = new int[n.length];

    //     prefix[0] = n[0];
    //     //calculate prefix array
    //     for(int i=1 ; i<prefix.length; i++)
    //     {
    //         prefix[i] = prefix[i-1] + n[i];
    //     }

    //     for(int i=0; i<n.length; i++)
    //     {
    //         int start =i;
    //         for(int j=i ;j<n.length; j++)
    //         {
    //             int end = j;
    //             currSum = (start == 0)? prefix[end] : prefix[end] + prefix[start -1];
    //             if(maxSum < currSum)
    //             {
    //                 maxSum = currSum;
    //             }
    //         }
    //     }
    //     System.out.println("MAX SUM = "+maxSum);

    // }

    // public static void kadanes(int n[])
    // {
    //     int maxSum= Integer.MIN_VALUE;
    //     int currSum =0;
    //     for(int i=0; i<n.length; i++)
    //     {
    //         currSum += n[i];
    //         if(currSum < 0)
    //         {
    //             currSum =0;
    //         }
    //         maxSum = Math.max(currSum , maxSum);
    //     }
    //     System.out.println("MAXIMUM SUM ="+maxSum);
    // }

    // public static int trappedWater(int height[])
    // {
    //     int n = height.length;
    //     //calculate left boundary
    //     int leftBound[]= new int[n];
    //     leftBound[0]= height[0];
    //     for(int i=1; i<n; i++)
    //     {
    //         leftBound[i]= Math.max(height[i], leftBound[i-1]);
    //     }
        
    //     //calculate right boundary
    //     int rightBound[] = new int[n];
    //     rightBound[n-1] = height[n-1];
    //     for(int i= n-2; i>=0; i--)
    //     {
    //         rightBound[i]= Math.max(height[i], rightBound[i+1]);
    //     }
    //     int trappedWater =0;
    //     for(int i=0; i<n ;i++)
    //     {
    //         int WaterLevel = Math.min(leftBound[i],rightBound[i]);
    //         trappedWater += WaterLevel - height[i];
    //     }
    //     return trappedWater;

    // }

    // public static List<List<Integers>> triplets(int n[])
    // {
    //     List<List<Integers>> result=new List<List<Integers>>();
    //     for(int i=0;i<n.length;i++){
    //         for(int j=i+1;j<n.length;j++){
    //             for(int k=j+1;k<n.length;k++){
    //                 if(n[i]+n[j]+n[k]==0){
    //                     List<Integer> triplet=new List<Integer>();
    //                     triplet.add(n[i]);
    //                     triplet.add(n[j]);
    //                     triplet.add(n[k]);
    //                     result.add(triplet);
    //                 }
    //             }
    //         }
    //     }
    //     return result;

    // }
    
    
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n[] = new int[5];
        System.out.print("Enter the elements in an array:");
            
        for(int i = 0; i< n.length; i++)
        {
           n[i]= sc.nextInt();
        }
        
        System.out.println("Enter the number to be searched:");
        int key = sc.nextInt();
        int index = linearSearch(n,key);
        //int index = binarySearch(n,key);

        if(index == -1)
        {
           System.out.println("NOT FOUND");
        }
        else
        {
           System.out.println("KEY IS AT INDEX : "+index);
        }
        //System.out.println("Largest value is at:"+getLargest(n));

        //reverseArray(n);
        //print
        //for(int i=0; i< n.length; i++)
        //{
        //    System.out.print(n[i]+" ");
        //}
        //System.out.println();
        //printPairs(n);
        //printSubarrays(n);
        //System.out.println(containsDuplicate(n));
        //maxProfit(n);
        

        //maxSubarraySumUsingBruteForce(n);
        //maxSubarraySumUsingPrefix(n);
        //kadanes(n);
        // int height[] = {4,2,0,6,3,2,5};
        // System.out.println(trappedWater(height));

        sc.close();
    }
    
}
