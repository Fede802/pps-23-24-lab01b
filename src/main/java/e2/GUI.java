package e2;



import e2.utils.Pair;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton, Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size, int minesToPlace) {
        this.logics = new LogicsImpl(size,minesToPlace);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            ClickResult clickResult = this.logics.clickCell(pos);
            boolean aMineWasFound = clickResult == ClickResult.LOSE;//this.logics.hasMine(pos); // call the logic here to tell it that cell at 'pos' has been seleced
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
                System.exit(0);
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = clickResult == ClickResult.WIN; // call the logic here to ask if there is victory
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (e.getButton() == MouseEvent.BUTTON3 && bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    //todo what happen if position is invalid? invalid position or invalid button state

                    logics.toggleFlag(pos);

//                    bt.setText(""+logics.numberOfMineAround(pos));
//                    bt.setEnabled(false);
//                    if(!logics.hasMineAround(pos)){
//                        System.out.println("yes");
//
//                    }else{
//                        System.out.println("no");
//                    }
                    // call the logic here to put/remove a flag
                }
                drawBoard(); 
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	for (var entry: this.buttons.entrySet()) {
            if(this.logics.isMineCell(entry.getValue())){
//                entry.getKey().setFont(new Font(Font.SERIF,Font.PLAIN,30));
                entry.getKey().setText("*");
                entry.getKey().setEnabled(false);
            }
            // call the logic here
            // if this button is a mine, draw it "*"
            // disable the button
    	}
    }

    private void drawBoard() {
        for (var entry: this.buttons.entrySet()) {
            if(this.logics.isCellClicked(entry.getValue()) && !this.logics.isMineCell(entry.getValue())){
                entry.getKey().setText(String.valueOf(this.logics.numberOfMinesAround(entry.getValue())));
                entry.getKey().setEnabled(false);
            }else if(this.logics.isCellFlagged(entry.getValue())){
                entry.getKey().setText("F");
            }
            // call the logic here
            // if this button is a cell with counter, put the number
            // if this button has a flag, put the flag
    	}
    }
    
}
