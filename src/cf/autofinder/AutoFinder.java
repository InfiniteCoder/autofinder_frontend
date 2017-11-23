package cf.autofinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.commons.io.IOUtils;
import org.jfree.ui.RefineryUtilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AutoFinder {
	AddLostVehicle windowLostVehicle;
	AddFoundVehicle windowFoundVehicle;
	Otp windowOtpLost;
	Otp windowOtpFound;
	LostVehicle lostVehicle;
	FoundVehicle foundVehicle;
	ObjectMapper mapper;
	long adminMobileNumber;
	MainWindow mainWindow;

	AutoFinder() throws IOException{
		//create ObjectMapper
		mapper = new ObjectMapper();

		//create a main window

		mainWindow = new MainWindow();
		mainWindow.setVisible(true);

		mainWindow.setAnalysisListener(new AnalysisListener());
		mainWindow.setFoundListener(new FoundBtnListener());
		mainWindow.setLostListener(new LostBtnListener());



	}

	public static void main(String[] args) throws IOException {
		new AutoFinder();
	}

	class LostBtnListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			//create a AddLostVehicle window
			windowLostVehicle = new AddLostVehicle();
			windowLostVehicle.setVisible(true);
			windowLostVehicle.addOkListener(new LostListener());
		}

	}

	class FoundBtnListener implements ActionListener {

		
		public void actionPerformed(ActionEvent e)  {
			//create AddFoundVehicle window
			try {
				windowFoundVehicle = new AddFoundVehicle();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			windowFoundVehicle.setVisible(true);
			windowFoundVehicle.addOkListener(new FoundListener());
		}

	}

	
	class LostListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			System.out.println("waiting for vehicle data entry");
			//get vehicle details
			boolean mob_flag=false;
			lostVehicle = windowLostVehicle.getdata();
			String mob_number=lostVehicle.getMobileNumber().toString();
			String pincode=lostVehicle.getLostPincode().toString();
			Pattern p1=Pattern.compile("(0|91)?[7-9][0-9]{9}");
			Pattern p2=Pattern.compile("[0-9]{6}");
			Matcher m1=p1.matcher(mob_number);
			Matcher m2=p2.matcher(pincode);
			if(m1.find()&&m1.group().equals(mob_number) && (m2.find()&&m2.group().equals(pincode)) )
			{
				mob_flag=true;
			}	
			else
				JOptionPane.showMessageDialog(null, "Data Invalid");
				
				
			
			if(mob_flag){
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						try{
							URL url = new URL("https://autofinder.cf:5001/sendotp?mobileNumber="+lostVehicle.getMobileNumber());
							java.io.InputStream is = url.openStream();
							String myString = IOUtils.toString(is, "UTF-8");
							is.close();
							System.out.println(myString);
						}
						catch(Exception ex){
							System.out.println(ex);
						}
					}
				});  
				t1.start();
				//hide this window
				windowLostVehicle.setVisible(false);
				//show otp window
				windowOtpLost = new Otp();
				windowOtpLost.setVisible(true);
				windowOtpLost.setOkListener(new LostOtpListener());

			}
			

		}
	}

	class LostOtpListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			//read otp from user
			System.out.println("getting otp");
			int userOtp = windowOtpLost.getOtp();

			//try to add lost vehicle to database
			try{
				URL url = new URL("https://autofinder.cf:5001/addlost?chassisNumber="+lostVehicle.getChassisNumber()+"&licenseNumber="+lostVehicle.getLicenseNumber()+"&mobileNumber="+lostVehicle.getMobileNumber()+"&model="+lostVehicle.getModel()+"&company="+lostVehicle.getCompany()+"&lostPincode="+lostVehicle.getLostPincode()+"&otp="+userOtp);
				java.io.InputStream is = url.openStream();
				String myString = IOUtils.toString(is, "UTF-8");
				is.close();
				System.out.println(myString);
				//close window
				windowOtpLost.setVisible(false);
			}
			
			
			catch(Exception ex){
				System.out.println(ex);
			}
		}
	}

	class FoundListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){


			//get vehicle details
			foundVehicle = windowFoundVehicle.getData();
			adminMobileNumber = windowFoundVehicle.getMobileNumber();

			//send otp, in different thread to avoid lag
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					try{
						URL url = new URL("https://autofinder.cf:5001/sendotp?mobileNumber="+adminMobileNumber);
						java.io.InputStream is = url.openStream();
						String myString = IOUtils.toString(is, "UTF-8");
						is.close();
						System.out.println(myString);
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
			});  
			t1.start();

			//hide this window
			windowFoundVehicle.setVisible(false);

			//show otp window
			windowOtpFound = new Otp();
			windowOtpFound.setOkListener(new FoundOtpListener());
			windowOtpFound.setVisible(true);
		}
	}

	class FoundOtpListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			//read otp from user
			System.out.println("getting otp");
			int userOtp = windowOtpFound.getOtp();

			//try to add found vehicle to database
			try{
				URL url = new URL("https://autofinder.cf:5001/addfound?chassisNumber="+foundVehicle.getChassisNumber()+"&licenseNumber="+foundVehicle.getLicenseNumber()+"&foundRtoOffice="+foundVehicle.getFoundRtoOffice().replaceAll(" ", "\\+")+"&mobileNumber="+adminMobileNumber+"&otp="+userOtp);
				java.io.InputStream is = url.openStream();
				String addFoundResult = IOUtils.toString(is, "UTF-8");
				is.close();
				System.out.println(addFoundResult);

				//check if vehicle in lost vehicle list
				LostVehicle obj = mapper.readValue(new URL("https://autofinder.cf:5001/searchlost?chassisNumber="+foundVehicle.getChassisNumber()), LostVehicle.class);

				if(obj!=null && addFoundResult.equals("Vehicle added to found database"))
				{
					//notify owner that vehicle has been found
					try{
						URL urlNotify = new URL("https://autofinder.cf:5001/notify?mobileNumber="+obj.getMobileNumber()+"&licenseNumber="+obj.getLicenseNumber()+"&rtoOffice="+foundVehicle.getFoundRtoOffice().replaceAll(" ", "\\+"));
						java.io.InputStream isNotify = urlNotify.openStream();
						String notifyResult = IOUtils.toString(isNotify, "UTF-8");
						isNotify.close();
						System.out.println(notifyResult);
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
				//close window
				windowOtpFound.setVisible(false);
			}
			catch(Exception ex){
				System.out.println(ex);
				System.exit(1);
			}
		}
	}

	class AnalysisListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			try {

				TypeReference<List<CountVehicle>> listCountVehicle = new TypeReference<List<CountVehicle>>() {
				};
				PieChart.list = mapper.readValue(new URL("https://autofinder.cf:5001/findcount"), listCountVehicle);

			} catch (Exception ex) {
				System.out.println(ex.toString());
			}

			PieChart demo;
			try {
				demo = new PieChart("Lost Vehicles by Location");
				demo.pack();
				RefineryUtilities.centerFrameOnScreen(demo);
				demo.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}
}

