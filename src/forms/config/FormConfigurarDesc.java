package forms.config;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.DataConfig;
import data.DataItems;
import forms.mantenimiento.FormConsultarCera;
import forms.mantenimiento.FormModificarCera;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class FormConfigurarDesc extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JTextField textFieldPercent2;
	protected JTextField textFieldPercent3;
	protected JTextField textFieldPercent4;
	protected JButton cerrar;
	protected JButton guardar;
	protected JTextField textFieldPercent1;
	protected JLabel labelsimbol1;
	protected JLabel labelsimbol2;
	protected JLabel labelsimbol3;
	protected JLabel labelsimbol4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormConfigurarDesc dialog = new FormConfigurarDesc();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormConfigurarDesc() {
		setResizable(false);
		setBounds(100, 100, 405, 193);
		getContentPane().setLayout(new MigLayout("gapx 10px, gapy 10px", "[100px,left][grow][40px][100px,fill]", "[][][][][][]"));
		{
			JLabel labelModelo = new JLabel("1 a 5 unidades");
			getContentPane().add(labelModelo, "cell 0 0,alignx trailing");
		}
		
		{
			textFieldPercent1 = new JTextField();
			textFieldPercent1.setColumns(10);
			getContentPane().add(textFieldPercent1, "cell 1 0,growx");
		}
		
		{
			guardar = new JButton("Aceptar");
			guardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveJDialog(e);
				}
			});
			{
				labelsimbol1 = new JLabel("%");
				labelsimbol1.setFont(new Font("Consolas", Font.PLAIN, 16));
				getContentPane().add(labelsimbol1, "cell 2 0,aligny bottom");
			}
			getContentPane().add(guardar, "cell 3 0");
		}
		
		{
			JLabel labelPrecio = new JLabel("6 a 10 unidades");
			getContentPane().add(labelPrecio, "cell 0 1,alignx trailing");
		}
		
		{
			textFieldPercent2 = new JTextField();
			getContentPane().add(textFieldPercent2, "cell 1 1,growx");
			textFieldPercent2.setColumns(10);
		}
		
		JButton cerrar_1 = new JButton("Cancelar");
		cerrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeJDialog();
			}
		});
		{
			labelsimbol2 = new JLabel("%");
			labelsimbol2.setFont(new Font("Consolas", Font.PLAIN, 16));
			getContentPane().add(labelsimbol2, "cell 2 1,aligny bottom");
		}
		
		getContentPane().add(cerrar_1, "cell 3 1");
		{
			JLabel labelAncho = new JLabel("11 a 15 unidades");
			getContentPane().add(labelAncho, "cell 0 2,alignx trailing");
		}
		
		{
			textFieldPercent3 = new JTextField();
			getContentPane().add(textFieldPercent3, "cell 1 2,growx");
			textFieldPercent3.setColumns(10);
		}
		{
			labelsimbol3 = new JLabel("%");
			labelsimbol3.setFont(new Font("Consolas", Font.PLAIN, 16));
			getContentPane().add(labelsimbol3, "cell 2 2,aligny bottom");
		}
		
		{
			JLabel labelEspesor = new JLabel("Mas de 15 unidades");
			getContentPane().add(labelEspesor, "cell 0 3,alignx trailing");
		}
		
		{
			textFieldPercent4 = new JTextField();
			getContentPane().add(textFieldPercent4, "cell 1 3,growx");
			textFieldPercent4.setColumns(10);
		}
		{
			labelsimbol4 = new JLabel("%");
			labelsimbol4.setFont(new Font("Consolas", Font.PLAIN, 16));
			getContentPane().add(labelsimbol4, "cell 2 3,aligny bottom");
		}
		
		setDefaultValues();
		
	}
	
	public void setDefaultValues() {
		//setValuesFields(DataItems.modelo0);
		textFieldPercent1.setText(Double.toString(DataConfig.porcentaje1));
		textFieldPercent2.setText(Double.toString(DataConfig.porcentaje2));
		textFieldPercent3.setText(Double.toString(DataConfig.porcentaje3));
		textFieldPercent4.setText(Double.toString(DataConfig.porcentaje4));
		
	}
	
	public void saveJDialog(ActionEvent e) {
		
		DataConfig.porcentaje1 = Double.parseDouble(textFieldPercent1.getText());
		DataConfig.porcentaje2 = Double.parseDouble(textFieldPercent2.getText());
		DataConfig.porcentaje3 = Double.parseDouble(textFieldPercent3.getText());
		DataConfig.porcentaje4 = Double.parseDouble(textFieldPercent4.getText());
		
		dispose();
		
	}
	
	public void closeJDialog() {
		dispose();
	}


}
