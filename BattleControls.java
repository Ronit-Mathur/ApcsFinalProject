import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridLayout;

public class BattleControls extends JPanel
{
	private JLabel label = new JLabel("Fight!");

	private ActionListener attack;
	private ActionListener block;

	public BattleControls(Battle battle) 
	{
		JButton aButton = new JButton("Attack");
		JButton bButton = new JButton("Block");
		attack = new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( !battle.checkEnded() )
				{
					battle.playerAttack();
					System.out.println("Attacked");
					battle.monsterAttack();
				}
				else {
					System.out.println("Not Attacked");
					// TODO: close window
				}
				 //TODO
			}
		};
		aButton.addActionListener(attack);
		block = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Blocked"); //TODO
			}
		};
		bButton.addActionListener(block);
		add(aButton);
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.setLayout(new GridLayout(0, 1));
		this.add(aButton);
		this.add(bButton);
		this.add(label);
	}


}