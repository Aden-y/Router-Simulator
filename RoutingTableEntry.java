
public class RoutingTableEntry {
	protected IPAddress destination ;
	protected String portCode;
	
	// default constructor
	public RoutingTableEntry(IPAddress destination, String portCode){
		this.destination = destination;
		this.portCode = portCode;
	}
	
	public void addEntry(IPAddress destination, String portCode) {
            this.destination=destination;
            this.portCode=portCode;
		
	}
	
	public String toString() {
            String tableEntry="";
            tableEntry += "IPAdress :"+ this.destination+ "";
            tableEntry += "Port :"+this.portCode;
		return tableEntry;
	}
	
	public String searchForPort(IPAddress desintation) {
            if(!destination.equals(this.destination)){
                return " ";
            }else{
                return portCode; 
            }	
	}
	
}
