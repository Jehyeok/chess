package chess.table;

import java.util.ArrayList;

import chess.table.Piece.Color;
import chess.table.Piece.Type;

public class Board {

	public static final String NEWLINE = System.getProperty("line.separator"); 
	
	private ArrayList<Row> rowLists = new ArrayList<Row>();
	private int numberOfBlackUnits = 0;
	private int numberOfWhiteUnits = 0;
	public final String emptyRow = "........";

	public int getNumberOfWhiteUnits() {
		return numberOfWhiteUnits;
	}

	public void setNumberOfWhiteUnits(int numberOfWhiteUnits) {
		this.numberOfWhiteUnits = numberOfWhiteUnits;
	}

	public int getNumberOfBlackUnits() {
		return numberOfBlackUnits;
	}

	public void setNumberOfBlackUnits(int numberOfBlackUnits) {
		this.numberOfBlackUnits = numberOfBlackUnits;
	}

	public void initializeBoard() {
		ArrayList<Row> rows = new ArrayList<Row>();
		
		rows.add(new Row().createFirstRow());
		rows.add(new Row().createPawnRowWithColor(Piece.Color.black));
		rows.add(new Row().createBlankRow());
		rows.add(new Row().createBlankRow());
		rows.add(new Row().createBlankRow());
		rows.add(new Row().createBlankRow());
		rows.add(new Row().createPawnRowWithColor(Piece.Color.white));
		rows.add(new Row().createLastRow());
		
		this.rowLists = rows;
	}

	public void addRow(Row row) {
		// TODO Auto-generated method stub
		this.rowLists.add(row);
	}

	public String print() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(this.rowLists.get(i).print() + this.NEWLINE);
		}
		return sb.toString();
	}

	public int getNumOfPiecesOnBoard(Color color, Type type) {
		int num=0;
		
		for (int i = 0; i < rowLists.size(); i++) {
			num += rowLists.get(i).getNumOfPiecesOnRow(color, type);
		}
		return num;
	}

	public Piece getPieceOnBoard(String position) {
		Row row = new Row();
		
		row = this.rowLists.get(8-Character.getNumericValue(position.charAt(1)));
		return row.getUnitLists().get(Character.getNumericValue(position.charAt(0)) - 10);
	}

	public boolean isNullSpot(String position) {
		Piece piece = new Piece();
		piece = getPieceOnBoard(position);
		
		if (piece.getRepresentation() == Piece.NO_PIECE_REPRESENTATION) return true;
		else return false;
	}

	public boolean addUnitAt(String position, Piece piece) {
		if (isNullSpot(position)) {
			Row row = new Row();
			row = getRowWithPiece(position);
			row.addUnit(piece, Character.getNumericValue(position.charAt(0)) - 10);
			
			return true;
		}
		else return false;
	}

	private Row getRowWithPiece(String position) {
		return this.rowLists.get(8-Character.getNumericValue(position.charAt(1)));
	}
}
