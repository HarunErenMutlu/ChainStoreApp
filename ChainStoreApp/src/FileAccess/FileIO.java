package FileAccess;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * This is our FileIO class that reads the given 5 csv files. 
 * 
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
public class FileIO {
	private String line;
	private int count;
	private String file;
	
	private int getCount(String file) {// method that counts the number of lines of the given file
		FileReader fr;
		try {// we wrote this part to catch errors while reading the files
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			int tempCount = 0;
			while ((line= br.readLine()) != null) {
				tempCount ++;
			}
			br.close();
			fr.close();
			return tempCount;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}
		 // method that reads HW1_Items.csv file and convert the data to two-dimensional array

		public String[][] getItems(){
			file = "HW1_Items.csv";
			int tempCount=this.getCount(file);
			String[][] listItem = new String[tempCount][3];			
			//two dimensional items array
			
			try {// we wrote this part to catch errors while reading the files
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				this.count = 0;

				while ((line= br.readLine()) != null) {
					int count_second= 0; // it is the second index of two-dimensional array 
					
					String[] listOfData = line.split(",");	// it creates a list and store all the data from line				
					while(count_second < listOfData.length) {
						listItem[count][count_second] = listOfData[count_second];
						count_second++;}
					count++;
					} 
					//need to close fileReader and buffer reader 
					br.close();
					fr.close();	
			} catch(FileNotFoundException exception) {
				System.out.println("Cities file not found"); 
			} catch(IOException exception) {
				System.out.println(exception);
			}
			
			return listItem;
		}
		

		
		public String[][] getStores(){
			int tempCount= 0; 
			int countFile = 1;
			file = "HW1_Transactions_Store%o.csv";
			while(countFile<=4) {
			tempCount+=this.getCount(String.format(file,countFile++));}
			countFile = 1;
			String[][] listStores = new String[tempCount][37];
			count=0;	
			
			//two dimensional cities array
			
			try {while(countFile<5) {// we wrote this part to catch errors while reading the files
				FileReader fr = new FileReader(String.format(file, countFile));
				BufferedReader br = new BufferedReader(fr);
				
				//loop to reach total city count

				while ((line= br.readLine()) != null) {
					int count_second = 0;
					String[] listOfData = line.split(","); // it creates a list and store all the data from line	
					while(count_second < listOfData.length) {
					listStores[count][count_second] = listOfData[count_second];
					count_second++;}
					count++;
					} 
					//need to close fileReader and buffer reader 
					br.close();
					fr.close();
					countFile++;}
			} catch(FileNotFoundException exception) {
				System.out.println("Cities file not found"); 
			} catch(IOException exception) {
				System.out.println(exception);
			}
			return listStores;
		}
	}