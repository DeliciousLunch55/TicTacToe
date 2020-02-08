

public class CheckBoardCondition {

    public static byte checkWinCondition(byte[] boardState)
    {
        byte winner=0;

        if(boardState[0]==boardState[1]&&boardState[1]==boardState[2]&&boardState[0]!=0) {
            if(boardState[0]==1) {
                winner=1;
            } else if(boardState[0]==2) {
                winner=2;
            }
        } else if(boardState[3]==boardState[4]&&boardState[4]==boardState[5]&&boardState[3]!=0) {
            if(boardState[3]==1) {
                winner=1;
            } else if(boardState[3]==2) {
                winner=2;
            }
        } else if(boardState[6]==boardState[7]&&boardState[7]==boardState[8]&&boardState[6]!=0) {
            if(boardState[6]==1) {
                winner=1;
            } else if(boardState[6]==2) {
                winner=2;
            }
        } else if(boardState[0]==boardState[3]&&boardState[3]==boardState[6]&&boardState[0]!=0) {
            if(boardState[0]==1) {
                winner=1;
            } else if(boardState[0]==2) {
                winner=2;
            }
        } else if(boardState[1]==boardState[4]&&boardState[4]==boardState[7]&&boardState[1]!=0) {
            if(boardState[1]==1) {
                winner=1;
            } else if(boardState[1]==2) {
                winner=2;
            }
        } else if(boardState[2]==boardState[5]&&boardState[5]==boardState[8]&&boardState[2]!=0) {
            if(boardState[2]==1) {
                winner=1;
            } else if(boardState[2]==2) {
                winner=2;
            }
        } else if(boardState[0]==boardState[4]&&boardState[4]==boardState[8]&&boardState[0]!=0) {
            if(boardState[0]==1) {
                winner=1;
            } else if(boardState[0]==2) {
                winner=2;
            }
        } else if(boardState[2]==boardState[4]&&boardState[4]==boardState[6]&&boardState[2]!=0) {
            if(boardState[2]==1) {
                winner=1;
            } else if(boardState[2]==2) {
                winner=2;
            }
        }

        return winner;
    }

    public static boolean checkDrawCondition(byte boardState[])
    {
        boolean drawFlag=true;

        for(int i=0;i<boardState.length;i++)
        {
            if(boardState[i]==0)
            {
                drawFlag=false;
            }
        }

        if(drawFlag==true)
        {
            if(checkWinCondition(boardState)!=0)
            {
                drawFlag=false;
            }
        }

        return drawFlag;
    }

}
