import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
@SuppressWarnings("serial")
public class hello extends JFrame {
    private JLabel comment = new JLabel("Click:");
    private int score = 0;

    private String randomColor;
    JLabel prompt1 = new JLabel("Start the game!");

    public hello() {
        super("Guess my real background?");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);

        
       Border border = BorderFactory.createLineBorder(Color.BLACK, 2, false);

        JButton blueButton = new JButton("Blue");
        blueButton.setBackground(Color.blue);
        blueButton.setForeground(Color.WHITE);
        blueButton.setPreferredSize(new Dimension(80,25));
        blueButton.setBorder(border);
        JButton greenButton = new JButton("Green");
        greenButton.setBackground(Color.green);
        greenButton.setPreferredSize(new Dimension(80,25));
        greenButton.setBorder(border);
        JButton pinkButton = new JButton("Pink");
        pinkButton.setBackground(Color.pink);
        pinkButton.setPreferredSize(new Dimension(80,25));
        pinkButton.setBorder(border);

        


        // content pane
        Container c = getContentPane();
        setLayout(new FlowLayout());

        // adding component to the pane
        comment.setPreferredSize(new Dimension(80,25));
        c.add(comment);
        c.add(blueButton);
        c.add(greenButton);
        c.add(pinkButton);
        c.add(prompt1);


        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

        initializecolor();


        // creating the handler
        blueColorHandler bhandler = new blueColorHandler(); // instantiate new object
        blueButton.addActionListener(bhandler); // add event listener

        greenButtonHandler ghandler = new greenButtonHandler();
        greenButton.addActionListener(ghandler);

        pinkButtonHandler phandler = new pinkButtonHandler();
        pinkButton.addActionListener(phandler);
    }

    private void initializecolor() {
    String[] colors = {"#0000CD", "#FFC0CB", "#008000"};
    int randColor = new Random().nextInt(colors.length);
    randomColor = colors[randColor];
    getContentPane().setBackground(Color.decode(colors[randColor]));
    
        
    }


    class greenButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(randomColor=="#008000") {
                    score+=3;
                    prompt1.setText("your score is "+ score);
                    comment.setText("Right Choice");
                    initializecolor();
                    return;
                }
                else{
                    score -= 1;
                    prompt1.setText("your score is "+ score);
                    comment.setText("Wrong Choice!");
                    getContentPane().setBackground(Color.RED);
                }
            } catch (NumberFormatException ex) {
                comment.setText("");
            }
            
        }
    }

    class pinkButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(randomColor=="#FFC0CB") {
                    score+=3;
                    prompt1.setText("your score is "+ score);
                    comment.setText("Right Choice");
                    initializecolor();
                    return;
                }
                else{
                    score -=1;
                    prompt1.setText("your score is "+ score);
                    comment.setText("Wrong Choice!");
                    getContentPane().setBackground(Color.RED);
                }
            } catch (NumberFormatException ex) {
                comment.setText("");
            }

        }
    }

    class blueColorHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(randomColor=="#0000CD") {
                    score+=3;
                    prompt1.setText("your score is "+ score);
                    comment.setText("Right Choice");
                    initializecolor();
                    return;
                }
                else{
                    score -=1;
                    prompt1.setText("your score is "+ score);
                    comment.setText("Wrong Choice!");
                    getContentPane().setBackground(Color.RED);
                }
            } catch (NumberFormatException ex) {
                comment.setText("");
            }
        }

    }

    

    public static void main(String args[]) {
        new hello();

    }
}