package hw4;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * This class constructs a Diagonal Piece, and inherits the methods of AbstractPiece.
 * @author Matt Medley
 */
public class DiagonalPiece extends AbstractPiece {
	
	/**
	 * Constructs an DiagonalPiece with the given position (of upper-left corner of bounding box) and icon array.
	 * @param position
	 * 	 Position of the upper-left corner of the DiagonalPiece's bounding box
	 * @param icon
	 * 	 Icon array containing the icons this DiagonalPiece's Cell array will be assigned to.	 
	 */
	public DiagonalPiece(Position position, Icon[] icon) {
		super(position, icon, 2);
		cells()[0].setPosition(new Position(0,0));
		cells()[1].setPosition(new Position(1,1));
	}
	
	/**
	 * Flips the DiagonalPiece vertically on its center line.
	 */
	@Override
	public void transform() {
		Cell[] t = super.cells();
		if(t[0].getCol() < t[1].getCol()) {
			t[0].setCol(t[0].getCol() + 1);
			t[1].setCol(t[1].getCol() - 1);
		}
		else {
			t[0].setCol(t[0].getCol() - 1);
			t[1].setCol(t[1].getCol() + 1);
		}
	}

}
