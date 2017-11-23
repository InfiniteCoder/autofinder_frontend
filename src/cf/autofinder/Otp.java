package cf.autofinder;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Otp {

	private JFrame frmEnterOtp;
	private JTextField txtOtp;
	private JButton btnOk;


	/**
	 * Create the application.
	 */
	public Otp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnterOtp = new JFrame();
		frmEnterOtp.setTitle("Enter OTP");
		frmEnterOtp.setBounds(100, 100, 450, 300);
		frmEnterOtp.getContentPane().setLayout(new MigLayout("", "[grow,fill][grow]", "[][]"));

		JLabel lblEnterOtp = new JLabel("Enter OTP");
		lblEnterOtp.setFont(new Font("Dialog", Font.BOLD, 20));
		frmEnterOtp.getContentPane().add(lblEnterOtp, "cell 0 0,alignx trailing");

		txtOtp = new JTextField();
		txtOtp.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmEnterOtp.getContentPane().add(txtOtp, "cell 1 0,growx");
		txtOtp.setColumns(10);

		btnOk = new JButton("OK");

		frmEnterOtp.getContentPane().add(btnOk, "cell 0 1");
	}

	public void setVisible(boolean value){
		this.frmEnterOtp.setVisible(value);
	}

	public void setOkListener(ActionListener al){
		btnOk.addActionListener(al);
	}

	public int getOtp(){
		return Integer.valueOf(txtOtp.getText());
	}
}
