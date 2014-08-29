import java.awt.*;
import javax.swing.*;

class Grid extends JFrame{

  Block[][] grid;

  public Grid(char[][] grid){
    int row = grid.length;
    int column = grid[0].length;

    this.setPreferredSize(new Dimension(row*5+50, column*5+50));

    this.setLayout(new GridLayout(row,column));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();

    this.grid = new Block[grid.length][grid[0].length];

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < column; j++) {
        this.grid[i][j] = new Block('O');
        this.add(this.grid[i][j]);
      }
    }

    this.setVisible(true);
  }

  public void update(int row, int column, char ch) {
    grid[row][column].update(ch);
  }
}

class Block extends JPanel {
  char ch;

  public Block(char ch) {
    this.ch = ch;
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if(ch == 'O')
      g.setColor(Color.BLUE);
    else
      g.setColor(Color.RED);
    g.fillRect(0,0,5,5);
  }

  public void update(char ch) {
    this.ch = ch;
    repaint();
  }
}

class Euler349 {

  public static final int UP = 1;
  public static final int RIGHT = 2;
  public static final int DOWN = 3;
  public static final int LEFT = 4;

  public static void main(String[] arg) throws InterruptedException {
    if(arg.length != 1) {
      System.err.println("Usage: java Euler349 <numMoves>");
      return;
    }

    System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");

    final int MOVES = Integer.parseInt(arg[0]);
    int num = 101;
    
    char[][] grid = new char[num][num];

    for(int i = 0; i < num; i++)
      for(int j = 0; j < num; j++)
        grid[i][j] = 'O';

    Grid g = new Grid(grid);

    int mid = num/2;

    int r = mid;
    int c = mid;

    int direction = UP;

    //System.out.println("MOVES: " + 0);
    //printGrid(grid);

    int ct = 0;

    for(int i = 0; i < MOVES; i++) {
      if(grid[r][c] == 'O') {
        grid[r][c] = 'X';
        g.update(r,c,'X');

        if(direction == UP) {
          c++;
          direction++;
        }
        else if(direction == RIGHT) {
          r++;
          direction++;
        }
        else if(direction == DOWN) {
          c--;
          direction++;
        }
        else if(direction == LEFT) {
          r--;
          direction = UP;
        }
      }
      else {
        grid[r][c] = 'O';
        g.update(r,c,'O');

        if(direction == UP) {
          c--;
          direction = LEFT;
        }
        else if(direction == RIGHT) {
          r--;
          direction--;
        }
        else if(direction == DOWN) {
          c++;
          direction--;
        }
        else if(direction == LEFT) {
          r++;
          direction--;
        }
      }

      Thread.sleep(1);

      //printGrid(grid);
    }


    // Counting number of black tiles
    int count = 0;

    for(int i = 0; i < num; i++)
      for(int j = 0; j < num; j++)
        if(grid[i][j] == 'X')
          count++;

    System.out.println("count: " + count);

  }


  public static void printGrid(char[][] grid) {
    System.out.println();
    
    for(char[] row : grid) {
      for(char column : row)
        System.out.print(column + " ");
      System.out.println();
    }
    
    System.out.println();
  }
}
