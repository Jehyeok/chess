package chess.test;

import chess.table.Piece;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testCreateIntegratedWhite() {
		verifyCreation(Piece.createWhitePiece(Piece.Type.PAWN), Piece.createBlackPiece(Piece.Type.PAWN),
				Piece.Type.PAWN, Piece.PAWN_REPRESENTATON);
		
		verifyCreation(Piece.createWhitePiece(Piece.Type.BISHOP), Piece.createBlackPiece(Piece.Type.BISHOP),
				Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATON);	
	}
	
	private void verifyCreation(Piece whitePiece, Piece blackPiece,
			Piece.Type type, char representation) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertEquals(representation, whitePiece.getRepresentation());
		
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
		assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
	}
	
	public void testNoPiece() {
		Piece blank = Piece.noPiece();
		assertEquals('.', blank.getRepresentation());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());
	}
}
