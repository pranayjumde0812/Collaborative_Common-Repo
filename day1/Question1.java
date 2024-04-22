// Implement a method to find the maximum element in an array
import java.util.*;
public class Question1{
    public static void maxElement(int[] arr){
    for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
    }
    }
        System.out.println("\nMax element of array is : "+arr[0]);
    }

    public static void ascendingSort(int[] arr){
    for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
    }
    }
        System.out.println("Ascending order of array")
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            }
    }

    public static int sumOfArr(int[] arr){
        int sum=0;
         for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            }
            return sum;

    }
    public static void main(String[] args){
        int arr[] = new int[5];
    Scanner sc= new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
            }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            }
            System.out.println();
    maxElement(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            }
    int arrSum = sumOfArr(arr);
            System.out.println("sum of the elements of array is: "+arrSum);
             System.out.println("average of the array is : "+((float)arrSum/arr.length));

    
             ascendingSort(arr);
    }
    
    }

    
