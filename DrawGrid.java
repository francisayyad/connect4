/**
 * Connect 4 computer
 *
 * @author (Francis Ayyad)
 * @version (14/7/19)
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DrawGrid {
    private JFrame frame;

    public DrawGrid() {
        frame = new JFrame("DrawGrid");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new MultiDraw(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new DrawGrid();
    }

    public static class MultiDraw extends JPanel  implements MouseListener {
        int startX = 10;
        int startY = 10;
        int cellWidth = 40;
        int turn = 2;
        int rows = 6;
        int cols = 7;
        int[] colssgrid = {5,5,5,5,5,5,5,5};
        Color[][] grid = new Color[rows][cols];
        public MultiDraw(Dimension dimension) {
            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            //1. initialize array here
            int x = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                   grid[row][col] = new Color (255,255,255);
                }
            }
            
            
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            g2.setColor(new Color(0, 0, 255)); //color of background
            g2.fillRect(0,0,d.width,d.height);
            startX = 0;
            startY = 0;

            //2) draw grid here
            for (int rows = 0; rows < grid.length; rows++) {
                for (int col = 0; col < grid[0].length; col++) {
                    g2.setColor(grid[rows][col]);
                    g2.fillOval(startX,startY,cellWidth,cellWidth); 
                    startX = startX +cellWidth;
                }
                startX = 0;
                startY = startY + cellWidth;
            }

            g2.setColor(new Color(255, 255, 255)); //empty spaces
            
            //changes turns
            // use of modulus helps to let red go on event urns and yellow on odd. 
                if(turn % 2 == 0){
                    g2.drawString("Red's Turn",400,20);
                }
                else{
                    g2.drawString("Yellow's Turn",400,20);
                }
                //end the game
                System.out.println("Click away from grid to end the game");
    

                
        }

        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int xSpot = x/cellWidth;
            int ySpot = y/cellWidth;
            
            
                //System.out.println(x + " " + xSpot + " " + y + " " + ySpot + " " + colss[0]); 
                   
                   
                // method that repaints the grid, allows the circels stackup from the bottom floor. 
                if(turn % 2 == 0){
                          grid[colssgrid[xSpot]][xSpot] = new Color (255,0,0);
                       
                    }
                    else {
                          grid[colssgrid[xSpot]][xSpot] = new Color (255,255,0);
                       
                    }
                colssgrid[xSpot] -=1;
                if(xSpot > 6 || ySpot > 5){
                    for (int rows = 0; rows < grid.length; rows++) {
                        for (int col = 0; col < grid[0].length; col++) {
                            grid[rows][col] = new Color (255,255,255);
                         }
                     }
                     colssgrid = new int[]{5,5,5,5,5,5,5,5};
                }
            turn++;
            repaint();
        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseClicked(MouseEvent e) {

        }
    }
}