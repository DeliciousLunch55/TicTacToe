package com.dobby.apps.TicTacToe;

import javax.swing.JOptionPane;

public class TicTacToeMain {

    public static void main(String[] args)
    {
        String[] initOptions={"One Player", "Two Players"};

        int numPlayers=JOptionPane.showOptionDialog(null,"Select the number of players:",
                "Select Players", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,initOptions,
                null);
        numPlayers++;

        if(numPlayers==0) {
            numPlayers=2;
        }

        TicTacToe gameTime=new TicTacToe(numPlayers);
    }
}
