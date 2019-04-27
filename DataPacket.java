
public class DataPacket extends Packet{

	public DataPacket() {
		super();
	} // end of default constructor
	
	public boolean processFoundPacket(String packetData) {
		return false;
	} // end of processFoundPacket method
	
	public boolean processNotFoundPacket(String packetData) {
		return false;
	} // end of processNotFound method
} // end of DataPacket class

