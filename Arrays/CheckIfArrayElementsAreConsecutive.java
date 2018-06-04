// disordered array
//
public class CheckIfArrayElementsAreConsecutive{



public static void main(String[] args){

    test();
}

public static boolean verify(int[] arr1){

if (arr1==null || arr1.length==0) {return false;}
if (arr1.length ==1) {return true;}
int[] flag = new int[arr1.length];
int min = Integer.MAX_VALUE;
for(int i:arr1){
  	if (i<min){
		min = i;
	}
}

for(int i : arr1){
    if ((i - min)>=arr1.length){
	return false;
	}
    else{
	flag[i - min] = 1;
	}
}

for(int i:flag){
	if (i==0) {return false;}
}
return true;
}

public static void test(){
   int arr1[] ={0,1,2,3,4,5};
   int arr2[] ={4,5,6,7,9,10};
   boolean verify1 = verify(arr1);
   boolean verify2 = verify(arr2);
   System.out.println("Verify 1 is : " + verify1);
   System.out.println("Verify 2 is : " + verify2);

}








}
