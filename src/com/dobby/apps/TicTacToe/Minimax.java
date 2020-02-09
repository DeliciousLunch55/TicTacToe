package com.dobby.apps.TicTacToe;

public class Minimax {

    public static int evaluateBoard(byte[] board) {
        int score=0;

        byte checkWin=CheckBoardCondition.checkWinCondition(board);
        if(checkWin==2) {
            score=10;
        } else if(checkWin==1) {
            score=-10;
        }

        return score;
    }

    public static int performMinmax(byte[] board,int depth,boolean isMax) {
        int score=evaluateBoard(board);

        if(score==10) {  //If the board has a winner, return the winner's score
            return score;
        }else if(score==-10) {
            return score;
        }

        if(CheckBoardCondition.checkDrawCondition(board)) {  //If the board is a draw, return the draw score
            return 0;
        }

        if(isMax) {  //If there is no winner and no draw, continue with minmax another layer down
            int best=Integer.MIN_VALUE;

            for(int i=0;i<board.length;i++) {
                if(board[i]==0) {
                    board[i]=2;
                    best=Math.max(best,performMinmax(board,depth+1,false));
                    board[i]=0;
                }
            } return best;
        } else {
            int best=Integer.MAX_VALUE;

            for(int i=0;i<board.length;i++) {
                if(board[i]==0) {
                    board[i]=1;
                    best=Math.min(best,performMinmax(board,depth+1,true));
                    board[i]=0;
                }
            } return best;
        }
    }

    public static int findBestMove(byte[] board) {
        int bestVal=Integer.MIN_VALUE;
        int bestMove=-1;

        for(int i=0;i<board.length;i++) {
            if(board[i]==0) {
                board[i]=2; //perform the move for evaluation
                int moveVal=performMinmax(board,0,false);
                board[i]=0;  //reset the move after evaluation

                if(moveVal>bestVal) {
                    bestVal=moveVal;
                    bestMove=i;
                }
            }
        }
        return bestMove;
    }

    public static void main(String[] args) {
        byte[] testBoard={2,1,1,1,2,1,0,0,0};

        int bestMove=findBestMove(testBoard);
        System.out.printf("The best move is index %d\n",bestMove);
    }
}
