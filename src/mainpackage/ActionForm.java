package mainpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import forms.mantenimiento.consultar_ceramico;

public class ActionForm extends ViewForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	// constructor
	public ActionForm() {
		super();
		menuActions();
	}
	
	// register menu events
	public void menuActions() {
		
		sm_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action_closeprogram();
			}
		});
		
		sm_consultar_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action_mantenimiento_consultar(e);
			}
		});
		
		
		
	}
	
	
	//implement actions event
	void action_mantenimiento_consultar(ActionEvent e) {
		JDialog midialog = new consultar_ceramico();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
		
	}
	
	void action_closeprogram() {
		this.dispose();
	}
	
	
}
