package chess.test;

import junit.framework.TestCase;
import util.StringUtil;
import chess.table.Board;
import chess.table.Piece;
import chess.table.Row;
import chess.table.Piece.Type;

public class BoardTest extends TestCase {
	public void testInit() {
		Board board = new Board();
		board.initializeBoard();
		String blankRank = StringUtil.appendNewLine("........");
		
		assertEquals(
				StringUtil.appendNewLine("RNBQKBNR") +
				StringUtil.appendNewLine("PPPPPPPP") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("pppppppp") +
				StringUtil.appendNewLine("rnbqkbnr"),
				board.print());
	}
	
	public void testGetLeftNumOfPieces(Piece.Color color, Piece.Type type) {
		Board board = new Board();
		
		Row row1 = new Row();
		
		row1.addUnit(Piece.noPiece());
		row1.addUnit(Piece.createBlackPiece(Piece.Type.KNIGHT));
		row1.addUnit(Piece.createBlackPiece(Piece.Type.ROOK));
		row1.addUnit(Piece.noPiece());
		row1.addUnit(Piece.noPiece());
		row1.addUnit(Piece.noPiece());
		row1.addUnit(Piece.noPiece());
		row1.addUnit(Piece.noPiece());
		
		Row row2 = new Row();
		
		row2.addUnit(Piece.createBlackPiece(Piece.Type.PAWN));
		row2.addUnit(Piece.noPiece());
		row2.addUnit(Piece.createBlackPiece(Piece.Type.PAWN));
		row2.addUnit(Piece.createBlackPiece(Piece.Type.BISHOP));
		row2.addUnit(Piece.noPiece());
		row2.addUnit(Piece.noPiece());
		row2.addUnit(Piece.noPiece());
		row2.addUnit(Piece.noPiece());
		
		Row row3 = new Row();
		
		row3.addUnit(Piece.noPiece());
		row3.addUnit(Piece.createBlackPiece(Piece.Type.PAWN));
		row3.addUnit(Piece.noPiece());
		row3.addUnit(Piece.noPiece());
		row3.addUnit(Piece.createBlackPiece(Piece.Type.QUEEN));
		row3.addUnit(Piece.noPiece());
		row3.addUnit(Piece.noPiece());
		row3.addUnit(Piece.noPiece());
		
		Row row4 = new Row();
		
		row4.addUnit(Piece.noPiece());
		row4.addUnit(Piece.noPiece());
		row4.addUnit(Piece.noPiece());
		row4.addUnit(Piece.noPiece());
		row4.addUnit(Piece.noPiece());
		row4.addUnit(Piece.noPiece());
		row4.addUnit(Piece.noPiece());
		row4.addUnit(Piece.noPiece());
		
		Row row5 = new Row();
		
		row5.addUnit(Piece.noPiece());
		row5.addUnit(Piece.noPiece());
		row5.addUnit(Piece.noPiece());
		row5.addUnit(Piece.noPiece());
		row5.addUnit(Piece.noPiece());
		row5.addUnit(Piece.createWhitePiece(Piece.Type.KNIGHT));
		row5.addUnit(Piece.createWhitePiece(Piece.Type.QUEEN));
		row5.addUnit(Piece.noPiece());
		
		Row row6 = new Row();
		
		row6.addUnit(Piece.noPiece());
		row6.addUnit(Piece.noPiece());
		row6.addUnit(Piece.noPiece());
		row6.addUnit(Piece.noPiece());
		row6.addUnit(Piece.noPiece());
		row3.addUnit(Piece.createWhitePiece(Piece.Type.PAWN));
		row6.addUnit(Piece.noPiece());
		row6.addUnit(Piece.noPiece());
		
		Row row7 = new Row();
		
		row7.addUnit(Piece.noPiece());
		row7.addUnit(Piece.noPiece());
		row7.addUnit(Piece.noPiece());
		row7.addUnit(Piece.noPiece());
		row7.addUnit(Piece.noPiece());
		row7.addUnit(Piece.noPiece());
		row3.addUnit(Piece.createWhitePiece(Piece.Type.PAWN));
		row7.addUnit(Piece.noPiece());
		
		Row row8 = new Row();
		
		row8.addUnit(Piece.noPiece());
		row8.addUnit(Piece.noPiece());
		row8.addUnit(Piece.noPiece());
		row8.addUnit(Piece.noPiece());
		row3.addUnit(Piece.createWhitePiece(Piece.Type.ROOK));
		row3.addUnit(Piece.createWhitePiece(Piece.Type.KNIGHT));
		row8.addUnit(Piece.noPiece());
		row8.addUnit(Piece.noPiece());
		
		board.addRow(row1);
		board.addRow(row2);
		board.addRow(row3);
		board.addRow(row4);
		board.addRow(row5);
		board.addRow(row6);
		board.addRow(row7);
		board.addRow(row8);
		
		assertEquals(StringUtil.appendNewLine(".KR.....") +
					 StringUtil.appendNewLine("P.PB....") +
					 StringUtil.appendNewLine(".P..Q...") +
					 StringUtil.appendNewLine("........") +
					 StringUtil.appendNewLine(".....nq.") +
					 StringUtil.appendNewLine(".....p..") +
					 StringUtil.appendNewLine("......p.") +
					 StringUtil.appendNewLine("....rk.."), board.print());
		
		assertEquals(3, board.getNumOfPiecesOnBoard(Piece.Color.black, Piece.Type.PAWN));
		assertEquals(2, board.getNumOfPiecesOnBoard(Piece.Color.white, Piece.Type.PAWN));
	}
	
	public void testGetPieceOnBoard() {
		Board board = new Board();
		board.initializeBoard();
		assertEquals(Piece.Type.ROOK, board.getPieceOnBoard("a8").getType());
	}
	
	public void testIsNullSpotOnBoard() {
		Board board = new Board();
		board.initializeBoard();
		
		assertTrue(board.isNullSpot("a5"));
		assertFalse(board.isNullSpot("a8"));
	}
	
	public void testAddPiece() {
		Board board = new Board();
		board.initializeBoard();
		
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(
				StringUtil.appendNewLine("RNBQKBNR") +
				StringUtil.appendNewLine("PPPPPPPP") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("pppppppp") +
				StringUtil.appendNewLine("rnbqkbnr"),
				board.print());
		
		board.addUnitAt("c5", new Piece(Piece.Color.black, Piece.Type.KING));
		assertEquals(
				StringUtil.appendNewLine("RNBQKBNR") +
				StringUtil.appendNewLine("PPPPPPPP") +
				blankRank + StringUtil.appendNewLine("..K.....") + blankRank + blankRank +
				StringUtil.appendNewLine("pppppppp") +
				StringUtil.appendNewLine("rnbqkbnr"),
				board.print());
	}
}