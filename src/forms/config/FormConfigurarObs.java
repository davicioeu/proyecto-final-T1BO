package forms.config;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class FormConfigurarObs extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JTextField textFieldObsequioCantidad1;
	protected JTextField textFieldObsequioCantidad2;
	protected JTextField textFieldObsequioCantidad3;
	protected JButton cerrar;
	protected JButton guardar;
	protected JTextField textFieldTipoObsequio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormConfigurarObs dialog = new FormConfigurarObs();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormConfigurarObs() {
		setResizable(false);
		setBounds(100, 100, 405, 193);
		getContentPane().setLayout(new MigLayout("gapx 10px, gapy 10px", "[100px,left][grow][100px,fill]", "[][][][][][]"));
		{
			JLabel labelTipo = new JLabel("Tipo de obsequio");
			getContentPane().add(labelTipo, "cell 0 0,alignx trailing");
		}
		
		{
			textFieldTipoObsequio = new JTextField();
			getContentPane().add(textFieldTipoObsequio, "cell 1 0,growx");
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
		
		{
			JLabel labelunidades1_5 = new JLabel("1 a 5 unidades");
			getContentPane().add(labelunidades1_5, "cell 0 1,alignx trailing");
		}
		
		{
			textFieldObsequioCantidad1 = new JTextField();
			getContentPane().add(textFieldObsequioCantidad1, "cell 1 1,growx");
		}
		
		cerrar = new JButton("Cancelar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeJDialog();
			}
		});
		
		getContentPane().add(cerrar, "cell 2 1");
		
		{
			JLabel labelunidades11_15 = new JLabel("6 a 10 unidades");
			getContentPane().add(labelunidades11_15, "cell 0 2,alignx trailing");
		}
		
		{
			textFieldObsequioCantidad2 = new JTextField();
			getContentPane().add(textFieldObsequioCantidad2, "cell 1 2,growx");
		}
		
		{
			JLabel labelunidades15_more = new JLabel("11 a mas unidades");
			getContentPane().add(labelunidades15_more, "cell 0 3,alignx trailing");
		}
		
		{
			textFieldObsequioCantidad3 = new JTextField();
			getContentPane().add(textFieldObsequioCantidad3, "cell 1 3,growx");
		}
		
		setDefaultValues();
		
	}
	
	public void setDefaultValues() {
		textFieldTipoObsequio.setText(DataConfig.tipoObsequio);
		textFieldObsequioCantidad1.setText(Integer.toString(DataConfig.obsequioCantidad1));
		textFieldObsequioCantidad2.setText(Integer.toString(DataConfig.obsequioCantidad2));
		textFieldObsequioCantidad3.setText(Integer.toString(DataConfig.obsequioCantidad3));
	}
	
	public void saveJDialog(ActionEvent e) {
		
		DataConfig.obsequioCantidad1 = Integer.parseInt(textFieldObsequioCantidad1.getText());
		DataConfig.obsequioCantidad2 = Integer.parseInt(textFieldObsequioCantidad2.getText());
		DataConfig.obsequioCantidad3 = Integer.parseInt(textFieldObsequioCantidad3.getText());
		DataConfig.tipoObsequio = textFieldTipoObsequio.getText();
		
		dispose();
		
	}
	
	public void closeJDialog() {
		dispose();
	}


}
