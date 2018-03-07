import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class WALK {
	static int[] parents;
	static String[] vertices;
	static HashMap<String, Integer> location;
	static boolean prime[];

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		location = new HashMap<String, Integer>();
		InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String input = in.readLine();
        String [] temp = input.split(" ");
        int treeSize = Integer.parseInt(temp[0]);
        long prime = Long.parseLong(temp[1]);
        int nQuestions = Integer.parseInt(temp[2]);
        
        input = in.readLine();
        vertices = input.split(" ");        
                
        input = in.readLine();
        temp = input.split(" ");        
        
        parents = new int[temp.length+1];
        
        for(int i=0; i < temp.length; i++)
        	parents[i+1] = Integer.parseInt(temp[i])-1;
        
        int[][] questions = new int[nQuestions][2];
        
        for(int i=0; i<nQuestions; i++){
        	input = in.readLine();
            temp = input.split(" "); 
        	questions[i][0] = Integer.parseInt(temp[0]) -1;
        	questions[i][1] = Integer.parseInt(temp[1]) -1;
        }
        
        //for(int i = 0; i<vertices.length; i++)
        //	location.put(vertices[i],i);
        //sieveOfEratosthenes((int)Math.sqrt(prime));
        
        
        for(int i=0; i<nQuestions; i++){
        	Long number = Long.parseLong(constructNumber(questions[i][0],questions[i][1]));
        	System.out.println(number%prime==0?"YES":"NO");
        }              
	}
	
	public static String constructNumber(int start, int end){
		String result = "";
		
		while(end!=start){
			result = vertices[end] + result;
			end = parents[end];
		}
		return result;
	}
	
	
	static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
         
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }
    }

}
