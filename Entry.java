import java.util.*;
public class Entry
{
	private int position,played=3,points,won,lost,drawn,pointsFor,pointsAgainst;
	private String team;
	private double percentage;

	Entry(String team,int point,int won,int lost,int drawn,int pointsFor,int pointsAgainst)
	{
		setTeam(team);
		setPoints(point);
		setWon(won);
		setLost(lost);
		setDrawn(drawn);
		setPointsFor(pointsFor);
		setPointsAgainst(pointsAgainst);
		setPercentage();
	}
	Entry()
	{

	}

	public String toString()
	{
		
	  return getTeam()+"            "+getPlayed()+"           "+getPoints()+"          "+getPercentage()+"       "+getWon()+"       "+getLost()+"         "+getDrawn()+"         "+getPointsFor()+"        "+getPointsAgainst();  
		// rerturn String.format("%-5s%-15d%7d%5d%5d%5d%5d%5d%5d%5d",getTeam(),getWon(),getLost(),getDrawn(),getPointsFor(),getPointsAgainst(),getPercentage());
	}  

	public int getPosition() 
	{
    	return position;
  	}

  	public void setPosition(int position) 
  	{
    	this.position = position;
    }

    public int getPlayed() 
	{
    	return played;
  	}

  	public void setPlayed(int played) 
  	{
    	this.played = played;
    }

    public int getPoints() 
	{
    	return points;
  	}

  	public void setPoints(int points) 
  	{
  		this.points = points;
    }

    public int getWon() 
	{
    	return won;
  	}

  	public void setWon(int won) 
  	{
    	this.won = won;
    }

    public int getLost() 
	{
    	return lost;
  	}

  	public void setLost(int lost) 
  	{
    	this.lost = lost;
    }

    public int getDrawn() 
	{
    	return drawn;
  	}

  	public void setDrawn(int drawn) 
  	{
    	this.drawn = drawn;
    }
    public int getPointsFor() 
	{
    	return pointsFor;
  	}

  	public void setPointsFor(int pointsFor) 
  	{
    	this.pointsFor = pointsFor;
    }

    public int getPointsAgainst() 
	{
    	return pointsAgainst;
  	}

  	public void setPointsAgainst(int pointsAgainst) 
  	{
    	this.pointsAgainst = pointsAgainst;
    }

	public String getTeam() 
	{
    	return team;
  	}

  	public void setTeam(String team) 
  	{
    	this.team = team;
    	// System.out.println(team);
    }

    public double getPercentage() 
	{
    	return new Double(String.format("%.2f", percentage));
  	}

  	public void setPercentage() 
  	{
        this.percentage = (double)getPointsFor() / (getPointsFor() + getPointsAgainst()) * 100;
    }

	public void processResult(int for1, int against)
	{

	}
}
