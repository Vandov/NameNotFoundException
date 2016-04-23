package projlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
	
	private ActionController ac;

	public void run() throws FileNotFoundException{ //A játékot készíti elő. Létrehozza az ActionControllert.
	
		ac=new ActionController();
		ac.visitables​=new Tile[100][100];
		int column=0;
		int row=0;
		
		Scanner scanner = new Scanner(new File("level1.csv"));
	    scanner.useDelimiter(",");
	    System.out.print(" ");  

	    while(scanner.hasNext()){
	       String temp=scanner.next();
	       if(!temp.equals(""))
	       System.out.print(temp+" ");  
	       
	       if(temp.contains(System.getProperty("line.separator"))){
	    	   row++;
	    	   column=0;
	       }
	       else{
		       switch(temp.charAt(0)){
		       		case 'W':
		       			ac.visitables​[row][column]=new Wall();
		       			column++;
		       			break;
		       		case 'C':
		       			ac.visitables​[row][column]=new CleanTile();
		       			column++;
		       			break;
		       		case 'B':
		       			ac.visitables​[row][column]=new BoxedTile();
		       			column++;
		       			break;
		       		case 'O':
		       			ac.visitables​[row][column]=new CleanTile();
		       			int tempArray[] ={row,column};
		       			ac.players[0]=tempArray;
		       			column++;
		       			break;
		       		case 'J':
		       			ac.visitables​[row][column]=new CleanTile();
		       			int tempArray2[] ={row,column};
		       			ac.players[1]=tempArray2;
		       			column++;
		       			break;
		       		case 'D':
		       			Door tempDoor=new Door();
		       			tempDoor.doorID=Character.getNumericValue(temp.charAt(1));
		       			ac.visitables​[row][column]=tempDoor;
		       			column++;
		       			break;
		       		case 'S':
		       			Scale tempScale=new Scale();
		       			tempScale.scaleID=Character.getNumericValue(temp.charAt(1));
		       			tempScale.setWeightLimit(Character.getNumericValue(temp.charAt(3)));
		       			ac.visitables​[row][column]=tempScale;
		       			column++;
		       			break;
		       }
	       }
	    }
	    scanner.close();
	    
	    System.out.println("\n\n" + ((Scale) ac.visitables​[1][4]).getWeightLimit());

	}
	
	public void play(){	//​Meghívásakor elindul a játék. Innentől kezdve az ActionController feladata a bemenetek kezelése.

	}
}