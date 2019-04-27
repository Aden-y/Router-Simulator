import java.util.Scanner;

public class Packet {
	protected IPAddress sourceAddress;
	protected IPAddress destinationAddress;
	protected String packetData;

	// default constructor
	public Packet() {
		sourceAddress = new IPAddress();
		destinationAddress = new IPAddress();
		packetData = null;

	} // end of default constructor

	public boolean readPacket(Scanner inFile) {

		char validDestination;
	
		// p is used to update the routing table
		// d is used to route to destination, contain only data

		while (inFile.hasNextLine()) {

		validDestination = inFile.next().toLowerCase().charAt(0); // save the first token and convert it to lower case for later processing
		/*
		 * this line will check for the first token is either "p" or "d" else
		 * there is no need to continue on reading
		 * return false and display error message
		 */
		while (inFile.hasNextLine()) {
			if (!(validDestination == 'p') || (validDestination == 'd')) {
				System.out.println("Packe type was not found.");
				return false;
			} else {
				destinationAddress.readAddress(inFile);
			}
		}
		}
			return true;

	} // end of readPacket method

	public IPAddress getDestNetwork() {
		return new IPAddress();
		
	} // end of getDestNetwork method

	public boolean processFoundPacket(String packetData) {
		return true;

	} // end of processFoundPacket method

	public boolean processNotFound(String packetData) {
		return true;

	} // end of processFoundPacket method

	public String getPacketData() {
		return packetData;

	}
}
