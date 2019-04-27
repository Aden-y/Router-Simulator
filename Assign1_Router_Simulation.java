import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Assign1_Router_Simulation {

	private static Scanner input;
	private static Router router;
	private static char packetType;

	public static void main(String[] args) throws Exception {
		
		input = new Scanner(System.in); // keyboard input
		//packetType = router.(packetType);
		Scanner inFile = null;
		

		int choice = 0;

		boolean isValid = false;
		
		while (true) {
			menuScreen();
			
			System.out.print("\nEnter: ");
		while (!isValid) {
			
			if (input.hasNextInt()) {
				choice = input.nextInt();
				isValid = true;
			} else {
				System.out.print("Invalid entry. Enter interger only: ");
				System.out.print("\nEnter: ");
				input.next(); // Returns the next token if it matches
				isValid = false;
			}
			}
		
			switch (choice) {
			case 1: // prompt user for size
				continue;
			case 2: 
				inFile = openFile(input);
//				if (inFile != null) {
//					if () {
//						System.out.println("IPAddress OK.");
//					} else {
//						System.out.println("IPAddress NOT OK.");
//					}
//				}

				continue;
			case 3: // start stimulation
				System.out.println("Running Simulation...");
				TimeUnit.SECONDS.sleep(1);
				continue;
			case 4:
				System.out.println("Ending Router Simulation...");
				TimeUnit.SECONDS.sleep(1);
				System.exit(0);
			default:
				System.out.println("Invalid entry\n");
			}
		}
	} // end of main

	public static void menuScreen() {

		// menu selection screen
		System.out.println();
		System.out.println("-----------Router Simulation----------- ");
		System.out.println();
		System.out.println("2: Load a file");
		System.out.println("3: Start Router Simulation");
		System.out.println("4: Quit Simulation");
		
	} // end of menuScreen
	
	public static Scanner openFile(Scanner input) {
		
		Scanner inFile = null;
		String fileName = new String();

		System.out.print("Enter name of file to process: ");
		fileName = input.next();

		try {
			File file = new File(fileName);
			if (file.exists()) {
				inFile = new Scanner(file); // create a new Scanner connecting to file
				if (inFile.hasNext()) { // check if file contain numbers
				} else {
					System.out.println("File is empty.");
					return null;
				}
			} else
				System.out.println("File does not exist...");
			return inFile;
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file..." + fileName + "exiting");
			return null;
		}

	}// end openFile method

} // end of Assign1_ROUter_Simulation
