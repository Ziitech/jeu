package vue;


import javax.swing.JLabel;

public class LabelCoord extends JLabel
{

	private static final long serialVersionUID = -2732918615416614352L;
	
	public LabelCoord()
	{
		setFont(getFont().deriveFont (20.0f));
	}

	public void positionLabel() {setBounds(520,700,150,50);}
}