package projlab;

public class PortalBeam implements Visitor {
	
	private String color; 	//​A lövedék színét tárolja.
	private Tile tile;	 //​A lövedék helyét tárolja.
	private int direction; 	 //​A lövedék irányát tárolja.
	
	@Override
	public void visit(Visitable visitable) {
		// TODO Auto-generated method stub
		
	}
	
	public void changeColor(String color){	//Beállítja a lövedék színét.
	}
	
	public String getColor(){	 //Visszaadja a lövedék színét.
		return color;
	}
	
	public void setDirection(int newDirection){ //Beállítja a lövedék irányát. 
		/*Ez a kilövéskor beállítódik.
		 *  Az irány a játékosnak a kilövés pillanatában meglévő irányával lesz azonos.*/
	}

	public int getDirection(){ //Visszaadja a lövedék irányát.
		return direction;	
	}
	
	public Visitable getVisitable(){	//Visszaadja következő mezőt.
		return tile.getVisitable(direction);	
	}

	public void setVisitable(Visitable newVisitable){	//Beállítja a következő mezőt.
	}

}
