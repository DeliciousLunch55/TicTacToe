
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe extends JFrame implements ActionListener{

    JPanel pnl=new JPanel();
    JPanel statusPanel=new JPanel();
    JLabel statusLabel=new JLabel();
    ImageIcon masterIcon=new ImageIcon(this.getClass().getResource("/res/O.png"));

    XOButton buttons[]=new XOButton[9];
    byte turnPlayer=1; //turnPlayer 1: O, turnPlayer 2: X
    byte winner=0; //winner 0: no winner yet, winner 1: player 1 (O) wins, winner 2: player 2 (X) wins

    public TicTacToe()
    {
        super("Tic Tac Toe!");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(masterIcon.getImage());
        setLocationRelativeTo(null);

        //Setting up and adding the status bar at the bottom of the frame
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        add(statusPanel,BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(getWidth(),20));
        statusPanel.setLayout(new BoxLayout(statusPanel,BoxLayout.LINE_AXIS));
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        setStatus("Welcome to Tic Tac Toe!  Player 1, your turn.");

        //Setting up and adding the nine button array to the main panel
        pnl.setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++)
        {
            buttons[i]=new XOButton();  //Make and add button objects to panel
            pnl.add(buttons[i]);
            buttons[i].addActionListener(this);  //Add ActionListener to button objects
        }

        add(pnl);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<buttons.length;i++)
        {
            if(e.getSource()==buttons[i])
            {
                if (buttons[i].getButtonState() == 0)
                {                                       //If that square has not been played, perform the play and
                    buttons[i].setValue(turnPlayer);    //increment turn to next player.  If it has already been played
                                                        //hold turn at current player and print error to status bar.

                    turnPlayer%=2;   //Mod turnPlayer by 2 to get a result of 0 or 1, and then add 1 (since I had
                    turnPlayer++;    //foolishly set everything up already to recognize 1/2 as valid players)

                    winner=CheckBoardCondition.checkWinCondition(getBoardState());
                    if(winner!=0) {
                       showWinDialog(winner);
                    } else if(CheckBoardCondition.checkDrawCondition(getBoardState())) {
                        showDrawDialog();
                    } else {
                        setStatus(String.format("Player %d, your turn.",turnPlayer));
                    }
                } else {
                    setStatus("Invalid selection, try again.");
                }
            }
        }
    }

    public void resetBoardState(XOButton[] buttons)
    {
        for(int i=0;i<buttons.length;i++) {
            buttons[i].setValue((byte)0);
        }
        turnPlayer=1;
        winner=0;
        setStatus("Welcome to Tic Tac Toe!  Player 1, your turn.");
    }

    public void setStatus(String newStatus)
    {
        statusLabel.setText(newStatus);
    }

    public void showWinDialog(int winner) {
        setStatus(String.format("Player %d Wins!!!", winner));

        int confirm=JOptionPane.showOptionDialog(null, String.format("Player %d Wins!!!\nWould you " +
                        "like to play again?", winner),String.format("Player %d Wins!", winner),
                JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null, null);

        if(confirm!=1) { //showOptionDialog returns 0 for yes and 1 for no
            resetBoardState(buttons); //if yes, reset board state
        } else {
            System.exit(0);  //if no, exit program
        }
    }

    public void showDrawDialog() {
        setStatus("The game is a draw!!!");

        int confirm=JOptionPane.showOptionDialog(null, String.format("The game is a draw!!!\nWould you " +
                        "like to play again?"),String.format("Game Draw!"), JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,null,null, null);

        if(confirm!=1) { //showOptionDialog returns 0 for yes and 1 for no
            resetBoardState(buttons); //if yes, reset board state
        } else {
            System.exit(0);  //if no, exit program
        }
    }

    public byte[] getBoardState() {
        byte[] boardState=new byte[buttons.length];

        for(int i=0;i<buttons.length;i++) {
            boardState[i]=buttons[i].getButtonState();
        }

        return boardState;
    }
}



