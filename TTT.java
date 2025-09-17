import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TTT extends JFrame {
    JButton b1[][] = new JButton[3][3];
    char turn = 'X';
    JLabel lab;

    public TTT() {
        setTitle("Tic Tac Toe Game");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lab = new JLabel("Player X turn");
        lab.setHorizontalAlignment(SwingConstants.CENTER);
        add(lab, BorderLayout.NORTH);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,3));

        Font f = new Font("Serif", Font.BOLD, 50);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                b1[i][j] = new JButton("");
                b1[i][j].setFont(f);
                int a = i;
                int b = j;
                b1[i][j].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if(b1[a][b].getText().equals("")){
                            b1[a][b].setText(""+turn);
                            if(win(turn)){
                                lab.setText("Player "+turn+" win");
                                stop();
                            }else if(full()){
                                lab.setText("Draw!!!");
                            }else{
                                if(turn=='X') turn='O'; else turn='X';
                                lab.setText("Player "+turn+" turn");
                            }
                        }
                    }
                });
                p.add(b1[i][j]);
            }
        }

        add(p, BorderLayout.CENTER);

        JButton re = new JButton("Reset");
        re.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                reset();
            }
        });
        add(re, BorderLayout.SOUTH);
    }

    public boolean win(char x){
        for(int i=0;i<3;i++){
            if(b1[i][0].getText().equals(""+x) && b1[i][1].getText().equals(""+x) && b1[i][2].getText().equals(""+x)) return true;
            if(b1[0][i].getText().equals(""+x) && b1[1][i].getText().equals(""+x) && b1[2][i].getText().equals(""+x)) return true;
        }
        if(b1[0][0].getText().equals(""+x) && b1[1][1].getText().equals(""+x) && b1[2][2].getText().equals(""+x)) return true;
        if(b1[0][2].getText().equals(""+x) && b1[1][1].getText().equals(""+x) && b1[2][0].getText().equals(""+x)) return true;
        return false;
    }

    public boolean full(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(b1[i][j].getText().equals("")) return false;
            }
        }
        return true;
    }

    public void stop(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                b1[i][j].setEnabled(false);
            }
        }
    }

    public void reset(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                b1[i][j].setText("");
                b1[i][j].setEnabled(true);
            }
        }
        turn='X';
        lab.setText("Player X turn");
    }

    public static void main(String[] args){
        TTT t = new TTT();
        t.setVisible(true);
    }
}
