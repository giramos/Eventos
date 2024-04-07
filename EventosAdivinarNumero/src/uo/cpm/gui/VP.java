package uo.cpm.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import uo.cpm.logic.Aleatorio;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Color;

public class VP extends JFrame {

	private static final long serialVersionUID = 1L;
	private ProcesaTecla pT = new ProcesaTecla();
	private JPanel contentPane;
	private JTextField txCodigo;
	private JLabel jLabel;
	private int numero;

	public VP() {
		setResizable(false);
		numero = Aleatorio.generaNumero();
		this.setSize(789, 257);
		this.setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		this.setTitle("Ejemplo Eventos Adivinar");
		
	}
	
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setForeground(Color.RED);
			txCodigo.setFont(new Font("Tahoma", Font.PLAIN, 36));
			txCodigo.setBounds(new Rectangle(501, 81, 260, 37));
			txCodigo.addKeyListener(pT);
		}
		return txCodigo;
	}
	
	private JPanel getJContentPane() {
		if (contentPane == null) {
			jLabel = new JLabel();
			jLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
			jLabel.setBounds(new Rectangle(10, 81, 481, 32));
			jLabel.setText("Introduce números del 1 al 9:");
			contentPane = new JPanel();
			contentPane.setLayout(null);
			contentPane.add(getTxCodigo(), null);
			contentPane.add(jLabel, null);
		}
		return contentPane;
	}

	class ProcesaTecla extends KeyAdapter{
		@Override
		public void keyTyped(KeyEvent e){
			compruebaTecla(e);
		}
	}
	
	private void compruebaTecla(KeyEvent e) {
	     if (e.getKeyChar()==(Character.forDigit(numero,10)))
			mostrarMensaje();
	    }

	private void mostrarMensaje() {
		JOptionPane.showMessageDialog(this,"¡¡ACERTASTE!!");
	}

}  
