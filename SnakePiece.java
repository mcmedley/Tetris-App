package hw4;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * This class constructs a Snake-shaped Piece, and inherits the methods of AbstractPiece.
 * @author Matt Medley
 */
public class SnakePiece extends AbstractPiece {
	
	/**
	 * Positions of the bounding box to be used when this SnakePiece transforms.
	 */
	private static final Position[] sequence =
		 {
		 new Position(0, 0),
		 new Position(0, 1),
		 new Position(0, 2),
		 new Position(1, 2),
		 new Position(1, 1),
		 new Position(1, 0),
		 new Position(2, 0),
		 new Position(2, 1),
		 new Position(2, 2),
		 new Position(1, 2),
		 new Position(1, 1),
		 new Position(1, 0),
		 };
	
	/**
	 * A counter, which will be used to help this SnakePiece transform.
	 */
	private int c;
	
	/**
	 * Constructs an SnakePiece with the given position (of upper-left corner of bounding box) and icon array.
	 * @param position
	 * 	 Position of the upper-left corner of the SnakePiece's bounding box
	 * @param icon
	 * 	 Icon array containing the icons this SnakePiece's Cell array will be assigned to.	 
	 */
	public SnakePiece(Position position, Icon[] icon) {
		super(position, icon, 4);
		cells()[0].setPosition(new Position(0,0));
		cells()[1].setPosition(new Position(1,0));
		cells()[2].setPosition(new Position(1,1));
		cells()[3].setPosition(new Position(1,2));
	}
	
	/**
	 * Performs a rotation through the sequence shown above.
	 */
	@Override
	public void transform() {
		c++;
		cells()[3].setPosition(new Position(cells()[2].getRow(), getCells()[2].getCol()));
		cells()[2].setPosition(new Position(cells()[1].getRow(), getCells()[1].getCol()));
		cells()[1].setPosition(new Position(cells()[0].getRow(), getCells()[0].getCol()));
		cells()[0].setPosition(sequence[c % sequence.length]);
		
	}

}
