package mainpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import forms.mantenimiento.FormConsultarCera;
import forms.mantenimiento.FormListarCera;
import forms.mantenimiento.FormModificarCera;

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
		
		sm_modificar_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action_mantenimiento_modificar(e);
			}
		});
		
		sm_listar_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action_mantenimiento_listar(e);
			}
		});
		
		
		
	}
	
	
	//implement actions event
	void action_mantenimiento_consultar(ActionEvent e) {
		JDialog midialog = new FormConsultarCera();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
		
	}
	
	//implement actions event
	void action_mantenimiento_modificar(ActionEvent e) {
		JDialog midialog = new FormModificarCera();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
		
	}

	//implement actions event
	void action_mantenimiento_listar(ActionEvent e) {
		JDialog midialog = new FormListarCera();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
		
	}
	
	
	
	void action_closeprogram() {
		this.dispose();
	}
	
	
}
