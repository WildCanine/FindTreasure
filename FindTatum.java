package findtreasure;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class FindTatum extends JFrame{
	private int r=5;
	  private int c=5;
	  private int s=r*c;
	  private int k=1;
  JLabel[] choiceLabel=new JLabel[s];
  ImageIcon tatum=new ImageIcon("tatum.gif");
  ImageIcon simmons=new ImageIcon("simmons.gif");
  JButton newButton=new JButton();
  int tatumlocation;
  int simmonslocation;
  Random myRandom=new Random();
  
  public static void main(String args[]) {
    new FindTatum().setVisible(true);
  }
  public FindTatum() {
    setTitle("Find the Jayson - Matthew Woodall November 2018");
    setResizable(false);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        exitForm(evt);
      }
    });
    getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints gridConstraints;
    for (int i=0; i<s; i++) {
    choiceLabel[i]=new JLabel();
    }
    for (int j=0; j<r; j++) {
        for (int i=0; i<c; i++) {
            gridConstraints=new GridBagConstraints();
            choiceLabel[c*j+i].setPreferredSize(new Dimension(tatum.getIconWidth(), tatum.getIconHeight()));
            choiceLabel[c*j+i].setOpaque(true);
            choiceLabel[c*j+i].setBackground(Color.BLACK);
            gridConstraints.gridx=i;
            gridConstraints.gridy=j;
            gridConstraints.insets=new Insets(10, 10, 10, 10);
            getContentPane().add(choiceLabel[c*j+i], gridConstraints);
            choiceLabel[c*j+i].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            labelMouseClicked(e);
        }
      });
    }
    }
    newButton.setText("Play Again");
    gridConstraints=new GridBagConstraints();
    gridConstraints.gridx=2;
    gridConstraints.gridy=5;
    gridConstraints.insets=new Insets(10, 10, 10, 10);
    getContentPane().add(newButton, gridConstraints);
    newButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        newButtonActionPerformed(e);
      }
    });
    getContentPane().setBackground(Color.BLACK);
    pack();
    Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int)(0.5*(screenSize.width-getWidth())), (int)(0.5*(screenSize.height-getHeight())), getWidth(), getHeight());
    newButton.doClick();
  }
  
  private void labelMouseClicked(MouseEvent e) {
    Component clickedComponent=e.getComponent();
    
    	int choice;
        for (choice=0; choice<s; choice++) {
          if (clickedComponent==choiceLabel[choice]) {
            break;
          }
        }
        choiceLabel[choice].setBackground(Color.WHITE);
        if (choice==tatumlocation) {
          choiceLabel[choice].setIcon(tatum);
          newButton.setEnabled(true);
          JOptionPane.showMessageDialog(null, "It took you " + k + " shots to win");
        }
        else if(choice==simmonslocation) {
        	choiceLabel[choice].setIcon(simmons);
        	newButton.setEnabled(true);
        	JOptionPane.showMessageDialog(null,"Uh oh, you got injured!");
        	for (int i=0; i<s; i++) {
        	      choiceLabel[i].setIcon(null);
        	      choiceLabel[i].setBackground(Color.GREEN);
        	    }
        	    tatumlocation=myRandom.nextInt(s);
        	    simmonslocation=myRandom.nextInt(s);
        	    newButton.setEnabled(false);
        	    k=k+1;
        }
        else k=k+1;
      }
  private void newButtonActionPerformed(ActionEvent e) {
    for (int i=0; i<s; i++) {
      choiceLabel[i].setIcon(null);
      choiceLabel[i].setBackground(Color.GREEN);
    }
    tatumlocation=myRandom.nextInt(s);
    simmonslocation=myRandom.nextInt(s);
    newButton.setEnabled(false);
    k=1;
  }
  private void exitForm(WindowEvent evt) {
    System.exit(0);
  }
}