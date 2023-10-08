package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import forms.mantenimiento.FormConsultarCera;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class ViewForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	
	// block menu archivo
	protected JMenuItem m_archivo;
	protected JMenuItem sm_salir;
	
	// block menu mantenimiento
	protected JMenuItem m_mantenimiento;
	protected JMenuItem sm_consultar_c;
	protected JMenuItem sm_modificar_c;
	protected JMenuItem sm_listar_c;
	
	// block menu ventas
	protected JMenuItem m_ventas;
	protected JMenuItem sm_vender;
	protected JMenuItem sm_generar_r;
	
	// block menu configuracion
	protected JMenuItem m_config;
	protected JMenuItem sm_config_desc;
	protected JMenuItem sm_config_obs;
	protected JMenuItem sm_config_cant_op;
	protected JMenuItem sm_config_cuo_dia;
	
	// block menu ayuda
	protected JMenuItem m_ayuda;
	protected JMenuItem sm_cercade;
	protected JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public ViewForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		m_archivo = new JMenu("Archivo");
		menuBar.add(m_archivo);
		
		sm_salir = new JMenuItem("Salir");
		m_archivo.add(sm_salir);
		
		m_mantenimiento = new JMenu("Mantenimiento");
		menuBar.add(m_mantenimiento);
		
		sm_consultar_c = new JMenuItem("Consultar ceramico");
		sm_consultar_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		m_mantenimiento.add(sm_consultar_c);
		
		sm_modificar_c = new JMenuItem("Modificar ceramico");
		m_mantenimiento.add(sm_modificar_c);
		
		sm_listar_c = new JMenuItem("Listar ceramicos");
		m_mantenimiento.add(sm_listar_c);
		
		m_ventas = new JMenu("Ventas");
		menuBar.add(m_ventas);
		
		sm_vender = new JMenuItem("Vender");
		m_ventas.add(sm_vender);
		
		sm_generar_r = new JMenuItem("Generar Reportes");
		m_ventas.add(sm_generar_r);
		
		m_config = new JMenu("Configuracion");
		menuBar.add(m_config);
		
		sm_config_desc = new JMenuItem("Configuracion descuentos");
		m_config.add(sm_config_desc);
		
		sm_config_obs = new JMenuItem("Configurar Obsequios");
		m_config.add(sm_config_obs);
		
		sm_config_cant_op = new JMenuItem("Configurar Cantidad Optima");
		m_config.add(sm_config_cant_op);
		
		sm_config_cuo_dia = new JMenuItem("Configurar cuota diaria");
		m_config.add(sm_config_cuo_dia);
		
		m_ayuda = new JMenu("Ayuda");
		menuBar.add(m_ayuda);
		
		sm_cercade = new JMenuItem("Acerca de la Tienda");
		m_ayuda.add(sm_cercade);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
        ImageIcon imageIcon = new ImageIcon(MainApplication.class.getResource("/logo.png")); // Reemplaza con la ruta de tu imagen

		
		lblNewLabel = new JLabel(imageIcon);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(196)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addGap(185))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addGap(122))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
