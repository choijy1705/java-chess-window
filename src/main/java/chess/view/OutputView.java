package chess.view;

import chess.view.dto.BoardDto;
import chess.view.dto.PieceDto;

import java.util.Arrays;

public class OutputView {

    private static final int BOARD_COLUMN_SIZE = 8;
    private static final String SCORE_FORMAT = "백: %.1f 흑: %.1f %n";

    public static void drawBoard(final BoardDto boardDto) {
        String[] boardStatus = createBoardStatus(boardDto);

        for (int i = 0; i < boardStatus.length; i++) {
            lineSeparatorIfSatisfyCondition(i);
            System.out.print(boardStatus[i]);
        }
        System.out.println(" " + 1);
        System.out.println();
        System.out.println("abcdefgh");
    }

    private static String[] createBoardStatus(BoardDto boardDto) {
        String[] board = new String[boardDto.getColumn() * boardDto.getRow()];
        Arrays.fill(board, ".");

        for (final PieceDto pieceDto : boardDto.getPieceDtos()) {
            board[pieceDto.getRow() * BOARD_COLUMN_SIZE + pieceDto.getColumn()] = pieceDto.getNotation();
        }

        return board;
    }

    private static void lineSeparatorIfSatisfyCondition(final int lineSeparateThreshold) {
        if (lineSeparateThreshold != 0 && lineSeparateThreshold % BOARD_COLUMN_SIZE == 0) {
            System.out.println(" " + ((BOARD_COLUMN_SIZE+1) - (lineSeparateThreshold/BOARD_COLUMN_SIZE)));
        }
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }

    public static void printScore(final double whiteScore, final double blackScore) {
        System.out.printf(SCORE_FORMAT, whiteScore, blackScore);
    }

    public static void printMainPage() {
        System.out.println("> 체스 게임을 시작합니다.");
        System.out.println("> 게임 시작 : start");
        System.out.println("> 게임 종료 : end");
        System.out.println("> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
    }
}
