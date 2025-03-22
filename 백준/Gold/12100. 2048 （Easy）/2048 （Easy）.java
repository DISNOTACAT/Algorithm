import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static int max = 0;   // 재귀 할 때마다 max 를 업데이트 함

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());

    int[][] inputBoardNumber = new int[size][size];
    for(int i = 0; i < size; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      for(int j = 0; j < size; j++) {
        inputBoardNumber[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();

    Board originBoard = Board.generateBoardBy(inputBoardNumber, 0);
    bruteForce2048(originBoard); // 재귀 시작

    System.out.println(max);
  }

  private static void bruteForce2048(Board board) {

    max = Math.max(max, board.getMax());

    if(board.isCountMoreThanFive()) return;

    Board snapshot = board.getSnapshot();

    bruteForce2048(moveToRight(snapshot));
    bruteForce2048(moveToDown(snapshot));
    bruteForce2048(moveToLeft(snapshot));
    bruteForce2048(moveToUp(snapshot));
  }


  private static Board moveToRight(Board snapshot) {

    int boardSize = snapshot.getBoard().length;
    int[][] board = getCopyOf(snapshot, boardSize);

    for(int row = 0; row < boardSize; row++) {
      int[] curMoveArr = new int[boardSize];

      for(int col = 0; col < boardSize; col++) {
        curMoveArr[col] = board[row][col];
        board[row][col] = 0;
      }

      int[] resultBlockNumbers = getResultNumbersFrom(curMoveArr, boardSize);
      board[row] = Arrays.copyOf(resultBlockNumbers, boardSize);
    }
    return new Board(board, snapshot.getMoveCount() + 1);
  }

  private static Board moveToDown(Board snapshot) {

    int boardSize = snapshot.getBoard().length;
    int[][] board = getCopyOf(snapshot, boardSize);

    for(int col = 0; col < boardSize; col++) {
      int[] curMoveArr = new int[boardSize];

      for(int row = 0; row < boardSize; row++) {
        curMoveArr[row] = board[row][col];
        board[row][col] = 0;
      }

      int[] resultBlockNumbers = getResultNumbersFrom(curMoveArr, boardSize);
      for(int i = 0; i < boardSize; i++) {
        board[i][col] = resultBlockNumbers[i];
      }
    }
    return new Board(board, snapshot.getMoveCount() + 1);
  }

  private static Board moveToLeft(Board snapshot) {

    int boardSize = snapshot.getBoard().length;
    int[][] board = getCopyOf(snapshot, boardSize);

    for(int row = 0; row < boardSize; row++) {
      int[] curMoveArr = new int[boardSize];

      for(int col = boardSize - 1; col >= 0; col--) {
        curMoveArr[(boardSize - 1) - col] = board[row][col];
        board[row][col] = 0;
      }

      int[] resultBlockNumbers = getResultNumbersFrom(curMoveArr, boardSize);
      for(int col = boardSize - 1; col >= 0; col--) {
        board[row][col] = resultBlockNumbers[(boardSize - 1) - col];
      }
    }
    return new Board(board, snapshot.getMoveCount() + 1);
  }

  private static Board moveToUp(Board snapshot) {

    int boardSize = snapshot.getBoard().length;
    int[][] board = getCopyOf(snapshot, boardSize);

    for(int col = 0; col < boardSize; col++) {
      int[] curMoveArr = new int[boardSize];

      for(int row = boardSize - 1; row >= 0; row--) {
        curMoveArr[(boardSize - 1) - row] = board[row][col];
        board[row][col] = 0;
      }

      int[] resultBlockNumbers = getResultNumbersFrom(curMoveArr, boardSize);
      for(int row = boardSize - 1; row >= 0; row--) {
        board[row][col] = resultBlockNumbers[(boardSize - 1) - row];
      }
    }
    return new Board(board, snapshot.getMoveCount() + 1);
  }

  private static int[][] getCopyOf(Board snapshot, int boardSize) {
    int[][] board = new int[boardSize][boardSize];
    for(int row = 0; row < boardSize; row++) {
      board[row] = snapshot.getBoard()[row].clone();
    }
    return board;
  }

  private static int[] getResultNumbersFrom(int[] curMoveArr, int boardSize) {
    ArrayList<Integer> blockNumbers = getCalculatedNumbersToRightFrom(curMoveArr);

    return getResultMovedNumbersToRight(boardSize, blockNumbers);
  }
  
  private static ArrayList<Integer> getCalculatedNumbersToRightFrom(int[] numberArr) {

    Deque<Integer> numberQueue = new ArrayDeque<>();
    for(int i = numberArr.length-1; i >= 0; i--) {

      if(numberArr[i] > 0) {
        int curNumber = numberArr[i];

        if(numberQueue.isEmpty()) {
          numberQueue.offerFirst(curNumber);
          continue;
        }

        int lastNumber = numberQueue.peekFirst();
        if(lastNumber == curNumber) {
          numberQueue.remove();
          numberQueue.offerFirst(curNumber * 2);
          numberQueue.offerFirst(0);  // 연속 계산을 막기위한 0 삽입
          continue;
        }

        numberQueue.offerFirst(curNumber);
      }
    }

    ArrayList<Integer> numberList = new ArrayList<>();
    while(!numberQueue.isEmpty()) {
      int number = numberQueue.pollFirst();
      if(number != 0) {
        numberList.add(number);
      }
    }
    return numberList;
  }

 
  private static int[] getResultMovedNumbersToRight(int boardSize, ArrayList<Integer> blockNumbers) {
    int[] resultBlockNumbers = new int[boardSize];
    for(int j = 0; j < blockNumbers.size(); j++) {
      int index = boardSize - blockNumbers.size() + j;
      resultBlockNumbers[index] = blockNumbers.get(j);
    }
    return resultBlockNumbers;
  }

  private static int[] getResultMovedNumbersToLeft(int boardSize, ArrayList<Integer> blockNumbers) {
    int[] resultBlockNumbers = new int[boardSize];
    for(int j = 0; j < blockNumbers.size(); j++) {
      int index = (blockNumbers.size() - 1) - j;
      resultBlockNumbers[j] = blockNumbers.get(index);
    }
    return resultBlockNumbers;
  }

  static class Board{
    private int[][] board;
    private int moveCount;
    private int max;

    private Board(int[][] inputBoardNumber, int count) {
      this.board = inputBoardNumber;
      this.moveCount = count;
      this.max = calculateMaxOf(inputBoardNumber);
    }

    private int calculateMaxOf(int[][] inputBoardNumber) {
      int max = 0;

      for(int i = 0; i < inputBoardNumber.length; i++) {
        for(int j = 0; j < inputBoardNumber[i].length; j++) {
          max = Math.max(max, inputBoardNumber[i][j]);
        }
      }
      return max;
    }

    public static Board generateBoardBy(int[][] inputBoardNumber, int count) {
      return new Board(inputBoardNumber, count);
    }

    public int[][] getBoard() {return board;}

    public int getMoveCount() {return moveCount;}

    public int getMax() {return max;}

    public boolean isCountMoreThanFive(){
      return moveCount >= 5;
    }

    public Board getSnapshot(){
      int[][] snapshot = new int[board.length][board.length];
      for(int i = 0; i < board.length; i++) {
        snapshot[i] = board[i].clone();
      }
      return new Board(snapshot, moveCount);
    }
  }
}