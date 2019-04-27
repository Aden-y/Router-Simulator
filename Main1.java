public class Main1{
    public static void main(String [] args){
        System.out.println("Testing Insertion*******************");
        		Schedule sched1=new Schedule();
		
		sched1.addEvent("06:00","Monday", "Task1.00");
		sched1.addEvent("08:00","Monday", "Task2.00");
		sched1.addEvent("08:00","Wednesday", "Task3.00");
		sched1.addEvent("08:00","Monday", "Task4.00");
		sched1.addEvent("22:00","Monday", "Task5.00");
		sched1.addEvent("22:00","Monday", "Task6.00");
		sched1.addEvent("22:00","Sunday", "Task7.00");
		sched1.addEvent("22:00","Sunday", "Task8.00");
		sched1.addEvent("06:30","Thurday", "LongTask1",120);
		sched1.addEvent("07:30","Thurday", "LongTask2",60);
		sched1.addEvent("22:00","Monday", "LongTask3",60);
		sched1.addEvent("16:00","Friday", "LongTask4",60);
		sched1.addEvent("18:00","Friday", "LongTask5",30);
		sched1.addEvent("18:00","Friday", "LongTask6",90);
		sched1.addEvent("18:00","Friday", "LongTask7",60);
		sched1.addEvent("22:00","Friday", "LongTask8",60);
		sched1.addEvent("18:00","Friday", "LongTask9",60);
		sched1.addEvent("18:00","Friday", "LongTask10",60);
		sched1.addEvent("18:00","Friday", "LongTask11",90);
		sched1.addEvent("18:00","Friday", "LongTask12",30);
		sched1.addEvent("18:00","Saturday", "LongTask13",60);
		sched1.addEvent("18:00","Saturday", "LongTask4",60);
		sched1.addEvent("18:00","Saturday", "LongTask15",60);
		sched1.addEvent("18:00","Saturday", "LongTask16",60);
		sched1.addEvent("18:00","Friday", "LongTask17",60);
		sched1.addEvent("18:00","Saturday", "Task18");
		sched1.addEvent("18:00","Saturday", "Task19");
		sched1.addEvent("18:00","Saturday", "Task20");
		sched1.addEvent("06:00","Monday", "Task21");
		sched1.addEvent("22:00","Monday", "Task22");
		sched1.addEvent("06:00","Saturday", "LongTask4");
		sched1.addEvent("22:00","Saturday", "Task24");
		sched1.addEvent("22:00","Saturday", "LongTask25",90);
		sched1.addEvent("21:00","Friday", "Task26");
		sched1.addEvent("21:00","Friday", "LongTask27",60);
		sched1.addEvent("22:00","Friday", "LongTask28",30);
		sched1.addEvent("22:00","Friday", "Task29");
                System.out.println("After Insertion, Table contains:");
                System.out.println(sched1.toString());
                
                System.out.println("******************Testing find by time 18:00****************");
                System.out.println("First Event found 18:00 is:"+sched1.getTimeEvent("18:00").getDescription());
                
                System.out.println("************************Testing find Event by day and time Monday 22:00***********");
                System.out.println("Event found for Monday 22:00 is :"+sched1.getEvent("22:00", "Monday"));
                System.out.println("*****************************Testing get Event by description*************");
                System.out.println("The Event matching description (LongTask25) is on"+sched1.findEvent("LongTask25").getDay());
                
                
                
                System.out.println("*****************Testing serch by day (Monday) **************");
                System.out.println("Event found:"+sched1.getDayEvent("Monday").getDescription());
                System.out.println("**************************Testing deletion by day (Monday)*********************");
                sched1.clearByDay("monday");
                System.out.println("After deleting events on monday, new events in table are:");
                System.out.println(sched1.toString());
                

                System.out.println("Testing Clearing");
                sched1.clearAll();
                
    }
}