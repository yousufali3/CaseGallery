import java.util.*;
class Merge{
  public static void merge(int arr[] , int low , int mid, int high) {
    ArrayList<Integer> list = new ArrayList<>();
    int left = low;
    int right = mid+1;
    
    while(left<=mid && right <=high){
      if(arr[left]<arr[right]){
          list.add(arr[left]);
          left++;
      }else{
        list.add(arr[right]);
        right++;
      }
    }

    while(left<=mid){
       list.add(arr[left]);
      left++;
    }

    while(right <=high){
      list.add(arr[right]);
      right++;
    }

    for(int i=low; i<=high; i++){
      arr[i] = list.get(i-low);
    }

  } 
  public static void ms(int arr[] , int low , int high){
    if(low >=high) return;
    int mid = (low + high) / 2;
    ms(arr, low, mid);
    ms(arr , mid+1, high);
    merge(arr , low,mid,high);
  }
  public static void mergeSort(int arr[] , int n){
      ms(arr, 0 , n-1);
  }
  public static void main(String [] args){
      int arr[] = {4,5,2,1,3};
      int n = arr.length;
      System.out.println(Arrays.toString(arr));
      mergeSort(arr, n);
      System.out.println(Arrays.toString(arr));
  }
}