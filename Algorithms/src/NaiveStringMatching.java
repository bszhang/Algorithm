import java.util.ArrayList;


public class NaiveStringMatching{
	
	public static ArrayList<Integer> nativeStringMatching(String mother, String son){
	ArrayList<Integer> index = new ArrayList<Integer>();
	if (mother.isEmpty() || son.isEmpty()||son.length()> mother.length()){
		index.add(-1);
		return index;
	}

	int m = mother.length();
	int n = son.length();
	
	for(int i=0;i<m-n+1;i++){
		for(int k=i,j=0;j<n;j++,k++){
			if(mother.charAt(k)!=son.charAt(j)) break;
			if (j==(n-1)){
				index.add(i);
				}
		}
		
	}
	return index;
}

	public static ArrayList<Integer> nativeStringMatching_PatternHasDifferentChar(String mother, String son){
		ArrayList<Integer> index = new ArrayList<Integer>();
		if (mother.isEmpty() || son.isEmpty()||son.length()> mother.length()){
			index.add(-1);
			return index;
		}

		int m = mother.length();
		int n = son.length();
		int step=0;
		for(int i=0;i<m-n+1;i+=step){
			for(int k=i,j=0;j<n;j++,k++){
				if(mother.charAt(k)!=son.charAt(j)) {
					step=k+1;
					break;
				}
				if (j==(n-1)){
					index.add(i);
					}
			}
			
		}
		return index;
	}
	
	
	
	
	
public static void main(String[] args){
	
	String mother = "AABCDEDFABC";
	String son = "ABC";
	ArrayList<Integer> result = nativeStringMatching(mother, son);
	for(int i:result){
		System.out.println(i);
	}
	
}
	
}


