package chess.test;

import util.StringUtil;
import junit.framework.TestCase;
import chess.table.Piece;
import chess.table.Row;

public class RowTest extends TestCase {
	public void testCreateOneRow() {
		Row row = new Row();
		for (int i = 0; i < 8; i++) {
			row.addUnit(new Piece(Piece.Color.black, Piece.Type.PAWN));			
		}
		assertEquals("PPPPPPPP", row.print());
	}
	
	public void testCreateFirstRow() {
		Row row = new Row();
		row.createFirstRow();
		assertEquals("RNBQKBNR", row.print());
	}
	
	public void testAddPieceToRow() {
		Row row = new Row();
		for (int i = 0; i < 8; i++) {
			row.addUnit(Piece.noPiece());
		}
		row.addUnit(new Piece(Piece.Color.black, Piece.Type.KING), 0);
		assertEquals("K.......", row.print());
	}
}
