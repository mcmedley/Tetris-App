package hw4;

import api.AbstractGame;
import api.Cell;
import api.Icon;
import api.Piece;
import api.Position;


/**
 * This class is an implementation of the interface Piece, including functions such as transform and cycle.
 * @author Matt Medley
 */
public abstract class AbstractPiece implements Piece {
	private Cell[] cells;
	private Icon[] icons;
	private Position position;
	
	/**
	 * Constructs an AbstractPiece at the given position.
	 * @param givenPosition
	 * 	 Given position for the upper-left corner of the piece's bounding box
	 * @param givenIcons
	 * 	 Given Icon array that will be assigned to each corresponding cell
	 * @param numCells
	 * 	 Number of cells that the piece contains 
	 */
	protected AbstractPiece(Position givenPosition, Icon[] givenIcons, int numCells) {
		position = givenPosition;
		cells = new Cell[numCells];
		icons = givenIcons;
		for(int i = 0; i < numCells; i++) {
			cells[i] = new Cell(givenIcons[i], new Position(0,0));
		}
	}
	
	/**
	 * Sets the cells in this piece, making a deep copy of the given array.
	 * @param givenCells
	 * 	 Cell array containing the cells to be set
	 */
	public void setCells(Cell[] givenCells) {
	    cells = new Cell[givenCells.length];
	    for(int i = 0; i < givenCells.length; i++) {
	    	cells[i] = new Cell(givenCells[i]);
	    }
	}
	
	/**
	 * Returns a deep copy of the Cell objects in this piece.
	 * @return
	 * 	 A deep copy of the piece's Cell objects
	 */
	public Cell[] getCells() {
	    Cell[] copy = new Cell[cells.length];
	    for(int i = 0; i < cells.length; i++) {
	    	copy[i] = new Cell(cells[i]);
	    }
	    return copy;
	}
	
	/**
	 * Returns a new array of Cell objects representing the icons in this piece with their absolute positions.
	 * @return
	 * 	 A Cell array containing the absolute positions of the Cell objects 
	 */
	public Cell[] getCellsAbsolute() {
	    Cell[] ret = new Cell[cells().length];
	    for(int i = 0; i < cells().length; i++) {
	    	int row = cells[i].getRow() + position.row();
		    int col = cells[i].getCol() + position.col();
		    Icon b = cells[i].getIcon();
		    ret[i] = new Cell(b, new Position(row, col));	
	    }
	    return ret;
	}
	
	
	public void shiftDown() {
	    position = new Position(position.row() + 1, position.col());
	}
	
	/**
	 * Shifts the position of this piece left(decreasing the column) by one.
	 */
	public void shiftLeft() {
	    position = new Position(position.row(), position.col() - 1);
	}
	
	/**
	 * Shifts the position of this piece right(increasing the column) by one.
	 */
	public void shiftRight() {
	    position = new Position(position.row(), position.col() + 1);
	}
	
	/**
	 * Returns the position of this piece(upper-left corner of its bounding box)
	 * @return
	 * 	 Position of this piece's upper-left bounding box
	 */
	public Position getPosition() {
	    return position;
	}
	
	/**
	 * Transforms each piece differently.
	 */
	public abstract void transform();
	
	/**
	 * Cycles the icons within the cells of this piece.
	 */
	public void cycle() {
		Icon tempIcon = cells[0].getIcon();
		for(int i = 0; i < cells.length-1; i++) {
			cells[i].setIcon(cells[i+1].getIcon());
		}
		cells[cells.length-1].setIcon(tempIcon);
	}
	
	/**
	 * Returns a deep copy of this object having the correct runtime type.
	 */
	@Override
	public Piece clone() {
		try {
			AbstractPiece s = (AbstractPiece) super.clone();
			
	        s.cells = new Cell[cells.length];
	        for (int i = 0; i < cells.length; ++i) {
	          s.cells[i] = new Cell(cells[i]);
	        }
	        return s;
	   }
	   catch (CloneNotSupportedException e) {
	     return null;
	   }    
	}
	/**
	 * Returns the cells in this piece.
	 * @return
	 * 	 Cell array containing the piece's cells.
	 */
	protected Cell[] cells() {
		return cells;
	}
	
	
	
	

}
