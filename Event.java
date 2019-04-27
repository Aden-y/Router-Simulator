/*You must complete this class such that it can be used as nodes in a sparse table.
Read the comments to determine what each aspect of the class is supposed to do.
You may add any additional features (methods, references) which may aid you in your
task, BUT you are not allowed to remove or change the names or properties of any of 
the features you where given.

Importing Java's built in data structures will result in a mark of 0.*/

public class Event
{
  //  private String descr;
	public Event(String descr)
	{
	/*You may implement this constructor to suit your needs, or you may add additional constructors.  
            This is the constructor which will be used for marking*/ 
            this.description=descr;
		
	}
        //Mu constructor
        public Event(String time, String day, String description , int duration){
            this.description=description;
            this.slots=(int)Math.ceil(duration/30);
            this.day=day.toLowerCase();
            this.time=time;
    
        }
	
	public void setDescription(String descr)
	{
		/*Implement this method to set the description for this event*/
            this.description=descr;
	}	
	public void setTime(String time){
            this.time=time;
        }
        public String getTime(){
            return this.time;
        }
        public void setDuration(int dr){
            this.slots=(int)Math.ceil(dr/30);
        }
        public int getDuration(){
            return this.slots;
        }
        public String getDay(){
            return this.day;
        }
	public String getDescription()
	{
		/*This method returns the description of this event*/
		return description;
	}		
	public int timeAsInt(){
           String timeString=this.time.replace(":", "");
           return Integer.parseInt(timeString);
        }
        public int getEnd(){
            return this.timeAsInt()+(this.slots*30);
        }
        public int dayIndex(){
            if(this.day=="monday" || this.day=="mon"){
                return 0;
            }else if(this.day=="tuesday" || this.day=="tue"){
                return 1;
            }else if(this.day=="wednesday" || this.day=="wen"){
                return 2;
            }else if(this.day=="thursday" || this.day=="thur"){
                return 3;
            }
            else if(this.day=="friday" || this.day=="fri"){
                return 4;
            }else if(this.day=="saturday" || this.day=="sat"){
                return 5;
            }else{
                return 6;
            }
         
        }
           public int getTimeIndex(){
                return (int) Math.ceil(this.timeAsInt()/50);
            }
	public Event down; //The next event (down) of this event on the same day
	public Event up; //The previous event (up) of this event on the same day.
	public Event right;//The next event (right) of this event at the same time.
	private int slots;
        private String day;
        private String time;
	private String description;//A description for this event.
        public boolean visited=false;
        public Event last=this.down;
        public Event first=this.up;
       
	
}
