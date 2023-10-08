package forms.config;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.DataConfig;
import net.miginfocom.swing.MigLayout;

public class FormConfigurarCantOp extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JButton cerrar;
	protected JButton guardar;
	protected JTextField textFieldCantidadOptima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormConfigurarCantOp dialog = new FormConfigurarCantOp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormConfigurarCantOp() {
		setResizable(false);
		setBounds(100, 100, 401, 123);
		getContentPane().setLayout(new MigLayout("gapx 10px, gapy 10px", "[100px,left][50px,grow][100px,fill]", "[][][]"));
		{
			JLabel labelDescription = new JLabel("Cantidad optima de unidades vendidas");
			getContentPane().add(labelDescription, "cell 0 0,alignx trailing");
		}
		
		{
			textFieldCantidadOptima = new JTextField();
			getContentPane().add(textFieldCantidadOptima, "cell 1 0,growx");
		}
		
		{
			guardar = new JButton("Aceptar");
			guardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveJDialog(e);
				}
			});
			getContentPane().add(guardar, "cell 2 0");
		}
		
		cerrar = new JButton("Cancelar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeJDialog();
			}
		});
		
		getContentPane().add(cerrar, "cell 2 1");
		
		setDefaultValues();
		
	}
	
	public void setDefaultValues() {
		
		textFieldCantidadOptima.setText(Integer.toString(DataConfig.cantidadOptima));
		
	}
	
	public void saveJDialog(ActionEvent e) {

		DataConfig.cantidadOptima = Integer.parseInt(textFieldCantidadOptima.getText());
		
		dispose();
		
	}
	
	public void closeJDialog() {
		dispose();
	}

}
