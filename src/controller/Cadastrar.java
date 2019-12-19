package controller;


import javax.persistence.EntityManager;

import model.Aluno;

public class Cadastrar {
	public Cadastrar(Long matricula, String nome,String curso, String email, EntityManager maneger) {	
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setCurso(curso);
		
		maneger.getTransaction().begin();
		maneger.persist(aluno);
		maneger.getTransaction().commit();
		
	}			
}
