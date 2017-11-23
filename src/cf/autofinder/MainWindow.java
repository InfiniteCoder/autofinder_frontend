package cf.autofinder;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MainWindow extends JFrame {


	private static final long serialVersionUID = -3886023430374780417L;

	private JPanel contentPane;
	private JButton btnAnalysis,btnAddLostVehicle,btnAddFoundVehicle;

	public MainWindow() {
		setTitle("AutoFinder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 11, 610, 349);
		contentPane.add(lblNewLabel);

		btnAnalysis = new JButton("FIND ANALYSIS");

		btnAnalysis.setBounds(630, 217, 170, 61);
		contentPane.add(btnAnalysis);

		btnAddLostVehicle = new JButton("ADD LOST VEHICLE");
		btnAddLostVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddLostVehicle.setBounds(630, 46, 170, 61);
		contentPane.add(btnAddLostVehicle);
		Image img1 = new ImageIcon(this.getClass().getResource("/Car-2-icon.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/Login-icon.png")).getImage();
		lblNewLabel .setIcon(new ImageIcon(img1));

		btnAddFoundVehicle = new JButton("ADD FOUND VEHICLE");
		btnAddFoundVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddFoundVehicle.setBounds(189, 381, 445, 67);
		contentPane.add(btnAddFoundVehicle);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(656, 363, 156, 110);
		lblNewLabel_1 .setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_1);
	}

	public void setAnalysisListener(ActionListener listener){
		this.btnAnalysis.addActionListener(listener);
	}

	public void setFoundListener(ActionListener listener){
		this.btnAddFoundVehicle.addActionListener(listener);
	}

	public void setLostListener(ActionListener listener){
		this.btnAddLostVehicle.addActionListener(listener);
	}
}
