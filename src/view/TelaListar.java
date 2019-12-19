package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Listar;
import model.Aluno;

import javax.persistence.EntityManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;

public class TelaListar extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListar(EntityManager manager) {
		setLayout(null);
		
		JLabel lblAlunos = new JLabel("ALUNOS");
		lblAlunos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlunos.setBounds(10, 21, 291, 14);
		add(lblAlunos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 330, 238);
		add(scrollPane);
		
		JTextArea textLista = new JTextArea();
		scrollPane.setViewportView(textLista);

		List<Aluno> alunos = new Listar(manager).resultaAlunos();	
		
		int tamanho = alunos.size();
		lblAlunos.setText("Alunos cadastrados: "+tamanho);
		
		for (Aluno aluno : alunos) {
			textLista.setText(textLista.getText()+"\n" +"  Matrícula: "+aluno.getMatricula()+"\n     Nome: "+aluno.getNome()+"\n     Email: "+aluno.getEmail()+"\n     Curso: "+aluno.getCurso()+"\n     Data de criação: "+aluno.getDataCriacao()+"\n\n");
		}
		
		
		
	}

}
