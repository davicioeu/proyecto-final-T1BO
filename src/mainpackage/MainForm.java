package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu m_archivo = new JMenu("Archivo");
		menuBar.add(m_archivo);
		
		JMenuItem sm_salir = new JMenuItem("Salir");
		m_archivo.add(sm_salir);
		
		JMenu m_mantenimiento = new JMenu("Mantenimiento");
		menuBar.add(m_mantenimiento);
		
		JMenuItem sm_consultar_c = new JMenuItem("Consultar ceramico");
		m_mantenimiento.add(sm_consultar_c);
		
		JMenuItem sm_modificar_c = new JMenuItem("Modificar ceramico");
		m_mantenimiento.add(sm_modificar_c);
		
		JMenuItem sm_listar_c = new JMenuItem("Listar ceramicos");
		m_mantenimiento.add(sm_listar_c);
		
		JMenu m_ventas = new JMenu("Ventas");
		menuBar.add(m_ventas);
		
		JMenuItem sm_vender = new JMenuItem("Vender");
		m_ventas.add(sm_vender);
		
		JMenuItem sm_generar_r = new JMenuItem("Generar Reportes");
		m_ventas.add(sm_generar_r);
		
		JMenu m_config = new JMenu("Configuracion");
		menuBar.add(m_config);
		
		JMenuItem sm_config_desc = new JMenuItem("Configuracion descuentos");
		m_config.add(sm_config_desc);
		
		JMenuItem sm_config_obs = new JMenuItem("Configurar Obsequios");
		m_config.add(sm_config_obs);
		
		JMenuItem sm_config_cant_op = new JMenuItem("Configurar Cantidad Optima");
		m_config.add(sm_config_cant_op);
		
		JMenuItem sm_config_cuo_dia = new JMenuItem("Configurar cuota diaria");
		m_config.add(sm_config_cuo_dia);
		
		JMenu m_ayuda = new JMenu("Ayuda");
		menuBar.add(m_ayuda);
		
		JMenuItem sm_cercade = new JMenuItem("Acerca de la Tienda");
		m_ayuda.add(sm_cercade);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
