package cf.autofinder;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;

public class AddLostVehicle {

	private JFrame frmAddLostVehicle;
	private JTextField txtChassisNumber;
	private JTextField txtLicenseNumber;
	private JTextField txtMobileNumber;
	private JTextField txtModel;
	private JTextField txtCompany;
	private JTextField txtLostPincode;
	private JButton btnOk;
	private JButton btnClear;


	/**
	 * Create the application.
	 */
	public AddLostVehicle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddLostVehicle = new JFrame();
		frmAddLostVehicle.setTitle("Add Lost Vehicle");
		frmAddLostVehicle.setBounds(100, 100, 867, 336);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddLostVehicle.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow][grow][grow][grow][]"));

		JLabel lblChassisNumber = new JLabel("Chassis Number");
		lblChassisNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(lblChassisNumber, "cell 0 0,alignx trailing");

		txtChassisNumber = new JTextField();
		txtChassisNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(txtChassisNumber, "cell 1 0,growx");
		txtChassisNumber.setColumns(10);

		JLabel lblLicenseNumber = new JLabel("License Number");
		lblLicenseNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(lblLicenseNumber, "cell 0 1,alignx trailing");

		txtLicenseNumber = new JTextField();
		txtLicenseNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(txtLicenseNumber, "cell 1 1,growx");
		txtLicenseNumber.setColumns(10);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(lblMobileNumber, "cell 0 2,alignx trailing");

		txtMobileNumber = new JTextField();
		txtMobileNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(txtMobileNumber, "cell 1 2,growx");
		txtMobileNumber.setColumns(10);

		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(lblModel, "cell 0 3,alignx trailing");

		txtModel = new JTextField();
		txtModel.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(txtModel, "cell 1 3,growx");
		txtModel.setColumns(10);

		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(lblCompany, "cell 0 4,alignx trailing");

		txtCompany = new JTextField();
		txtCompany.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(txtCompany, "cell 1 4,growx");
		txtCompany.setColumns(10);

		JLabel lblLostPincode = new JLabel("Lost Pincode");
		lblLostPincode.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(lblLostPincode, "cell 0 5,alignx trailing");

		txtLostPincode = new JTextField();
		txtLostPincode.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmAddLostVehicle.getContentPane().add(txtLostPincode, "cell 1 5,growx");
		txtLostPincode.setColumns(10);

		btnOk = new JButton("OK");


		frmAddLostVehicle.getContentPane().add(btnOk, "cell 0 6,growx");

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtChassisNumber.setText("");
				txtLicenseNumber.setText("");
				txtMobileNumber.setText("");
				txtModel.setText("");
				txtCompany.setText("");
				txtLostPincode.setText("");;
			}
		});
		frmAddLostVehicle.getContentPane().add(btnClear, "cell 1 6,growx");
	}

	public void addOkListener(ActionListener al){
		btnOk.addActionListener(al);
	}

	public void setVisible(boolean value){
		this.frmAddLostVehicle.setVisible(value);
	}


	public LostVehicle getdata(){
		LostVehicle lv = new LostVehicle(txtChassisNumber.getText(),txtLicenseNumber.getText(),Long.valueOf(this.txtMobileNumber.getText()));
		lv.setModel(this.txtModel.getText());
		lv.setCompany(this.txtCompany.getText());
		lv.setLostPincode(Long.valueOf(this.txtLostPincode.getText()));

		return lv;

	}
}
