package mainpackage;

import java.awt.EventQueue;

import com.formdev.flatlaf.FlatLightLaf;

public class MainApplication {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			FlatLightLaf.setup();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActionForm frame = new ActionForm();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
