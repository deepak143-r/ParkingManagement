
import java.io.IOException;
import java.io.DataInputStream;
import java.lang.*;

class vehicle{
	parkingManagement mainClass=new parkingManagement();
	userInterface SystemUI=new userInterface();
	DataInputStream userInput=new DataInputStream(System.in);
	int cap=20;
	String vehicleType []=new String[cap]; 
	int licensePlateNo []=new int[cap];
	int currentIndex = 0;
	
	public void getData(){
		try{
			for(int i=0; i<=cap; i++){
				currentIndex=i;
				System.out.print("\nEnter your vehicle type: ");
				vehicleType[i]=userInput.readLine();
				System.out.print("Enter your " +vehicleType[i] +"'s license plate number: ");
				licensePlateNo[i]=Integer.parseInt(userInput.readLine());
				System.out.print("\n");
				System.out.print("Enter another vehicle?(Press '1' for YES or '0' for NO): ");
				int next=Integer.parseInt(userInput.readLine());
				if(next!=1){
					SystemUI.table();
					display();
					break;
				}
			}
		}catch(Exception e){}
	}
	
	public void display(){
		for(int i=0; i<=cap; i++){
			if (vehicleType[i]!=null || licensePlateNo[i] != 0)
			System.out.println("  " +vehicleType[i]+"\t\t\t"+licensePlateNo[i]);
		}
	}
	
}

class userInterface{
		
		static void greet(){
	  	System.out.println("***********************************");
      System.out.println("*    PARKING MANAGEMENT SYSTEM    * \n*            by Deepak            *");
      System.out.println("***********************************");
      System.out.println("*    Press '1' to park vehicle    *");
      System.out.println("*    Press '2' to exit            *");
      System.out.println("***********************************");
      System.out.print("* ENTER YOUR CHOICE: ");
		}
		
		static void table(){
			System.out.println("***********************************");
   		System.out.println("*          PARKED VEHICLES        * \n*=================================*\n* Type                  Number    *");
      System.out.println("***********************************");
		}
}

class parkingManagement{
	public static void main(String[] argv){
		while (true) {
			DataInputStream userChoice=new DataInputStream(System.in);
			userInterface SystemUI=new userInterface();
			vehicle vehicleObject=new vehicle();
			SystemUI.greet();
			int choice;
			try{
				choice=Integer.parseInt(userChoice.readLine());
				switch(choice){
					case 1:
						vehicleObject.getData();
						break;
					case 2:
						System.out.println("\n:)\n");
						System.exit(0);
					default:
						System.out.println("Please enter a valid choice! ");
				}
			}catch(Exception e){}
		}
	}
}

