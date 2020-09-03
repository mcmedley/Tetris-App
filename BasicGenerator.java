package hw4;

import java.awt.Color;
import java.util.Random;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * Generator for Piece objects in BlockAddiction. Icons are 
 * always selected uniformly at random, and the Piece types
 * are generated with the following probabilities:
 * <ul>
 * <li>LPiece - 10%
 * <li>DiagonalPiece - 25%
 * <li>CornerPiece - 15%
 * <li>SnakePiece - 10%
 * <li>IPiece - 40%
 * </ul>
 * The initial position of each piece is based on its
 * vertical size as well as the width of the grid (given
 * as an argument to getNext).  The initial column is always
 * width/2 - 1.  The initial row is:
 *  * <ul>
 * <li>LPiece - row = -2
 * <li>DiagonalPiece - row = -1
 * <li>CornerPiece - row = -1
 * <li>SnakePiece - row = -1
 * <li>IPiece - row = -2
 * </ul>
 * 
 */
public class BasicGenerator implements Generator
{
	
	/**
	 * Random object that will generate a random number, which will determine the next piece to be generated.
	 */
  private Random rand;

  /**
   * Constructs a BasicGenerator that will use the given
   * Random object as its source of randomness.
   * @param givenRandom
   *   instance of Random to use
   */
  public BasicGenerator(Random givenRandom)
  {
    rand = givenRandom;
  }
  
  /**
   * Generates the next Piece object based upon the random number generator.
   * @param width
   * 	 Width of the grid
   * @return
   * 	 The generated Piece object
   */
  @Override
  public Piece getNext(int width) {
	Piece piece = null;
    int col = width / 2 - 1;
    int num = rand.nextInt(99) + 1;
    
	if(num <= 40) { // 40%
		Icon[] IPieceIcons = {randomIcon(), randomIcon(), randomIcon()};
		piece = new IPiece(new Position(-2, col), IPieceIcons);
	}
	else if(num > 40 && num <= 65) { // 25%
		Icon[] DiagonalPieceIcons = {randomIcon(), randomIcon()};
		piece = new DiagonalPiece(new Position(-1, col), DiagonalPieceIcons);  	
	}
	else if(num > 65 && num <= 80) { // 15%
		Icon[] CornerPieceIcons = {randomIcon(), randomIcon(), randomIcon()};
		piece = new CornerPiece(new Position(-1, col), CornerPieceIcons);
	}
	else if(num > 80 && num <= 90) { // 10%
		Icon[] SnakePieceIcons = {randomIcon(), randomIcon(), randomIcon(), randomIcon()};
		piece = new SnakePiece(new Position(-1, col), SnakePieceIcons);
	}
	else if(num > 90 && num <= 100) { // 10%
		Icon[] LPieceIcons = {randomIcon(), randomIcon(), randomIcon(), randomIcon()};
		piece = new LPiece(new Position(-2, col), LPieceIcons);
	}
	return piece;
    
  }

  /**
   * Makes an Icon of a random color.
   * @return
   * 	 Icon object of a random color.
   */
  @Override
  public Icon randomIcon()
  {
    return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);
  }

}

