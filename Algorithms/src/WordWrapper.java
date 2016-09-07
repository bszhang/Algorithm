import java.util.ArrayList;

// input String[], line length n
// output lines

public class WordWrapper{

	private String[] sentense;
	private int n;
	private ArrayList<ArrayList<String>> context = new ArrayList<ArrayList<String>>();


	public WordWrapper(String[] input, int len){
		sentense = input;
		n = len;
		System.out.println("Input String array is " + sentense);
		System.out.println("Input each line length is " + n);
	}

	
	
	
	public ArrayList<ArrayList<String>> dp(){
		// minimal raggedness
		context = new ArrayList<ArrayList<String>>();
		return context;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ArrayList<ArrayList<String>> greedy(){
		// minimal number of lines;
		context = new ArrayList<ArrayList<String>>();
		System.out.println("Using greedy method to assign each line: ");
		if ((sentense.length==0)||(sentense==null)){
			return context;
		}

		int n_words=0;

		// while there are words left
		while(n_words<sentense.length){

			// start a new line
			int current_len = -1;
			ArrayList<String> newLine = new ArrayList<String>();

			// assemble new words in each line
			while(++current_len + sentense[n_words].length()<n){
				current_len = current_len + sentense[n_words].length();
				newLine.add(sentense[n_words]);
				n_words++;
				if (n_words==sentense.length){
					break;
				}
			}
			context.add(newLine);
		}
		return context;
	}


	public void getOutput(){

		for(  ArrayList<String> sentense : context){
			int cur_len=-1;
			int count = 0;
			for(String word : sentense){
				cur_len++;
				count++;
				System.out.print(word);
				cur_len+=word.length();
				if (count==sentense.size()){
					if(cur_len==n){
						break;
					}
					else{
						for(int i=0;i<n-cur_len;i++){
							System.out.print("#");
						    }
					    }
				}
				else{
					System.out.print(" ");
				}

			}
			System.out.println();

		}
	}


	public static void main(String[] args){
		String[] s = new String[]{"I","am","a","fucking","genious"};
		int length = 10;
		WordWrapper ww = new WordWrapper(s, length);
		ww.greedy();
		ww.getOutput();
	}

}
