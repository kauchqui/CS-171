
public class quicksort {
		static int partition(int a[], int hi, int lo){
			int pivot = hi;
		    int i =lo;
		    int j = hi;
		    while(i<j)
		    {
		        if(a[i]<=a[pivot])
		        {
		            i++;
		        }
		        if(a[i]>a[pivot])
		        {   
		        if((a[i]>a[pivot]) && (a[j]<=a[pivot]))
		        {
		            int temp= a[i];
		            a[i]=a[j];
		            a[j]=temp;
		            i++;    
		        }
		        if(a[j]>a[pivot])
		        {
		            j--;
		        }
		        }
		    }
		    int temp= a[i];
		    a[i]=a[pivot];
		    a[pivot]=temp;
		    return i;
			
			
			
			
			
		}
		static void quicksort(int x[], int hi, int lo){
			if(lo>hi){
				return;
			}
			int split = partition(x, hi,lo);
			quicksort(x, hi, split+1);
			quicksort(x, split-1,lo);
		}
	
	
	public static void main(String args[]){
		int a[] = {4,3,2,1,6,5,3,6,8};
		
		quicksort(a,a.length-1,0);
		
		for(int i =0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}
	
}
