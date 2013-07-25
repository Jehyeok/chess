package chess.table;

public class Piece {
	public enum Type { PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE };
	public enum Color { black, white };

	public static final char PAWN_REPRESENTATON = 'p';
	public static final char ROOK_REPRESENTATON = 'r';
	public static final char KNIGHT_REPRESENTATON = 'n';
	public static final char BISHOP_REPRESENTATON = 'b';
	public static final char QUEEN_REPRESENTATON = 'q';
	public static final char KING_REPRESENTATON = 'k';
	public static final char NO_PIECE_REPRESENTATION = '.';	
	
	private Color color;
	private Type type;
	
	public Piece(Color color, Type type) {
		// TODO Auto-generated constructor stub
		this.color = color;
		this.type = type;
	}
	
	public Piece() {
		// TODO Auto-generated constructor stub
	}

	public Color getColor() {
		return color;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public char getRepresentation() {
		// TODO Auto-generated method stub
		if (this.type.equals(Type.PAWN)) {
			if (isBlack()) return 'P';
			else return 'p';
		}
		else if (this.type.equals(Type.ROOK)) {
			if (isBlack()) return 'R';
			else return 'r';
		}
		else if (this.type.equals(Type.KNIGHT)) {
			if (isBlack()) return 'N';
			else return 'n';
		}
		else if (this.type.equals(Type.BISHOP)) {
			if (isBlack()) return 'B';
			else return 'b';
		}
		else if (this.type.equals(Type.KING)) {
			if (isBlack()) return 'K';
			else return 'k';
		}
		else if (this.type.equals(Type.QUEEN)) {
			if (isBlack()) return'Q';
			else return 'q';
		}
		else if (this.type.equals(Type.NO_PIECE)) {
			return '.';
		}
		return 'X';
	}

	public boolean isBlack() {
		return this.color==Color.black;
	}

	public boolean isWhite() {
		return this.color==Color.white;
	}

	public static Piece createWhitePiece(Type type) {
		Piece piece = new Piece(Color.white, type);
		return piece;
	}
	
	public static Piece createBlackPiece(Type type) {
		Piece piece = new Piece(Color.black, type);
		return piece;
	}

	public static Piece noPiece() {
		Piece blank = new Piece(Color.black, Type.NO_PIECE);
		return blank;
	}
}
