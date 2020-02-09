package com.dobby.apps.TicTacToe;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class XOButton extends JButton{
    ImageIcon X,O;
    byte value=0;
    byte playerTurn;

    /*
    value 0: nothing
    value 1: O
    value 2: X
     */
    public XOButton()
    {
        X=new ImageIcon(this.getClass().getResource("/com/dobby/apps/TicTacToe/res/X.png"));
        O=new ImageIcon(this.getClass().getResource("/com/dobby/apps/TicTacToe/res/O.png"));
    }

    public void setValue(byte playerVal)
    {
        this.value=playerVal;

        switch(value) {
            case 0:
                this.setIcon(null);
                break;
            case 1:
                this.setIcon(O);
                break;
            case 2:
                this.setIcon(X);
                break;
        }
    }

    public byte getButtonState()
    {
        return value;
    }
}
