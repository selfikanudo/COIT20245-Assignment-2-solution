import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

class Table
{
		String teams[] = {"t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8"};
		int points[] = {6, 6, 4, 2, 2, 2, 2, 0};
		int wins[] = {3, 3, 2, 1, 1, 1, 1, 0};
		int losses[] = {0, 0, 1, 2, 2, 2, 2, 3};
		int drawn[] = {0, 0, 0, 0, 0, 0, 0, 0};
		int pointsFor[] = {149, 127, 105, 90, 85, 60, 50, 81};
		int pointsAgainst[] = {50, 59, 65, 104, 118, 107, 150, 94};

		ArrayList<Entry> e1 = new ArrayList();
		Iterator i;
		Entry e;

		Table()
		{
			for (int i = 0;i<8;i++) 
			{		
				e1.add(new Entry(teams[i],points[i],wins[i],losses[i],drawn[i],pointsFor[i],pointsAgainst[i]));
			}
		}

		public void getAllEntrie()	
		{
			
			// Collections.sort(e1,new Comparator<Entry>(){
			// 		public int compare(Entry ea1, Entry ea2){
			// 			return ea2.getPoints() - ea1.getPoints();
			// 		}
			// });


			Comparator<Entry> sort1 = Comparator.comparing(Entry::getPoints).thenComparing(Entry::getPercentage);
			e1.stream().sorted(sort1).collect(Collectors.toList());



			//all data
			i = e1.iterator();
				if(i.hasNext()){
					System.out.println("-----------------------------------------------------------------------------------------------------------");	
					System.out.printf("%-5s%-15s%7s%10s%10s%10s%10s%10s%10s%10s\n","Pos","Team","Played","Points","%","Won","Lost","Drawn","PF","PA");	
					System.out.println("-----------------------------------------------------------------------------------------------------------");
					int pos=0;
					
					while(i.hasNext()){
						//System.out.println(i.next());
						pos+=1;
						e = (Entry)i.next();
						//if(e.empno>1000)
						System.out.println(pos+"     "+e);
					}
					System.out.println("-----------------------------------------------------------------------------------------------------------");
				}
				else
					System.out.println("Data Not Available");
		}

		public void lookupTeam(String t)
		{
			System.out.println(t);
			i = e1.iterator();
			if(i.hasNext()){
				System.out.println("-----------------------------------------------------------------------------------------------------------");	
				System.out.printf("%-5s%-15s%7s%10s%10s%10s%10s%10s%10s%10s\n","Pos","Team","Played","Points","%","Won","Lost","Drawn","PF","PA");	
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				// int pos=0;

				
				while(i.hasNext()){
					//System.out.println(i.next());
					// pos+=1;
					e = (Entry)i.next();
					if(e.getTeam().equals(t))
					{
						System.out.println("1     "+e);
					}
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------");
			}
			else
			{
				System.out.println("data  Not Found");
			}
		}

		public void findTeamOnSamePoints(String t)
		{
			int pnt = 0;
			i = e1.iterator();
			if(i.hasNext()){
				while(i.hasNext()){
					e = (Entry)i.next();
					if(e.getTeam().equals(t))
					{
						pnt = e.getPoints();
					}
				}
			}
			else
					System.out.println("Data Not Available");

			i = e1.iterator();
			if(i.hasNext()){
				System.out.println("-----------------------------------------------------------------------------------------------------------");	
				System.out.printf("%-5s%-15s%7s%10s%10s%10s%10s%10s%10s%10s\n","Pos","Team","Played","Points","%","Won","Lost","Drawn","PF","PA");	
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				int pos=0;
				while(i.hasNext()){
					e = (Entry)i.next();
					if(e.getPoints() == pnt)
					{	
						pos+=1;
						System.out.println(pos+"     "+e);
					}
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------");
			}
			else
					System.out.println("Data Not Available");
		}

		public int mostPointsFor()
		{
			Collections.sort(e1,new Comparator<Entry>()
			{
					public int compare(Entry ea1, Entry ea2){
						return ea1.getPointsFor() - ea2.getPointsFor();
					}
			});

			// Display

			i = e1.iterator();
			if(i.hasNext()){
				while(i.hasNext()){
					e = (Entry)i.next();
				}
				return e.getPointsFor();
			}
			else
				return 1111;

		}  
		public int leastPointsAgainst()
		{
				Collections.sort(e1,new Comparator<Entry>()
				{
						public int compare(Entry ea1, Entry ea2){
							return ea2.getPointsAgainst() - ea1.getPointsAgainst();
						}
				});
		
				i = e1.iterator();
				if(i.hasNext()){
					while(i.hasNext()){
						e = (Entry)i.next();
					}
					return e.getPointsAgainst();
				}
				else
				return 1111;
		}

		public int averagePointsFor()
		{
			int tot = 0;
			int ct = 0;
			i = e1.iterator();
				if(i.hasNext()){
					while(i.hasNext()){
						e = (Entry)i.next();
						tot += e.getPointsFor();
						ct +=1;
					}
						return tot/ct;
				}
				else
				return 1111;
		}
		public void processGame(String t1,int g1,int b1,String t2,int g2,int b2)
		{
			
			int pnt1 = 0,pnt2 = 0;
			String win1 = "a";
			Game g = new Game(t1,g1,b1,t2,g2,b2);
			// System.out.println("margin :- "+g.margin());
			// System.out.println("Winner :- "+g.winner().split(" ")[0]);
			// System.out.println("rating :- "+g.rating());

			win1 = g.winner().split(" ")[0];
			// pnt1 = g1*6+b1ut.println(pnt1);
			// System.out.println(pnt2);
			// System.o;
			// pnt2 = g2*6+b2;
			// System.out.println(win1);

			if(win1.equals("drawn"))
			{
				// System.out.println("drawn my tea");

				i = e1.iterator();
				if(i.hasNext()){
					while(i.hasNext()){
						e = (Entry)i.next();
						if(e.getTeam().equals(t1))
						{
							// System.out.println(e.getPlayed());
							e.setPlayed(e.getPlayed()+1);
							e.setDrawn(e.getDrawn()+1);
							e.setPointsFor(e.getPointsFor()+g.margin());
							e.setPointsAgainst(e.getPointsAgainst()+g.rating());	
							e.setPoints(e.getPoints()+1);
							e.setPercentage();
							// System.out.println(e.getPoints());
						}
					}
				}
				else

						System.out.println("Data Not Available");
				

				i = e1.iterator();
				if(i.hasNext()){
					while(i.hasNext()){
						e = (Entry)i.next();
						if(e.getTeam().equals(t2))
						{	
							e.setPlayed(e.getPlayed()+1);
							e.setDrawn(e.getDrawn()+1);
							e.setPointsFor(e.getPointsFor()+g.margin());
							e.setPointsAgainst(e.getPointsAgainst()+g.rating());	
							e.setPoints(e.getPoints()+1);
							e.setPercentage();
						}
					}
				}
				else
						System.out.println("Data Not Available");
				
			}
			else
			{
				i = e1.iterator();
				if(i.hasNext()){
					while(i.hasNext()){
						e = (Entry)i.next();
						if(e.getTeam().equals(t1))
						{
							e.setPlayed(e.getPlayed()+1);
							
							// e.setPlayed()+=1;
							// e.setPoints()+=pnt1;
							if(e.getTeam().equals(win1))
							{
								e.setWon(e.getWon()+1);
								e.setPointsFor(e.getPointsFor()+g.margin());
								e.setPointsAgainst(e.getPointsAgainst()+g.rating());	
								e.setPoints(e.getPoints()+2);
								e.setPercentage();
							}else if(e.getTeam().equals("drawn"))
							{
								
							}
							else{
								e.setLost(e.getLost()+1);
								e.setPercentage();
							}
							// e.setPoints()+=pnt1;
							// System.out.println(e.getPoints());
						}
					}
				}
				else

						System.out.println("Data Not Available");
				

				i = e1.iterator();
				if(i.hasNext()){
					while(i.hasNext()){
						e = (Entry)i.next();
						if(e.getTeam().equals(t2))
						{	
							e.setPlayed(e.getPlayed()+1);
							if(e.getTeam().equals(win1))
							{
								e.setWon(e.getWon()+1);
								e.setPointsFor(e.getPointsFor()+g.margin());
								e.setPointsAgainst(e.getPointsAgainst()+g.rating());	
								e.setPoints(e.getPoints()+2);
								e.setPercentage();
							}
							else
							{
								e.setLost(e.getLost()+1);
								e.setPercentage();
							}
							// e.setPoints()+=pnt1;
							// System.out.println(e.getPoints());
						}
					}
				}
				else
						System.out.println("Data Not Available");

				//played +1
				//wins 
				//loss 
				//drawn +1 
				//score for +margin
				//score Aga 
				//point 
				//pers 
				

			}
			getAllEntrie();
		}
}