import java.util.HashMap;

public class DuplicateWithinkIndices{

public static void main(String[] args){
test();
}


public static void test(){
	int k1 = 3;
	int[] arr1 = {1,2,3,4,1,2,3,4};
 	boolean v1 = verify(k1, arr1);
	System.out.println(v1);

        int k2 = 3;
	int[] arr2 = {1,2,3,1,4,5};
	boolean v2 = verify(k2, arr2);
	System.out.println(v2);

	int k3 = 3;
	int[] arr3 = {1,2,3,4,5};
  	System.out.println(verify(k3, arr3));

     	int k4 = 3;
	int[] arr4 = {1,2,3,4,4};
	System.out.println(verify(k4, arr4));

}

public static boolean verify(int k, int[] arr){

HashMap<Integer, Integer> h = new HashMap<>();
for(int i=0;i<arr.length;i++){
	if(h.containsKey(arr[i])){
		if(i - h.get(arr[i])<=k){
			return true;
		}
	}
	else{h.put(arr[i], i);}
}
return false;
}

}
