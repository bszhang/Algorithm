
public class ArrayAddition{

public static void main(String[] args){

 	int[] arr1 = {1,2,3,4,5};
	int[] arr2 = {9,2,3,4,5};
	int[] result = add(arr1, arr2);
	for(int i: result){
		System.out.print(i + " ");
	}
	System.out.println();


}


public static int[] add(int[] arr1, int[] arr2){
	int maxLen = Math.max(arr1.length, arr2.length);
 	int max1 = arr1.length;
 	int max2 = arr2.length;
        int[] result = new int[maxLen];
        // remaining
	int r = 0;
	// increase
	int c = 0;

	int i = max1-1;
	int j = max2-1;

        int k = maxLen - 1;

	while(i>=0 && j>=0){
		r = arr1[i--] + arr2[j--] + c;
		c = r/10;
		result[k--] = r%10; 
	}
	while(i>=0){
		r = arr1[i--] + c;
		c = r/10;
		result[k--] = r%10;
	}
	while(j>=0){
		r = arr2[j--] + c;
		c = r/10;
		result[k--] = r%10;
	}

	if (c!=0){
		int[] newResult = new int[maxLen + 1];
		for(int t = maxLen; t>=1;t--){
			newResult[t] = result[t-1];
		}
                newResult[0] = c;
		return newResult;
	}
	return result;
}


}
