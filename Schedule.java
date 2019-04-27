
import java.util.ArrayList;

/*Complete this class to implement a fully functional sparse table.  Read the comments to determine what each aspect of the class is supposed to do.
You must add any additional features (methods, references) which may aid you in your
task BUT you are not allowed to remove or change the names or properties of any of the features you where given.

Importing Java's built in data structures will result in a mark of 0.*/

public class Schedule
{
    //private ArrayList<Event> events=new ArrayList<Event>();
    Event [][]events=new Event [45][7];
    public Event [] dayRoot=dayRoot();
    public Event [] timeRoot=timeRoot();
	public Schedule()
	{
		/*You may implement this constructor to suit your needs, or you may add additional constructors.  
		This is the constructor which will be used for marking*/ 
	}
	
	/*Insertion*/
	public void addEvent(String time,String day, String desc )
	{
            // Event(String time, String day, String description , int duration)
            Event event=new Event(time, day, desc,30);
            //sched1.addEvent("06:00","Mon", "Task1.00");
                /*Insert an event at the given time and day combination. 
		Description should be used to initialise the necessary nodes.
		Duration should be used to determine how many nodes with the same description have to be inserted.
		Default value of 30 corresponds to a single node. 
		Assume only increments of 30 will be used, eg. 30, 60, 90, 120, etc.
		
		Duplicate events (events with the same description) are allowed.*/
 
            int dayIndex=event.dayIndex();
            int timeIndex=event.getTimeIndex();
       //     System.out.println(event.getTime()+"          "+timeIndex);
            if(events[timeIndex][dayIndex]==null){
                if(event.getDuration()==1){
                     events[timeIndex][dayIndex]=event;
                }else{
                    int slotsToAllocate=event.getDuration();
                    int foundSlots=0;
                    boolean yes=false;
                    int baseIndex=-1;
                    while(!yes){
                        for(int i=0;i<45;i++){
                        if(events[i][dayIndex]==null){
                            foundSlots++;
                        }else{
                            foundSlots=0;
                        }
                        if(foundSlots==1){
                            baseIndex=i;
                        }
                        if(foundSlots==slotsToAllocate){
                            yes=true;
                            break;
                        }
                    }
                        if(yes){
                            break;
                        }
                        dayIndex++;
                        if(dayIndex>6){
                            dayIndex=0;
                        }
                    }
                    //Slots Found Now Add Events
                       String newTime;
                    if(baseIndex==0){
                        newTime="6:00";
                    }else{
                        int hour=(int)Math.floor((600+baseIndex*50)/100);
                        int min=(baseIndex%2)*30;
                        if(min==0){
                             newTime=""+hour+":00";
                        }else{
                             newTime=""+hour+":"+min;
                        }
                       
                    }
                    for(int i=0;i<slotsToAllocate;i++){
                        events[baseIndex+i][dayIndex]=new Event(event.getTime(),Schedule.dayWithIndex(dayIndex),event.getDescription(),30);

                    }
                  
         
                }
              
               //Add Pointers
            }else{
                //Time occupied 
                   int slotsToAllocate=event.getDuration();
                    int foundSlots=0;
                    boolean yes=false;
                    int baseIndex=-1;
                    while(!yes){
                        for(int i=0;i<45;i++){
                        if(events[i][dayIndex]==null){
                            foundSlots++;
                        }else{
                            foundSlots=0;
                        }
                        if(foundSlots==1){
                            baseIndex=i;
                        }
                        if(foundSlots==slotsToAllocate){
                            yes=true;
                            break;
                        }
                    }
                        if(yes){
                            break;
                        }
                        dayIndex++;
                        if(dayIndex>6){
                            dayIndex=0;
                        }
                    }
                    //Slots Found Now Add Events
                  //  System.out.println(slotsToAllocate);
                  //  System.out.println(baseIndex);
                    String newTime;
                    if(baseIndex==0){
                        newTime="6:00";
                    }else{
                        int hour=(int)Math.floor((600+baseIndex*50)/100);
                        int min=(baseIndex%2)*30;
                        if(min==0){
                             newTime=""+hour+":00";
                        }else{
                             newTime=""+hour+":"+min;
                        }
                       
                    }
                    for(int i=0;i<slotsToAllocate;i++){
                        events[baseIndex+i][dayIndex]=new Event(newTime,Schedule.dayWithIndex(dayIndex),event.getDescription(),30);

                    }
                
            }
                        setRight();
                        setDown();
                        setUp();
            
	}
	public void addEvent(String time,String day, String desc, int dur )
	{
            // Event(String time, String day, String description , int duration)
            Event event=new Event(time, day, desc,dur);
            //sched1.addEvent("06:00","Mon", "Task1.00");
                /*Insert an event at the given time and day combination. 
		Description should be used to initialise the necessary nodes.
		Duration should be used to determine how many nodes with the same description have to be inserted.
		Default value of 30 corresponds to a single node. 
		Assume only increments of 30 will be used, eg. 30, 60, 90, 120, etc.
		
		Duplicate events (events with the same description) are allowed.*/
 
            int dayIndex=event.dayIndex();
            int timeIndex=event.getTimeIndex();
            
            if(events[timeIndex][dayIndex]==null){
                if(event.getDuration()==1){
                     events[timeIndex][dayIndex]=event;
                }else{
                    int slotsToAllocate=event.getDuration();
                    int foundSlots=0;
                    boolean yes=false;
                    int baseIndex=-1;
                    while(!yes){
                        for(int i=0;i<45;i++){
                        if(events[i][dayIndex]==null){
                            foundSlots++;
                        }else{
                            foundSlots=0;
                        }
                        if(foundSlots==1){
                            baseIndex=i;
                        }
                        if(foundSlots==slotsToAllocate){
                            yes=true;
                            break;
                        }
                    }
                        if(yes){
                            break;
                        }
                        dayIndex++;
                        if(dayIndex>6){
                            dayIndex=0;
                        }
                    }
                    //Slots Found Now Add Events
                       String newTime;
                    if(baseIndex==0){
                        newTime="6:00";
                    }else{
                        int hour=(int)Math.floor((600+baseIndex*50)/100);
                        int min=(baseIndex%2)*30;
                        if(min==0){
                             newTime=""+hour+":00";
                        }else{
                             newTime=""+hour+":"+min;
                        }
                       
                    }
                    for(int i=0;i<slotsToAllocate;i++){
                        events[baseIndex+i][dayIndex]=new Event(event.getTime(),Schedule.dayWithIndex(dayIndex),event.getDescription(),30);

                    }
                  
         
                }
              
               //Add Pointers
            }else{
                //Time occupied 
                int cycle=0;
                   int slotsToAllocate=event.getDuration();
                    int foundSlots=0;
                    boolean yes=false;
                    int baseIndex=-1;
                    while(!yes){
                        for(int i=0;i<45;i++){
                        if(events[i][dayIndex]==null){
                            foundSlots++;
                        }else{
                            foundSlots=0;
                        }
                        if(foundSlots==1){
                            baseIndex=i;
                        }
                        if(foundSlots==slotsToAllocate){
                          //  System.out.println("Slots To allocate: "+slotsToAllocate+"    Slots Found"+foundSlots +"  From "+baseIndex);
                          if(baseIndex+slotsToAllocate>=45){
                              foundSlots=0;
                                 yes=false;
                              break;
                           
                          }else{
                              yes=true;
                            break;
                          }
                        }
                    }
                        if(yes){
                            break;
                        }
                        dayIndex++;
                        if(dayIndex>6){
                            dayIndex=0;
                            cycle++;
                        }
                        if(cycle>=2){
                          //  System.out.println("buuhuhu");
                            break;
                        }
                        
                    }
                    //Slots Found Now Add Events
                  //  System.out.println(slotsToAllocate);
                  //  System.out.println(baseIndex);
                    String newTime;
                    if(baseIndex==0){
                        newTime="6:00";
                    }else{
                        int hour=(int)Math.floor((600+baseIndex*50)/100);
                        int min=(baseIndex%2)*30;
                        if(min==0){
                             newTime=""+hour+":00";
                        }else{
                             newTime=""+hour+":"+min;
                        }
                       
                    }
                     // System.out.println("Slots To allocate: "+slotsToAllocate+"    Slots Found"+foundSlots +"  From "+baseIndex);
                    for(int i=0;i<slotsToAllocate;i++){
                       try{
                            events[baseIndex+i][dayIndex]=new Event(newTime,Schedule.dayWithIndex(dayIndex),event.getDescription(),30);
                       }catch (Exception e){
                           
                       }

                    }
                
            }
                        setRight();
                        setDown();
                        setUp();
            
	}
	/*Deletion methods*/
	public String deleteEvent(String time, String day)
	{
		/*Delete the event at the given time and day combination and return the description of the 
		deleted event. Note: all adjacent (up and down) events with the same description must also be deleted.
		
		If no such event exists, return null.*/
            String desc=null;
                for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                         if(events[i][j].getTime().equals(time) && events[i][j].getDay().toLowerCase().equals(day.toLowerCase())){
                         desc=events[i][j].getDescription().toLowerCase();
                        for(int k=0;k<45;k++){
                            if(events[k][j]!=null){
                                      if(events[k][j].getDescription().toLowerCase().equals(desc)){
                           events[k][j]=null; 
                        }
                            }
                  
                        }
                        events[i][j]=null;
                        
                    }
                    }

                }
            }
                        setRight();
                        setDown();
                        setUp();
				
		return desc;
	}
	
	public void deleteEvent(String description)
	{
		/*Delete all events that match the given description.*/
            for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                    if(events[i][j].getDescription().toLowerCase().equals(description.toLowerCase())){
                        events[i][j]=null;
                    } 
                    }

                }
            }
                        setRight();
                        setDown();
                        setUp();
				
	}
	
	/*Clearing Methods*/
	public void clearByDay(String day)
	{
		/*All events for the given day should be deleted.
		If the day has no events, simply do nothing.*/
                 for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                     if(events[i][j].getDay().toLowerCase().equals(day.toLowerCase())){
                        events[i][j]=null;
                    }  
                    }

                }
            }
                        setRight();
                        setDown();
                        setUp();
            
	}
	
	public void clearByTime(String time)
	{
	/*All evnts for the given time should be deleted.
	If the time has no events, simply do nothing.*/
                for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                  if(events[i][j].getTime().equals(time)){
                        events[i][j]=null;
                    }      
                    }

                }
            }
                        setRight();
                        setDown();
                        setUp();
	}
	
	public void clearAll()
	{
		/*Delete all events from the schedule.*/
            
                 for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                  
                        events[i][j]=null;
                    
                }
            }

	}
	
	
	/*Query methods*/
	public Event getEvent(String time, String day)
	{
		/*Return the first event for the given time and day combination.  
		If no such event exists, return null*/
            Event toReturn = null;
            boolean found=false;
                for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                     if(events[i][j].getDay().toLowerCase().equals(day.toLowerCase()) && events[i][j].getTime().equals(time) ){
                       toReturn=events[i][j];
                       found=true;
                       break;
                    } 
                    }

                }
                if(found)
                    break;
            }

		return toReturn;
	}

	public Event findEvent(String description)
	{
		/*Return the first event that matches the given description.  
		If no such event exists, return null*/
             Event toReturn = null;
            boolean found=false;
                for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                     if(events[i][j].getDescription().toLowerCase().equals(description.toLowerCase()) ){
                       toReturn=events[i][j];
                       found=true;
                       break;
                    }
                    }
                }
                if(found)
                    break;
            }

		return toReturn;
		
	
	}
	
	public Event getTimeEvent(String time)
	{
		/*Return the head event for the time passed as a parameter.
		If no such event exists, return null*/
              Event toReturn = null;
            boolean found=false;
                for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                   if(events[i][j].getTime()==time ){
                       toReturn=events[i][j];
                       found=true;
                       break;
                    }
                    }
 
                }
                if(found)
                    break;
            }

		return toReturn;
		//return null;
	}
	
	public Event getDayEvent(String day)
	{
		/*Return the head event for the day passed as a parameter.
		If no such event exists, return null*/
                        Event toReturn = null;
            boolean found=false;
                for(int i=0;i<45;i++){
                for(int j=0;j<7;j++){
                    if(events[i][j]!=null){
                       if(events[i][j].getDay().toLowerCase().equals(day.toLowerCase())){
                       toReturn=events[i][j];
                       found=true;
                       break;
                    }  
                    }

                }
                if(found)
                    break;
            }

		return toReturn;
		
	}
	private  void setRight(){
            for(int i=0;i<45;i++){
                Event head = null;
                Event p = null;
                for(int j=0;j<7;j++){
                    if(events[i][j] !=null && head == null){
                        head = events[i][j];
                        p = head;
                    }else{
                    if(events[i][j] !=null && head!=null){
                        p.right = events[i][j];
                        p = events[i][j];
                    }
                    }
                }
              if(p!=null && head!=null){
                    p.right=head;
              }
            }
        }
        private  void setUp(){
               for(int i=7;i<0;i--){
                Event head = null;
                Event p = null;
                for(int j=0;j<45;j++){
                    if(events[j][i] !=null && head == null){
                        head = events[i][j];
                        p = head;
                    }else{
                    if(events[i][j] !=null){
                        p.up = events[i][j];
                        p = events[i][j];
                    }
                    
                    }
              if(p!=null && head!=null){
                    p.up=head;
              }
                }
            }
            
        }
        private  void setDown(){
                for(int i=0;i<7;i++){
                Event head = null;
                Event p = null;
                for(int j=0;j<45;j++){
                    if(events[j][i] !=null && head == null){
                        head = events[j][i];
                        p = head;
                    }else{
                    if(events[j][i] !=null && head!=null){
                        p.down = events[j][i];
                        p = events[j][i];
                    }
                    
                    }
              if(p!=null && head!=null){
                    p.down=head;
              }                }
            }
            
        }
    
        public  String toString(){
                 for(int i=0;i<7;i++){
                for(int j=0;j<45;j++){
                    if(events[j][i]!=null){
                        System.out.println(events[j][i].getDay()+"   "+events[j][i].getDescription()+" at "+events[j][i].getTime());  
                    }
                  
                }
         
            }
             
            return null;
        }
        private static String dayWithIndex(int index){
            switch(index){
                case 0:
                    return "Monday";
                case 1:
                    return "Tuesday";
                case 2:
                    return "Wednesday";
                case 3:
                   return "Thursday";
                case 4:
                     return "Friday";
                case 5:
                     return "Saturday";
                default:
                    return "Sunday";
            }
        }
public int dayDet(String day){
                switch(day.toLowerCase()){
                case "monday":
                case"mon":
                    return 0;
                case "tuesday":
                case "tue":
                    return 1;
                case "wednesday":
                case "wed":
                    
                    return 2;
                case "thursday":
                case "thur":
                    
                   return 3;
                case "friday":
                case "fri":
                     return 4;
                case "saturday":
                case "sat":
                     return 5;
                default:
                    return 6;
            }
}

public Event [] dayRoot(){
    Event[] es=new Event[7];
    for(int i=0;i<7;i++){
        for(int j=0;j<45;j++){
            Event root=null;
            if(events[j][i]!=null){
                root=events[j][i];
                break;
            }
            es[i]=root;
        }
    }
    return es;
}
public Event [] timeRoot(){
    Event[] es=new Event[45];
    for(int i=0;i<45;i++){
        for(int j=0;j<7;j++){
            Event root=null;
            if(events[i][j]!=null){
                root=events[j][i];
                break;
            }
            es[i]=root;
        }
    }
    return es;
}
//timeRoot
public void clearVisited(Event e){
    try{
        e.visited=false;
    }catch(Exception ex){
        
    }
}
//timeDet
           public int timeDet(String time){
                return (int) Math.ceil(timeAsInt(time)/50);
            }
           	public int timeAsInt(String time){
           String timeString=time.replace(":", "");
           return Integer.parseInt(timeString);
        }
}
