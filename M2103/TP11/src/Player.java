package battle;

import java.util.ArrayList;
import view.GridTableFrame;

public abstract class Player
{
	protected String name;
	protected int width;
	protected int height;

	protected ArrayList<Ship> fleet;
	protected Square myGrid[][];
	protected Square opponentGrid[][];

	/**
	* Constructor of Player
	* @param fleet fleet the array list of sheeps
	* @param name the player name
	* @param width the width
	* @param height the height
	*/
	public Player(ArrayList<Ship> fleet, String name, int width, int height)
	{
		this.name = name;
		this.width = width;
		this.height = height;
		createCopy(fleet);
		initializeMyGrid();
		initializeOpponentGrid();
	}

	/**
	* Make a deep copy of the array of ships in parameter
	* @param fleet the original array of ships
	*/
	protected void createCopy(ArrayList<Ship> fleet)
	{
		this.fleet = new ArrayList<Ship>();
		for(Ship s : fleet)
		{
			this.fleet.add(s);
		}
	}

	/**
	* Initialize the human player grid
	*/
	protected void initializeMyGrid()
	{
		this.myGrid = new Square[width][height];
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				this.myGrid[i][j] = new Square(i,j);
			}
		}
	}

	/**
	* Initialize the ia player grid
	*/
	protected void initializeOpponentGrid()
	{
		this.opponentGrid = new Square[width][height];
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				this.opponentGrid[i][j] = new Square(i,j);
			}
		}
	}

	/**
	* Do a new shot
	* @return return pos of the new shot (x and y)
	*/
	public abstract int[] newShot();

	/**
	* Place ship in the grid
	*/
	public abstract void shipPlacement();

	/**
	* @return return the name of the player
	*/
	public String getName()
	{
		return this.name;
	}

	/**
	* @return return the width attribute
	*/
	public int getWidth()
	{
		return this.width;
	}

	/**
	* @return return the height attribute
	*/
	public int getHeight()
	{
		return this.height;
	}

	public void showMyGrid()
	{
		System.out.print("\n");
		for(int i = 0; i < this.height; i++)
		{
			for(int j = 0; j < this.width; j++)
			{
				if(myGrid[j][i].isHit())
					System.out.print(" X ");
				else if(myGrid[j][i].isFree())
					System.out.print(" o ");
				else
					System.out.print(" S ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public void showOpponentGrid()
	{
		System.out.print("\n");
		for(int i = 0; i < this.height; i++)
		{
			for(int j = 0; j < this.width; j++)
			{
				if(opponentGrid[j][i].isHit())
					System.out.print(" X ");
				else if(opponentGrid[j][i].isFree())
					System.out.print(" o ");
				else
					System.out.print(" S ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public void displayMygrid()
	{
		GridTableFrame otframe = new GridTableFrame(myGrid);
		otframe.showIt();
	}

	public void displayOpponentGrid()
	{
		GridTableFrame otframe = new GridTableFrame(opponentGrid);
		otframe.showIt();
	}

}