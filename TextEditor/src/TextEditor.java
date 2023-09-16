import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener{

	JTextArea textArea; 
	JScrollPane scrollPane;
	JSpinner fontSizeSpinner;
	JLabel fontLabel;   
	JButton fontColorButton; 
	JComboBox fontBox;

	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;




	 TextEditor() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Svs tex editor");
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial",Font.PLAIN,20));	

		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450,450));		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		fontLabel = new JLabel("Font: "); 

		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));

			}

		});

		fontColorButton = new JButton("Color");
		fontColorButton.addActionListener(this);


		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		fontBox = new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Arial");


		// ------- menubar --------

		menuBar = new JMenuBar();
		fileMenu = new JMenu("file");
		openItem = new JMenuItem("open");
		saveItem = new JMenuItem("save");
		exitItem = new JMenuItem("exit");


		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);


		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);



		// ------- menubar --------
		this.setJMenuBar(menuBar);
		this.add(fontLabel);            
		this.add(fontSizeSpinner);
		this.add(fontColorButton);
		this.add(fontBox);
		this.add(scrollPane);
		this.setVisible(true);


	}


	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource()==fontColorButton)	{
			JColorChooser colorChooser = new JColorChooser();

			Color color = colorChooser.showDialog(null,"Choose a color",Color.black);

			textArea.setForeground(color);

		}

		if(e.getSource()==fontBox) {

			textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));

		}

		if(e.getSource()==openItem) {

		}

		if(e.getSource()==saveItem) {

		}

		if(e.getSource()==exitItem) {
	
			System.exit(0);

		}





	}

}










