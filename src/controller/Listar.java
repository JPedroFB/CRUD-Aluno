package controller;

import java.util.List;

import javax.persistence.EntityManager;

import model.Aluno;

public class Listar {
	
	List<Aluno> alunos;
	
	
	public Listar(EntityManager manager) {	
		String queryJPQL = "from Aluno";	
		this.alunos = manager.createQuery(queryJPQL).getResultList();
	}
	
	public List<Aluno> resultaAlunos(){
		return this.alunos;
	}
	
}
