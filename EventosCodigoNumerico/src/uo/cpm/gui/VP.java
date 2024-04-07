package uo.cpm.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VP extends JFrame {
	private static final long serialVersionUID = 1L;
	private ProcesaTecla pT = new ProcesaTecla();
	private ProcesaCheck pC = new ProcesaCheck();
	private JPanel contentPane;
	private JCheckBox ckControl;
	private JTextField txCodigo;
	private JLabel lblClaveDeAcceso;

	public VP() {
		setResizable(false);
		setTitle("Ejemplo Eventos Clave acceso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 354);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(getTxCodigo());
		contentPane.add(getCkControl());
		setContentPane(contentPane);
		contentPane.add(getLblClaveDeAcceso());
	}
	
	class ProcesaTecla extends KeyAdapter{
		public void keyTyped(KeyEvent e){
			compruebaTecla(e);
		}
	}
	
	private void compruebaTecla(KeyEvent e) {
	    char teclaPulsada = e.getKeyChar();
	     if (Character.isAlphabetic(teclaPulsada)){
	       e.consume();
	     }
	    }
	
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setForeground(Color.RED);
			txCodigo.setFont(new Font("Tahoma", Font.PLAIN, 36));
			txCodigo.setBounds(new Rectangle(304, 80, 262, 54));
			txCodigo.addKeyListener(pT);
		}
		return txCodigo;
	}

	private JCheckBox getCkControl() {
		if (ckControl == null) {
			ckControl = new JCheckBox();
			ckControl.setFont(new Font("Tahoma", Font.PLAIN, 36));
			ckControl.setBounds(new Rectangle(304, 150, 262, 38));
			ckControl.setSelected(true);
			ckControl.setText("Sólo números");
			ckControl.addActionListener(pC);
		}
		return ckControl;
	}
	
	private JLabel getLblClaveDeAcceso() {
		if (lblClaveDeAcceso == null) {
			lblClaveDeAcceso = new JLabel("Clave de acceso:");
			lblClaveDeAcceso.setDisplayedMnemonic(KeyEvent.VK_C);
			lblClaveDeAcceso.setLabelFor(getTxCodigo());
			lblClaveDeAcceso.setFont(new Font("Tahoma", Font.PLAIN, 32));
			lblClaveDeAcceso.setBounds(32, 89, 262, 38);
		}
		return lblClaveDeAcceso;
	}
	
	
	class ProcesaCheck implements ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e) {
			getTxCodigo().setText("");
			getTxCodigo().grabFocus();
			if (getCkControl().isSelected()) 
				getTxCodigo().addKeyListener(pT);
			else
				getTxCodigo().removeKeyListener(pT);
		}
	}
}
