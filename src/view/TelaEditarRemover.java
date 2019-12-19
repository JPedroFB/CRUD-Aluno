package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Buscar;
import controller.Editar;
import controller.Remover;
import model.Aluno;

import javax.swing.JLabel;
import java.awt.Font;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaEditarRemover extends JPanel {
	private JTextField textMatricula;
	private JTextField textNome;
	private JTextField textCurso;
	private JTextField textEmail;

	
	public TelaEditarRemover(EntityManager manager) {
		setLayout(null);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(21, 214, 319, 32);
		add(textArea);
		
		textMatricula = new JTextField();
		textNome = new JTextField();
		
		textCurso = new JTextField();
		textCurso.setColumns(10);
		textCurso.setBounds(21, 126, 159, 20);
		add(textCurso);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurso.setBounds(21, 112, 46, 14);
		add(lblCurso);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(21, 170, 159, 20);
		add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(21, 157, 46, 14);
		add(lblEmail);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Buscar(Long.parseLong(textMatricula.getText()),manager).getResultaAluno();
				new Remover(aluno,manager);
				textArea.setText(aluno.getNome()+" Removido");
				textMatricula.setText("");
				textNome.setText("");
			}
		});
		btnRemover.setBounds(21, 257, 98, 32);
		add(btnRemover);
		btnRemover.setVisible(false);
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Editar(Long.parseLong(textMatricula.getText()),manager,textNome.getText(),textCurso.getText(),textEmail.getText());	
					textArea.setText("Aluno editado");
				}catch (Exception e1) {
					textArea.setText("Aluno não existe");
				}
				
			}
		});
		btnEditar.setBounds(129, 257, 98, 32);
		add(btnEditar);
		btnEditar.setVisible(false);
	
		
		
		textMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				System.out.println("1");
				System.out.println(textMatricula.getText());
				if(textMatricula.getText().equals("")) {
					btnEditar.setVisible(false);
					btnRemover.setVisible(false);
				} else {
					btnEditar.setVisible(true);
					btnRemover.setVisible(true);
				}
				System.out.println("2");
				System.out.println(textMatricula.getText());
			}
		});
		textMatricula.setBounds(20, 36, 86, 20);
		add(textMatricula);
		textMatricula.setColumns(10);
		
		
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatrcula.setBounds(21, 22, 75, 14);
		add(lblMatrcula);
		
		
		
		textNome.setBounds(21, 83, 159, 20);
		add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(21, 69, 46, 14);
		add(lblNome);
		
		
		
		
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				Aluno aluno = null;
				
				try {
					
					if(textMatricula.getText().equals("")){
						System.out.println("Entrou"+textNome.getText());
						aluno = new Buscar(textNome.getText(),manager).getResultaAluno();						
					}else {
						aluno = new Buscar(Long.parseLong(textMatricula.getText()),manager).getResultaAluno();
					}
					
					textArea.setText("Achou "+aluno.getNome());	
					textMatricula.setText(String.valueOf(aluno.getMatricula()));
					textCurso.setText(String.valueOf(aluno.getCurso()));
					textEmail.setText(String.valueOf(aluno.getEmail()));
					textNome.setText(String.valueOf(aluno.getNome()));
					
					btnEditar.setVisible(true);
					btnRemover.setVisible(true);
					
				}catch (Exception e1) {
					textArea.setText("Aluno não existe");	
					textCurso.setText(" ");
					textEmail.setText(" ");
					textNome.setText(" ");
				}
				
			}
		});
		btnPesquisar.setBounds(242, 257, 98, 32);
		add(btnPesquisar);
		
		
		
		
		
		
	}
	
	
}
