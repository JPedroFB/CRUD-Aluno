package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Cadastrar;
import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCadastro extends JPanel {
	private JTextField txtNome;
	private JTextField textEmail;
	private JTextField textCurso;

	/**
	 * Create the panel.
	 */
	public TelaCadastro(EntityManager maneger) {
		setLayout(null);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				new Cadastrar(null,txtNome.getText(),textCurso.getText(),textEmail.getText(),maneger);	
				JOptionPane.showMessageDialog(null, "Cadastrado");
			}
		});
		
		
		
		btnCadastrar.setBounds(242, 257, 98, 32);
		add(btnCadastrar);
		
		JLabel Nome = new JLabel("Nome");
		Nome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nome.setBounds(17, 38, 75, 14);
		add(Nome);
		

		JLabel notifica = new JLabel("");
		notifica.setBounds(195, 66, 46, 14);
		add(notifica);

		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_INSERT){
					new Cadastrar(null,txtNome.getText(),textCurso.getText(),textEmail.getText(),maneger);	
					txtNome.setText("");
					JOptionPane.showMessageDialog(null, "Cadastrado");
				}
			}
		});
		txtNome.setColumns(10);
		txtNome.setBounds(17, 63, 323, 22);
		add(txtNome);
		
		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email.setBounds(17, 96, 75, 14);
		add(Email);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(17, 119, 323, 22);
		add(textEmail);
		
		textCurso = new JTextField();
		textCurso.setColumns(10);
		textCurso.setBounds(17, 177, 323, 22);
		add(textCurso);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurso.setBounds(17, 152, 75, 14);
		add(lblCurso);
		
	}
}
