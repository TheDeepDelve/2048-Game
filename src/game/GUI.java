package game;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.*;
public class GUI {

    Game game;
    int frameHeight =394;
    int frameWidth=328;
    int gameBoardSize=296;
    int marginSize=16;
    int high;
    Color backgroundColor=new Color(255,255,125);
    Font largeFeedbackFont=new Font("SanSerif",0,40);
    Font smallFeedbackFont=new Font("SanSerif",0,20);
    JLabel scoreLabel;
    JLabel highScoreLabel;

    myFrame frame;

    Map numberTiles;
    GameBoard gb;
    public GUI(){
        game=new Game();
        frame=new myFrame();
        frame.setFocusable(true);
        frame.addKeyListener(new myFrame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadNumberTiles();
        gb =new GameBoard();
        //gb.setFocusable(true);

        JPanel northPanel=new JPanel();
        northPanel.setLayout(new GridLayout());
        northPanel.setPreferredSize(new Dimension(frameWidth,82));

        JLabel gameLabel=new JLabel("2048",SwingConstants.CENTER);
        gameLabel.setFont(new Font("Serif",Font.BOLD,20));
        northPanel.add(gameLabel);
        scoreLabel=new JLabel("<html>Score:<br>0</html>",SwingConstants.CENTER);
        northPanel.add(scoreLabel);
        highScoreLabel=new JLabel("<html>High Score:<br>0</html>",SwingConstants.CENTER);
        northPanel.add(highScoreLabel);

        northPanel.setBackground(backgroundColor);

        JPanel westBuffer=new JPanel();
        westBuffer.setPreferredSize(new Dimension(marginSize,gameBoardSize));
        westBuffer.setBackground(backgroundColor);

        JPanel eastBuffer=new JPanel();
        eastBuffer.setPreferredSize(new Dimension(marginSize,gameBoardSize));
        eastBuffer.setBackground(backgroundColor);

        JPanel southBuffer=new JPanel();
        southBuffer.setPreferredSize(new Dimension(frameWidth,marginSize));
        southBuffer.setBackground(backgroundColor);


        frame.getContentPane().add(northPanel,BorderLayout.NORTH);
        frame.getContentPane().add(westBuffer,BorderLayout.WEST);
        frame.getContentPane().add(eastBuffer,BorderLayout.EAST);
        frame.getContentPane().add(southBuffer,BorderLayout.SOUTH);
        frame.getContentPane().add(gb,BorderLayout.CENTER);

        frame.getContentPane().setPreferredSize(new Dimension(frameWidth,frameHeight));
        frame.pack();
        frame.setVisible(true);
    }
    private void loadNumberTiles(){
        numberTiles=new Hashtable();
        ClassLoader cldr=this.getClass().getClassLoader();
        URL url0000=cldr.getResource("img/tile0 (2).png");
        URL url0001=cldr.getResource("img/tile1 (2).png");
        URL url0002=cldr.getResource("img/tile2 (2).png");
        URL url0003=cldr.getResource("img/tile3 (2).png");
        URL url0004=cldr.getResource("img/tile4 (2).png");
        URL url0005=cldr.getResource("img/tile5 (2).png");
        URL url0006=cldr.getResource("img/tile6 (2).png");
        URL url0007=cldr.getResource("img/tile7 (2).png");
        URL url0008=cldr.getResource("img/tile8 (2).png");
        URL url0009=cldr.getResource("img/tile9 (2).png");
        URL url0010=cldr.getResource("img/tile10 (2).png");
        URL url0011=cldr.getResource("img/tile11 (2).png");
        numberTiles.put(0,new ImageIcon(url0000));
        numberTiles.put(2,new ImageIcon(url0001));
        numberTiles.put(4,new ImageIcon(url0002));
        numberTiles.put(8,new ImageIcon(url0003));
        numberTiles.put(16,new ImageIcon(url0004));
        numberTiles.put(32,new ImageIcon(url0005));
        numberTiles.put(64,new ImageIcon(url0006));
        numberTiles.put(128,new ImageIcon(url0007));
        numberTiles.put(256,new ImageIcon(url0008));
        numberTiles.put(512,new ImageIcon(url0009));
        numberTiles.put(1024,new ImageIcon(url0010));
        numberTiles.put(2048,new ImageIcon(url0011));


    }
    class GameBoard extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            g.setColor(new Color(20,20,20));
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            int[][] board=game.getGameBoard();
            for(int y=1;y<5;y++){
                for(int x=1;x<5;x++){
                    int X=(8 * x)+(64 * (x-1));
                    int Y=(8 * y)+(64 *(y-1));
                    int thisNumber=board[y-1][x-1];
                    if(numberTiles.containsKey(thisNumber)){
                        ImageIcon thisTile=(ImageIcon)numberTiles.get(thisNumber);
                        thisTile.paintIcon(this,g,X,Y);
                    }



                }
            }
        }


    }
    class WinBoard extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            g.setColor(new Color(20,20,20));
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setFont(largeFeedbackFont);
            g.setColor(new Color(0,80,0));
            g.drawString("You Win!",20,40);
            g.setFont(smallFeedbackFont);
            g.setColor(new Color(255,255,255));
            g.drawString("Press enter to play again",20,70);
        }
    }
    class LooseBoard extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            g.setColor(new Color(20,20,20));
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setFont(largeFeedbackFont);
            g.setColor(new Color(200,0,0));
            g.drawString("You Lose!",20,40);
            g.setFont(smallFeedbackFont);
            g.setColor(new Color(255,255,255));
            g.drawString("Press enter to try  again",20,70);

        }
    }
    class myFrame extends JFrame implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e){

        }
        public void keyReleased(KeyEvent e){
            int key=e.getKeyCode();
            if(game.gameState()==GameState.CONTINUE){
                if(key==KeyEvent.VK_UP){
                    System.out.println("up key pressed..");
                    game.pushUp();
                    game.addNewNumbers();
                    game.checkState();
                    gb.repaint();
                    updateScore();
                    updateHighScore();

                }
                else if(key==KeyEvent.VK_DOWN){
                    System.out.println("down key pressed..");
                    game.pushDown();
                    game.addNewNumbers();
                    game.checkState();
                    gb.repaint();
                    updateScore();
                    updateHighScore();

                }
                else if(key==KeyEvent.VK_LEFT){
                    System.out.println("left key pressed..");
                    game.pushLeft();
                    game.addNewNumbers();
                    game.checkState();
                    gb.repaint();
                    updateScore();
                    updateHighScore();

                }
                else if(key==KeyEvent.VK_RIGHT){
                    System.out.println("right key pressed..");
                    game.pushRight();
                    game.addNewNumbers();
                    game.checkState();
                    gb.repaint();
                    updateScore();
                    updateHighScore();

                }
                GameState gs=game.gameState();
                if(gs==GameState.LOSE){
                    frame.getContentPane().remove(gb);
                    frame.getContentPane().add(new LooseBoard(),BorderLayout.CENTER);
                    frame.getContentPane().invalidate();
                    frame.getContentPane().validate();
                }else if(gs==GameState.WIN){
                    frame.getContentPane().remove(gb);
                    frame.getContentPane().add(new WinBoard(),BorderLayout.CENTER);
                    frame.getContentPane().invalidate();
                    frame.getContentPane().validate();
                }
            }
            else{
                if(key==KeyEvent.VK_ENTER){
                    game=new Game();
                    frame.getContentPane().remove(((BorderLayout)getLayout()).getLayoutComponent(BorderLayout.CENTER));
                    frame.getContentPane().add(gb);
                    gb.repaint();
                    frame.getContentPane().invalidate();
                    frame.getContentPane().validate();
                }
            }
//            GameState gs=game.gameState();
//            if(gs==GameState.CONTINUE){
//                System.out.println("continuinggame..");
//
//            }
//            else if(gs==GameState.WIN){
//                System.out.println("Game over! User Wins");
//            }
//            else{
//                System.out.println("Game over!user lose.");
//            }
        }
        public void keyTyped(KeyEvent e){

        }

    }
    public void updateScore(){
        scoreLabel.setText("<html>Score:<br>"+game.getScore()+"</html>");
    }
    public void updateHighScore(){
        if(game.getScore() > high){
            game.highScore=game.getScore();
            high=game.getHighScore();
        }
        highScoreLabel.setText("<html>High Score:<br>"+high+"</html>");
    }
}
