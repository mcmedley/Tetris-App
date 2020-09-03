package hw4;
import api.Cell;
import api.Icon;
import api.Position;

/**
 * This class constructs an "L" Piece, and inherits the methods of AbstractPiece.
 * @author Matt Medley
 */
public class LPiece extends AbstractPiece {
	
	/**
	 * Constructs an LPiece with the given position (of upper-left corner of bounding box) and icon array.
	 * @param position
	 * 	 Position of the upper-left corner of the LPiece's bounding box
	 * @param icon
	 * 	 Icon array containing the icons this LPiece's Cell array will be assigned to.	 
	 */
	public LPiece(Position position, Icon[] icon) {
		super(position, icon, 4);
		cells()[0].setPosition(new Position(0,0));
		cells()[1].setPosition(new Position(0,1));
		cells()[2].setPosition(new Position(1,1));
		cells()[3].setPosition(new Position(2,1));
	}
	
	/**
	 * Flips the LPiece vertically by its center line.
	 */
	@Override
	public void transform() {	
		Cell[] t = super.cells();
		if(t[0].getCol() < t[1].getCol()) {
			t[0].setCol(2);
		}
		else {
			t[0].setCol(0);
		}
		super.setCells(t);
	}

}
