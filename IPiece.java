package hw4;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * This class constructs an "I" Piece, and inherits the methods of AbstractPiece.
 * @author Matt Medley
 */
public class IPiece extends AbstractPiece {
	
	/**
	 * Constructs an IPiece with the given position (of upper-left corner of bounding box) and icon array.
	 * @param position
	 * 	 Position of the upper-left corner of the IPiece's bounding box
	 * @param icon
	 * 	 Icon array containing the icons this IPiece's Cell array will be assigned to.	 
	 */
	public IPiece(Position position, Icon[] icon) {
		super(position, icon, 3);
		cells()[0].setPosition(new Position(0,1));
		cells()[1].setPosition(new Position(1,1));
		cells()[2].setPosition(new Position(2,1));
	}
	/**
	 * Does not affect the IPiece.
	 */
	@Override
	public void transform() {
		
	}

}
