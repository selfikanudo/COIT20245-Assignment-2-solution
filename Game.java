import java.util.Scanner;
public class Game {
    // member declarations (private) go here
    private String t1;
    private int g1;
    private int b1;
    private String t2;
    private int g2;
    private int b2;
    final int g = 6;
    final int b = 1;
    private int tm1_tot_g;
    private int tm1_tot_b;
    private int tm1_tot;

    private int tm2_tot_g;
    private int tm2_tot_b;
    private int tm2_tot;

    private int points;

    private int margin1 = 0;
    private String winner1 ="";
    private int rating1 = 0;
    
    public Game(String t1,int g1,int b1,String t2,int g2,int b2) {
        // set members here
        this.t1 = t1;
        this.g1 = g1;
        this.b1 = b1;
        this.t2 = t2;
        this.g2 = g2;
        this.b2 = b2;     

        System.out.println(this.t1+"("+this.g1+" goals,"+this.b1+" behinds)  "+this.t2+"("+this.g2+" goals,"+this.b2+" behinds)");
        setMargin();
        setWinner();
        setRating();
    }
    
    private void setMargin() {
    	tm1_tot_g = g1*g;
    	tm1_tot_b = b1*b;
    	tm1_tot = tm1_tot_g + tm1_tot_b;

    	tm2_tot_g = g2*g;
    	tm2_tot_b = b2*b;
    	tm2_tot = tm2_tot_g + tm2_tot_b;

    	points = (tm1_tot_g + tm1_tot_b) - (tm2_tot_g + tm2_tot_b);
    }
    
    private void setWinner() {
    	if (tm1_tot == tm2_tot) 
    	{
    		winner1 = "drawn Match: ";
    	}
    	else if (points<=0)
    	{
    		winner1 = t2+" won by ";
    		margin1 = points*-1;
    		
    	}
    	else
    	{
    		winner1 = t1+" won by ";
    		margin1 = points;
    		
    	}	
    }
   
    private void setRating(){

    	if (points<=6 ||tm1_tot == tm2_tot) {
    		rating1 = 4;
    	}
    	else if (points<=24) {
    		rating1 = 3;
    	}
    	else if (points>24 && tm1_tot>100 && tm2_tot>100) {
    		rating1 = 2;
    	}
    	else
    	{
    		rating1 = 1;
    	}
    }

    // Getters
    public int margin() {
        return margin1;
    }
    
    public String winner() {
        return winner1;
    }
    
    public int rating() {
        return rating1;
    } 
}