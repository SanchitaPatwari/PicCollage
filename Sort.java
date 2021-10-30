public class Sort {
	

public static void selectionSort (int[] a) 
{
int n = a.length;
for ( int i = 0 ; i < n; i++ ) 
{    
int min = i;
    for ( int j = i+1; j < n; j++ ) 
{      
    if (a[j] < a[min]) 
{
          min = j;
			} 
          	}    
          	 exchange(a, i, min);
          	 System.out.println(a);
          	    }
          	}
       private static void exchange (int[] a, int i, int j) {
           int temp = a[i];
                a[i] = a[j];
                a[j] = temp;  }
                

 public static void main(String[] args) {

                int [] x= {3,17,19,1,24,2,20};
                System.out.println(selectionSort(x));
                }
            }
