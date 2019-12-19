package controller;

import javax.persistence.EntityManager;

import model.Aluno;

public class Editar {
	
	public Editar(long matricula, EntityManager manager, String nome, String curso, String email) {
		
		Aluno aluno = new Aluno();
		
		aluno = new Buscar(matricula,manager).getResultaAluno();
		
		
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		aluno.setCurso(curso);
		aluno.setEmail(email);
		manager.getTransaction().begin();
		manager.merge(aluno);
		manager.getTransaction().commit();
	}	

}
