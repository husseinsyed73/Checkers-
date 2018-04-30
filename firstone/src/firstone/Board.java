



package firstone;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
public class Board  {
	// creating a 2-d array of buttons to add 
	// if we make it nine by nine some would just be off the page and perfect 
			JButton[][] buttons = new JButton[8][8];
			Icon checker = new ImageIcon("C:\\Users\\husse\\OneDrive\\Pictures\\checcker.jpg");
			// creating the second icon object 
			Icon blue_checker = new ImageIcon("C:\\Users\\husse\\OneDrive\\Pictures\\checkerpeice.jpg");
			int x;
	    	int y;
	    	// counter for just keeping track of the last movement 
	    	int counter=-1; 
	    	// finding the checker peices 
	    	// we could just keep one step detection 
	    	// creating a function so we can delete pieces that it skips over 
	    	public void delete_peices(JButton buttons[][],int x_prior,int y_prior,int current_x,int current_y)
	    	{
	    		//testing 
	    		System.out.println(x_prior);
	    		System.out.println(y_prior);
	    		System.out.println(current_x);
	    		System.out.println(current_y);
	    		// first detect if its coming from the left diagonal or the right 
	    		// must compare x and y to see if moving up or down 
	    		if (x_prior==(current_x-2)&&y_prior>current_y)
	    		{
	    			// if it jumped more than one we all ready know it crossed over something 
	    			// removing the prior 
	    			buttons[x_prior+1][y_prior-1].setIcon(null);
	    			System.out.println(x_prior+"     "+y_prior);
	    		}else if (x_prior==(current_x+2)&&y_prior<current_y)
	    		{
	    			buttons[x_prior-1][y_prior+1].setIcon(null);
	    		}
	    		else if (x_prior==(current_x+2)&&y_prior>current_y)
	    		{
	    			buttons[x_prior-1][y_prior-1].setIcon(null);
	    		}
	    		else if (x_prior==(current_x-2)&&y_prior<current_y)
	    		{
	    			buttons[x_prior+1][y_prior+1].setIcon(null);
	    		}
	    		
	    	}
	    	
	    	public void finding_peices(JButton buttons[][],int x, int y)
	    	{
	    		// finding all the surrounding pieces diagonally 
	 
	    		
	    		// testing if one before has a checker 
  		      if ((x>1&&y>1)&&(buttons[x-1][y-1].getIcon()!=null)&&(buttons[x-1][y-1].getIcon()!=buttons[x][y].getIcon()))
  		      {
  		    	  
  		    	  buttons[x-2][y-2].setBackground(Color.YELLOW);
  		    	 
  		    	  
  		    	  
  		      }
  		      if ((x<6&&y<6)&&(buttons[x+1][y+1].getIcon()!=null)&&(buttons[x+1][y+1].getIcon()!=buttons[x][y].getIcon()))
  		      {
  		    	 
  		    	  buttons[x+2][y+2].setBackground(Color.YELLOW);
  		    	  
  		      }
  		      // these still need to be set yet just checking 
  		      if ((x>1&&y<6)&&(buttons[x-1][y+1].getIcon()!=null)&&(buttons[x-1][y+1].getIcon()!=buttons[x][y].getIcon()))
  		      {
  		    	  
  		    	  buttons[x-2][y+2].setBackground(Color.YELLOW);
  		      }
  		      if ((x<6&&y>1)&&(buttons[x+1][y-1].getIcon()!=null)&&(buttons[x+1][y-1].getIcon()!=buttons[x][y].getIcon()))
  		      {
  		    	  
  		    	  buttons[x+2][y-2].setBackground(Color.YELLOW);
  		    	 
  		      }
	    		
	    		
	    	}
	    	
	    	// creating a memory vector so we can go back and delete 
	    	// make a function to go in and clean up 
	    	int array_x[]=new int[1000];
	    	int array_y[]=new int[1000];
	    	// creating a function to check all the buttons in a x formation
	    	// yes bad naming convention for param but lazy should be fine in scope 	
	    	// 2-d arrays should always be passed by reference just to clear the board of the squares
	    		public void clear_board (JButton buttons[][])
	    		{
	    			for(int r = 0; r < 8; r++)
	    		    {
	    		        for(int c = 0; c < 8; c++)
	    		        {
	    		        
	    		        	if (buttons[r][c].getBackground()==Color.YELLOW)
	    		        	{
	    		        		// testing if orginally black or white 
	    		        		if ((r+c)%2!=0)
	    			           buttons[r][c].setBackground(Color.BLACK);
	    		        		else
	    		        		{
	    		        			  buttons[r][c].setBackground(Color.WHITE);
	    		        		}
	    		        			
	    		        	}
	    		        		
	    		            
	    		            
	    		        }
	    		    }
	    	}
	    	
			private class TileListener implements ActionListener
	{
				
	    public void actionPerformed(ActionEvent e)
	    {
	    	
	       
	    	// have to cast assuming jbutton will be entered 
	    	JButton button = (JButton)e.getSource();
	    	// creating testing whether in range and just bringing the checker peice over 
	    	// testing if each button is the source 
	    	for (int i = 0; i < 8; i++) {
	    		  for (int j = 0; j < 8; j++) {
	    		    if( (buttons[i][j] == e.getSource()&&buttons[i][j].getIcon()!= null)|| (buttons[i][j] == e.getSource()&&buttons[i][j].getBackground()==Color.YELLOW) ) { 
	    		    	// we must find the button then also detect whether if has peice or it could just be yellow 
	    		    counter++;
	    		      x=i;
	    		      y=j;
	    		      // sending the last move into memory 
	    		      array_x[counter]=x;
	    		      array_y[counter]=y;
	    		      System.out.println(x+" ,"+y);
	    		     
	    		      // these if state ments create the four yellow swares 
	    		      // setting flags for the max ends of the boards reached 
	    		      
	    		      // creating ifs for the bottom 
	    		      // taking advantage that java is lazy and it will just evaluate the first one 
	    		  
	    		      if ((x>0&&y<7)&&buttons[x-1][y+1].getIcon()==null)
	    		      {
	    		    	 
	    		    	  buttons[x-1][y+1].setBackground(Color.YELLOW);
	    		      }
	    		      if ((x>0&&y>0)&&buttons[x-1][y-1].getIcon()==null)
	    		      {
	    		    	 
	    		    	  buttons[x-1][y-1].setBackground(Color.YELLOW);
	    		      }
	    		      if ((x<7&&y<7)&&buttons[x+1][y+1].getIcon()==null)
	    		      {
	    		    	 
	    		    	  buttons[x+1][y+1].setBackground(Color.YELLOW);
	    		      }
	    		      
	    		      if ((x<7&&y>0)&&buttons[x+1][y-1].getIcon()==null)
	    		      {
	    		    	  
	    		    	  buttons[x+1][y-1].setBackground(Color.YELLOW);
	    		      }
	    		  // click the prior square and make everything else light up 
	    		      // now testing for other checkers around it to see if we can get the yellow move 
	    		      finding_peices(buttons,x,y);
	    		  // now we are going to detect if a yellow sqaure then you can move the peice 
	    		      if (buttons[i][j].getBackground()==Color.YELLOW)
	    		      {
	    		    	  // checking memory for last selection
	    		    	  // and assgining the past back ground 
	    		    	  if (buttons[array_x[counter-1]][array_y[counter-1]].getIcon()==blue_checker)
	    		    		  buttons[i][j].setIcon(blue_checker);
	    		    	  else 
	    		    		  buttons[i][j].setIcon(checker);
	    		    	  // checking memory for the last button selection 
	    		    	  // can use else because only two play pieces
	    		    	  // also set the past equal to null 
	    		    	  
	    		    	 
	    		    	  buttons[array_x[counter-1]][array_y[counter-1]].setIcon(null);
	    		    	  // using the deletion function 
	    		    	  delete_peices(buttons,array_x[counter-1],array_y[counter-1],x,y);
	    		    	  // clearing the yellow 
	    		    	  clear_board(buttons);
	    		    	  
	    		      }
	    		    }
	    		  }
	    		}
	    	
	    	
	    }
	}
	
// creating the grid layout for the checker board
	public void start ()
	{
		
		for(int r = 0; r < 8; r++)
	    {
	        for(int c = 0; c < 8; c++)
	        {
	        
	            buttons[r][c] = new JButton();
	            if ((r+c)%2!=0)
	            {
	           buttons[r][c].setBackground(Color.BLACK);
	           // if not on the third or fourth row replace black for the icon 
	           if (r<3)
	           buttons[r][c].setIcon(checker);
	           if (r>4)
	        	   buttons[r][c].setIcon(blue_checker);
	            }
	            else 
	           buttons[r][c].setBackground(Color.WHITE);
	            
	            
	            buttons[r][c].addActionListener(new TileListener());
	            
	            
	        }
	    }
		// create an instance of a jframe object 
	JPanel panel = new JPanel();
	
	// creating grid layout 
	GridLayout grid = new GridLayout(8,8);
	panel.setLayout(grid);
	// creating a looping to add all 
	for (int x = 0; x<8;x++)
	{
		for (int z = 0; z<8;z++)
		{
			
				 
			 		
			panel.add(buttons[x][z]);
			
		}
	}
	// setting up the graphial user interface 
	panel.setSize(100,80);
	panel.setVisible(true);
    JFrame frame = new JFrame();
    frame.setContentPane(panel);
    frame.setTitle("Checkers for noobies");
    frame.setSize(1000,800);
    frame.setVisible(true);
    
	
	
	}
	
	

	

	
	 
}
