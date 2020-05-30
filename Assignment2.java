import java.util.*;
import java.util.Scanner;
public class Assignment2
{
	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		int sw1;
		String tm;

		while(true)
		{
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("Available commands are:");
			System.out.println("0 :- help");
			System.out.println("1 :- display entries");
			System.out.println("2 :- display selected statistics");
			System.out.println("3 :- lookup a specified team(team)");
			System.out.println("4 :- find teams with same points as a specified team(team)");
			System.out.println("5 :- add a new result (team1 g1 b1 team2 g2 b2)");
			System.out.println("9 :- quit");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			Table t1 = new Table();
			Controller c1 = new Controller();
			System.out.print("Enter Your commands :- ");
			sw1 = myObj.nextInt();

			switch(sw1)
			{
				case 0:
				break;

				case 1:
					t1.getAllEntrie();
				break;

				case 2:
						int sw12 = 0;
						while(sw12 != -1)
						{
							System.out.println("-----------------------------------------------------------------------------------------------------------");
							System.out.println("0 :- Back");
							System.out.println("1 :- Most Points ");
							System.out.println("2 :- Least Points Against ");
							System.out.println("3 :- AveragePoints For ");
							System.out.println("-----------------------------------------------------------------------------------------------------------");
							System.out.print("Enter Your commands :- ");
							sw12 = myObj.nextInt();
							switch(sw12)
							{
								case 0:
									sw12=-1;
								break;

								case 1:
										System.out.println("-----------------------------------------------------------------------------------------------------------");
								 		System.out.println("Most Points For :- "+t1.mostPointsFor());
								 		System.out.println();
								 		System.out.println("-----------------------------------------------------------------------------------------------------------");
								break;

								case 2:
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Least Points Against :- "+t1.leastPointsAgainst());
										System.out.println();
										System.out.println("-----------------------------------------------------------------------------------------------------------");
								break;

								case 3:
										System.out.println("-----------------------------------------------------------------------------------------------------------");
								 		System.out.println("AveragePoints For :- "+t1.averagePointsFor());
								 		System.out.println();
								 		System.out.println();
								 		System.out.println("-----------------------------------------------------------------------------------------------------------");
								break;

								default :
								System.out.println("Please Enter Your Valid Commands ");
							}

						}
				break;	
				case 3:
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						System.out.print("Enter Your Team Name and Details :- ");
						tm = myObj.next();
						t1.lookupTeam(tm);
						// tm = myObj.next();
						// System.out.println(tm);	
						System.out.println("-----------------------------------------------------------------------------------------------------------");
				break;

				case 4:
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						System.out.print("Enter Your Team Name and Details :- ");
						tm = myObj.next();
						System.out.println(tm);	
						t1.findTeamOnSamePoints(tm);
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						
				break;

				case 5:
						c1.commandLoop();
				break;

				case 9:
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						System.out.println("Thanks For Watching My Project ");
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						return;

				default :
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						System.out.println("Please Enter Your Valid Commands ");
						System.out.println("-----------------------------------------------------------------------------------------------------------");
					
				
			}
		}
	}
}