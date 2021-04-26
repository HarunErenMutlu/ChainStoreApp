package StoreApp;
/*
 * This program ChainStoreApp where has the main method.
 * So program starts from here and creates an PrintEverything class 
 * then calls this class to print all of the topics.
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
import java.io.IOException;

public class ChainStoreApp { 
	private static PrintEverything printAll;
	public static void main(String[] args) throws IOException {
			printAll = new PrintEverything();
			printAll.PrintEvetything();
		
		}
	}

