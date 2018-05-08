import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;


public class BattleComponent extends JComponent implements ActionListener
{
    private JLabel label = new JLabel( "Attack!" );

    private JFrame frame = new JFrame();


    public BattleComponent()
    {
        JButton button = new JButton( "Click Me" );
        button.addActionListener( this );
        add(button);

        // the panel with the button and text
        /*JPanel panel = new JPanel();
        panel.setBorder( BorderFactory.createEmptyBorder( 30, 30, 10, 30 ) );
        panel.setLayout( new GridLayout( 0, 1 ) );
        panel.add( button );
        panel.add( label );

        // set up the frame and display it
        frame.add( panel, BorderLayout.CENTER );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle( "GUI" );
        frame.pack();
        frame.setVisible( true );*/
    }


    public void actionPerformed( ActionEvent e )
    {

    }


    public void paintComponent( Graphics g )
    {
        Graphics2D g2 = (Graphics2D)g;
        Rectangle r = new Rectangle( 100, 50, 50, 50 );
        g2.setColor( Color.RED );
        g2.fill( r );
        g2.draw( r );
        
    }
}
