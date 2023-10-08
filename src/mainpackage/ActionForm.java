package mainpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import forms.FormAcercade;
import forms.config.FormConfigurarCantOp;
import forms.config.FormConfigurarCuoDia;
import forms.config.FormConfigurarDesc;
import forms.config.FormConfigurarObs;
import forms.mantenimiento.FormConsultarCera;
import forms.mantenimiento.FormListarCera;
import forms.mantenimiento.FormModificarCera;
import forms.ventas.FormGenerarRepo;
import forms.ventas.FormVender;

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
		
		// event listener close
		sm_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action_closeprogram();
			}
		});
		
		//-------- event listener mantenimiento -------------------------------
		sm_consultar_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_mantenimiento_consultar(e);
			}
		});
		
		sm_modificar_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_mantenimiento_modificar(e);
			}
		});
		
		sm_listar_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_mantenimiento_listar(e);
			}
		});
		

		//-------- event listener configuration---------------------------------
		sm_config_desc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_configuracion_descuento();
			}
		});
		
		sm_config_obs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_configuracion_obsequios();
			}
		});
		
		sm_config_cant_op.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_configuracion_cantidad_optima();
			}
		});
		
		sm_config_cuo_dia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_configuracion_cuota_diaria();
			}
		});
		
		//-------- event listener acercade ---------------------------------
		
		sm_cercade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_acercade();
			}
		});
		
		//-------- events listeners ventas ---------------------------------
		
		sm_vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_vender();
			}
		});
		
		sm_generar_r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showdialog_generar_r();
			}
		});
		
		
	}
	
	void action_closeprogram() {
		this.dispose();
	}
	
	// ---------------------------------------------------------------
	void showdialog_mantenimiento_consultar(ActionEvent e) {
		JDialog midialog = new FormConsultarCera();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
		
	}
	
	void showdialog_mantenimiento_modificar(ActionEvent e) {
		JDialog midialog = new FormModificarCera();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
		
	}

	// ---------------------------------------------------------------
	void showdialog_mantenimiento_listar(ActionEvent e) {
		JDialog midialog = new FormListarCera();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
		
	}
	
	void showdialog_configuracion_descuento() {
		JDialog midialog = new FormConfigurarDesc();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
	}
	
	void showdialog_configuracion_obsequios() {
		JDialog midialog = new FormConfigurarObs();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
	}
	
	void showdialog_configuracion_cantidad_optima() {
		JDialog midialog = new FormConfigurarCantOp();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
	}
	
	void showdialog_configuracion_cuota_diaria() {
		JDialog midialog = new FormConfigurarCuoDia();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
	}
	
	// ---------------------------------------------------------------
	void showdialog_acercade() {
		JDialog midialog = new FormAcercade();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
	}
	
	
	// ---------------------------------------------------------------
	void showdialog_vender() {
		JDialog midialog = new FormVender();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
	}
	
	void showdialog_generar_r() {
		JDialog midialog = new FormGenerarRepo();
		midialog.setLocationRelativeTo(null);
		midialog.setVisible(true);
	}
	
}
