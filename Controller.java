import java.util.Scanner;
public class Controller
{
	Table t1 = new Table();
	Controller()
	{
		
	}

	public void commandLoop()
	{
		Scanner myObj = new Scanner(System.in);
		int gg1,bb1,gg2,bb2;
		String tt1,tt2,userName;
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("Enter results for each game in the round on a single line \nFormat is: team1 goals behinds team2 goals behinds \n");
		
		System.out.println("Enter new Game");
    	userName = myObj.nextLine();
			tt1 = userName.split(" ")[0];	
      	gg1 = Integer.parseInt(userName.split(" ")[1]);
      	bb1 = Integer.parseInt(userName.split(" ")[2]);
      	tt2 = userName.split(" ")[3];
      	gg2 = Integer.parseInt(userName.split(" ")[4]);
     	bb2 = Integer.parseInt(userName.split(" ")[5]);

	    t1.processGame(tt1,gg1,bb1,tt2,gg2,bb2);
	    
		System.out.println("-----------------------------------------------------------------------------------------------------------");
	}
}
