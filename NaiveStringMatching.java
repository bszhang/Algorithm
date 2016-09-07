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
	
	for(int i=0;i<m-n;i++){
		for(int j=i;j<i+n+1;j++){
			if(mother.charAt(j)!=son.charAt(j)) break;
		}
		index.add(j);
	}
	
	return index;
	
	
	
	
}

public static void main(String[] args){
	
	String mother = acccbacacad;
	String son = ac;
	ArrayList<Integer> result = nativeStringMatching(mother, son);
	for(int i:result){
		System.out.println(i);
	}
	
}
	
}


