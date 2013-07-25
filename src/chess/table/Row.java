package chess.table;

import java.util.ArrayList;

import chess.table.Piece.Color;
import chess.table.Piece.Type;

public class Row {

	private ArrayList<Piece> unitLists = new ArrayList<Piece>();
	
	public void addUnit(Piece piece) {
		unitLists.add(piece);
	}
	
	public ArrayList<Piece> getUnitLists() {
		return unitLists;
	}
	
	public String print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.unitLists.size(); i++) {
			sb.append(this.unitLists.get(i).getRepresentation());
		}
		return sb.toString();
	}

	public Row createFirstRow() {
		createFirstLastRowWithColor(Piece.Color.black);
		return this;
	}
	
	public Row createLastRow() {
		createFirstLastRowWithColor(Piece.Color.white);
		return this;
	}
	
	public Row createPawnRowWithColor(Piece.Color color) {
		for (int i = 0; i < 8; i++) {
			this.addUnit(new Piece(color, Piece.Type.PAWN));
		}
		return this;
	}
	
	public void createFirstLastRowWithColor(Piece.Color color) {
		this.addUnit(new Piece(color, Piece.Type.ROOK));
		this.addUnit(new Piece(color, Piece.Type.KNIGHT));
		this.addUnit(new Piece(color, Piece.Type.BISHOP));
		this.addUnit(new Piece(color, Piece.Type.QUEEN));
		this.addUnit(new Piece(color, Piece.Type.KING));
		this.addUnit(new Piece(color, Piece.Type.BISHOP));
		this.addUnit(new Piece(color, Piece.Type.KNIGHT));
		this.addUnit(new Piece(color, Piece.Type.ROOK));
	}

	public int getNumOfPiecesOnRow(Color color, Type type) {
		int num = 0;
		
		for (int i = 0; i < this.unitLists.size(); i++) {
			if (this.unitLists.get(i).getType().equals(type) && 
				this.unitLists.get(i).getColor().equals(color)) {
				num++;
			}
		}
		return num;
	}

	public Row createBlankRow() {
		for (int i = 0; i < 8; i++) {
			unitLists.add(Piece.noPiece());
		}
		return this;
	}

	public void addUnit(Piece piece, int i) {
		this.unitLists.remove(i);
		this.unitLists.add(i, piece);
	}
}