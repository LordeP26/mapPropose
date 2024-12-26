package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader (new FileReader(path))){
			
			Map<String, Integer> vote = new  LinkedHashMap<>();
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int quantity = Integer.parseInt(fields[1]);
				
				if (vote.containsKey(name)) {
					
					int votesSoFar = vote.get(name);
					vote.put(name, quantity + votesSoFar);
					
				}else {
					
					vote.put(name,quantity);
					
				}
				
				line = br.readLine();
			}
			
			for (String key : vote.keySet()) {
				 System.out.println(key + ": " + vote.get(key));
			}
			
			
		}catch(IOException e ) {
			System.out.print("Error: " + e.getMessage());
		}

		
		sc.close();
	}

}
