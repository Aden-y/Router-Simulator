
public class RoutingPacket extends Packet{

	public RoutingPacket() {
		super();
	} // end of default constructor
	
	public boolean processFoundPacket(String packetData ) {
            System.out.println("The destintion already in the routing table");
		return false;
		
	}
	
	public boolean processNotFoundPacket(String packetData) {
            System.out.println("Adding record to the routing table");
		return false;
		
	}
}
