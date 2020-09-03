package hw4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import api.AbstractGame;
import api.Generator;
import api.Icon;
import api.Position;
import java.awt.Color;


/**
 * This class simulates a tetris-style game where three adjacent cells of the same color will collapse.
 * @author Matt Medley
 */
public class BlockAddiction extends AbstractGame {
	
	/**
	 * Constructs a new BlockAddiction game with grid dimensions at the given height and width, a given generator, and a number of filled rows.
	 * @param givenHeight
	 * 	 Desired height of the BlockAddiction grid
	 * @param givenWidth
	 * 	 Desired width of the BlockAddiction grid
	 * @param generator
	 * 	 Generator to be used with this BlockAddiction
	 * @param preFillRows
	 * 	 Number of rows in the BlockAddiction that will be filled with icons at the beginning of the game
	 */
	public BlockAddiction(int givenHeight, int givenWidth, Generator generator, int preFillRows) {
		super(givenHeight, givenWidth, generator);
		for(int i = givenHeight - preFillRows; i < givenHeight; i++) {
			for(int j = 0; j < givenWidth; j++) {
				if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
					setBlock(i, j, generator.randomIcon());
				}
				
			}
		}
	}
	
	/**
	 * Constructs a new BlockAddiction game with grid dimensions at the given height and width and a given generator. Does not prefill any rows.
	 * @param givenHeight
	 * 	 Desired height of the BlockAddiction grid
	 * @param givenWidth
	 * 	 Desired width of the BlockAddiction grid
	 * @param generator
	 * 	 Generator to be used with this BlockAddiction
	 */
	public BlockAddiction(int givenHeight, int givenWidth, Generator generator) {
		super(givenHeight, givenWidth, generator);
	}
	
	/**
	 * Determines the positions of cells that need to be collapsed (three adjacent icons that are the same color).
	 * @return
	 * 	 Position List containing all cell positions that need to be collapsed, without any duplicates.
	 */
	public List<Position> determinePositionsToCollapse() {
		ArrayList<Position> collapsedIcons = new ArrayList<Position>();
		for(int i = 1; i < getHeight()-1; i++) {
			for(int j = 1; j < getWidth()-1; j++) {
				if(getIcon(i, j) != null && getIcon(i, j).matches(getIcon(i, j+1)) && getIcon(i, j+1).matches(getIcon(i, j-1))) {
					collapsedIcons.add(new Position(i, j));
					collapsedIcons.add(new Position(i, j+1));
					collapsedIcons.add(new Position(i, j-1));
				}
				if(getIcon(i, j) != null && getIcon(i, j).matches(getIcon(i+1, j)) && getIcon(i+1, j).matches(getIcon(i-1, j))) {
					collapsedIcons.add(new Position(i, j));
					collapsedIcons.add(new Position(i+1, j));
					collapsedIcons.add(new Position(i-1, j));
				}
				if(getIcon(i, j) != null && getIcon(i, j).matches(getIcon(i+1, j)) && getIcon(i+1, j).matches(getIcon(i+1, j+1))) {
					collapsedIcons.add(new Position(i, j));
					collapsedIcons.add(new Position(i+1, j));
					collapsedIcons.add(new Position(i+1, j+1));
				}
				if(getIcon(i, j) != null && getIcon(i, j).matches(getIcon(i+1, j)) && getIcon(i+1, j).matches(getIcon(i+1, j-1))) {
					collapsedIcons.add(new Position(i, j));
					collapsedIcons.add(new Position(i+1, j));
					collapsedIcons.add(new Position(i+1, j-1));
				}
				if(getIcon(i, j) != null && getIcon(i, j).matches(getIcon(i-1, j)) && getIcon(i-1, j).matches(getIcon(i-1, j+1))) {
					collapsedIcons.add(new Position(i, j));
					collapsedIcons.add(new Position(i-1, j));
					collapsedIcons.add(new Position(i-1, j+1));
				}
				if(getIcon(i, j) != null && getIcon(i, j).matches(getIcon(i-1, j)) && getIcon(i-1, j).matches(getIcon(i-1, j-1))) {
					collapsedIcons.add(new Position(i, j));
					collapsedIcons.add(new Position(i-1, j));
					collapsedIcons.add(new Position(i-1, j-1));
				}	
			}
		}
		ArrayList<Position> noDuplicates = new ArrayList<Position>();
		int numDuplicates = 0;
		for(int i = 0; i < collapsedIcons.size(); i++) {
			for(int j = i+1; j < collapsedIcons.size(); j++) {
				if(collapsedIcons.get(i).equals(collapsedIcons.get(j))) {
					numDuplicates++;
				}
			}
			if(numDuplicates == 0 || noDuplicates.contains(collapsedIcons.get(i)) == false) {
				noDuplicates.add(collapsedIcons.get(i));
			}	
		}
		Collections.sort(noDuplicates);
		return noDuplicates;
	}
	

}
