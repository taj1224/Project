import pack.Chessboard;

class Chess {
    public static void main(String[] args){
        Chessboard board=new Chessboard();
        board.setPiece(1, 'a', "ROOK");
        board.setPiece(1, 'b', "KNIGHT");
        board.setPiece(1, 'c', "BISHOP");
        board.setPiece(1, 'd', "QUEEN");
        board.setPiece(1, 'e', "KING");
        board.setPiece(1, 'f', "BISHOP");
        board.setPiece(1, 'g', "KNIGHT");
        board.setPiece(1, 'h', "ROOK");
        board.setPiece(2, 'a', "PAWN");
        board.setPiece(2, 'b', "PAWN");
        System.out.println(board.getPiece(1, 'a'));
        System.out.println(board.getPiece(2, 'b'));
    }
}
