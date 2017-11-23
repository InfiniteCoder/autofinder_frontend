package cf.autofinder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;

public class AddFoundVehicle {

	private JFrame frmAddFoundVehicle;
	private JTextField txtChassisNumber;
	private JTextField txtLicenseNumber;
	private JTextField txtRtoNumber;
	private JTextField txtMobileNumber;
	private JButton btnOk,btnClear;


	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public AddFoundVehicle() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmAddFoundVehicle = new JFrame();
		frmAddFoundVehicle.setBackground(Color.WHITE);
		frmAddFoundVehicle.setFont(new Font("Dialog", Font.BOLD, 12));
		frmAddFoundVehicle.setTitle("Add Found Vehicle");
		frmAddFoundVehicle.setBounds(100, 100, 549, 240);
		//frmAddFoundVehicle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddFoundVehicle.getContentPane().setLayout(new MigLayout("", "[grow,fill][grow,fill]", "[][][][][][]"));


		JLabel lblChassisNumber = new JLabel("Chassis Number");
		lblChassisNumber.setFont(new Font("Dialog", Font.BOLD, 20));
		frmAddFoundVehicle.getContentPane().add(lblChassisNumber, "cell 0 1,alignx trailing");

		txtChassisNumber = new JTextField();
		txtChassisNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddFoundVehicle.getContentPane().add(txtChassisNumber, "cell 1 1,growx");
		txtChassisNumber.setColumns(10);

		JLabel lblLicenseNumber = new JLabel("License Number");
		lblLicenseNumber.setFont(new Font("Dialog", Font.BOLD, 20));
		frmAddFoundVehicle.getContentPane().add(lblLicenseNumber, "cell 0 2,alignx trailing");

		txtLicenseNumber = new JTextField();
		txtLicenseNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddFoundVehicle.getContentPane().add(txtLicenseNumber, "cell 1 2,growx");
		txtLicenseNumber.setColumns(10);

		JLabel lblRtoOffice = new JLabel("RTO Office");
		lblRtoOffice.setFont(new Font("Dialog", Font.BOLD, 20));
		frmAddFoundVehicle.getContentPane().add(lblRtoOffice, "cell 0 3,alignx trailing");

		txtRtoNumber = new JTextField();
		txtRtoNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddFoundVehicle.getContentPane().add(txtRtoNumber, "cell 1 3,growx");
		txtRtoNumber.setColumns(10);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Dialog", Font.BOLD, 20));
		frmAddFoundVehicle.getContentPane().add(lblMobileNumber, "cell 0 4,alignx trailing");

		txtMobileNumber = new JTextField();
		txtMobileNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddFoundVehicle.getContentPane().add(txtMobileNumber, "cell 1 4,growx");
		txtMobileNumber.setColumns(10);

		btnOk = new JButton("OK");

		frmAddFoundVehicle.getContentPane().add(btnOk, "cell 0 5");

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtChassisNumber.setText("");
				txtLicenseNumber.setText("");;
				txtRtoNumber.setText("");;
				txtMobileNumber.setText("");;
				
			}
		});
		frmAddFoundVehicle.getContentPane().add(btnClear, "cell 1 5,growx");
	}

	public void addOkListener(ActionListener al){
		this.btnOk.addActionListener(al);
	}

	public void setVisible(boolean value){
		this.frmAddFoundVehicle.setVisible(value);
	}

	public FoundVehicle getData(){
		return new FoundVehicle(this.txtChassisNumber.getText(),this.txtLicenseNumber.getText(),this.txtRtoNumber.getText());
	}

	public Long getMobileNumber(){
		return Long.valueOf(this.txtMobileNumber.getText());
	}
	
}
