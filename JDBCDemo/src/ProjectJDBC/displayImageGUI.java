package ProjectJDBC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JDBC.connectionProvider;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class displayImageGUI extends JFrame {

	private JPanel contentPane;
	private JTextField Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayImageGUI frame = new displayImageGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public displayImageGUI() {
		setTitle("Display Image");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 218, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setBackground(new Color(255, 255, 255));
		ImageLabel.setBounds(10, 140, 640, 318);
		contentPane.add(ImageLabel);
		
		JButton Button = new JButton("Show Image");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = Field.getText();
				int id = Integer.parseInt(str);
				ImageIcon icon = HelperClass.getImageIconById(id,connectionProvider.getConnection());
				if(icon == null) {
					JOptionPane.showMessageDialog(null, "No image found of your id");
				}else
					ImageLabel.setIcon(icon);
			}
		});
		Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Button.setBounds(316, 10, 155, 43);
		contentPane.add(Button);
		
		Field = new JTextField();
		Field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Field.setBounds(145, 10, 117, 43);
		contentPane.add(Field);
		Field.setColumns(10);
	}
}
