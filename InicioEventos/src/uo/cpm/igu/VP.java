package uo.cpm.igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Insets;

public class VP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbNombre;
	private JTextField txtIntroduzcaSuNombre;
	private JLabel lbApellidos;
	private JTextField txtIntroduzcaDosApellidos;
	private JButton btAceptar;
	private ProcesaFoco pF = new ProcesaFoco();
	private JButton bt;

	/**
	 * Create the frame.
	 */
	public VP() {
		setTitle("Ejemplo eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 323);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbNombre());
		contentPane.add(getTxtIntroduzcaSuNombre());
		contentPane.add(getLbApellidos());
		contentPane.add(getTxtIntroduzcaDosApellidos());
		contentPane.add(getBtAceptar());
		contentPane.add(getBt());
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lbNombre.setBounds(36, 49, 103, 39);
		}
		return lbNombre;
	}
	private JTextField getTxtIntroduzcaSuNombre() {
		if (txtIntroduzcaSuNombre == null) {
			txtIntroduzcaSuNombre = new JTextField();
			txtIntroduzcaSuNombre.setForeground(Color.LIGHT_GRAY);
			txtIntroduzcaSuNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtIntroduzcaSuNombre.setText("Introduzca su nombre");
			txtIntroduzcaSuNombre.setBounds(138, 53, 229, 34);
			txtIntroduzcaSuNombre.addFocusListener(pF);
		}
		return txtIntroduzcaSuNombre;
	}
	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos:");
			lbApellidos.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lbApellidos.setBounds(36, 103, 103, 39);
		}
		return lbApellidos;
	}
	private JTextField getTxtIntroduzcaDosApellidos() {
		if (txtIntroduzcaDosApellidos == null) {
			txtIntroduzcaDosApellidos = new JTextField();
			txtIntroduzcaDosApellidos.setText("Introduzca dos apellidos");
			txtIntroduzcaDosApellidos.setForeground(Color.LIGHT_GRAY);
			txtIntroduzcaDosApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtIntroduzcaDosApellidos.setBounds(138, 107, 229, 34);
			txtIntroduzcaDosApellidos.addFocusListener(pF);
		}
		return txtIntroduzcaDosApellidos;
	}
	private JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btAceptar.setBounds(261, 214, 103, 39);
		}
		return btAceptar;
	}
	
	// Clase receptora de eventos de foco
	class ProcesaFoco extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			((JTextField)e.getSource()).setText("");
			((JTextField)e.getSource()).setBackground(Color.white);
			((JTextField)e.getSource()).setForeground(Color.black);
		}
		@Override
		public void focusLost(FocusEvent e) {
			((JTextField)e.getSource()).setBackground(Color.lightGray);
		}
	}
	private JButton getBt() {
		if (bt == null) {
			bt = new JButton("?");
			bt.setMargin(new Insets(0, 0, 0, 0));
			bt.setBounds(392, 11, 27, 23);
		}
		return bt;
	}
}
