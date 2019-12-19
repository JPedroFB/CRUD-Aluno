package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Aluno;

public class Buscar {	
	
	Aluno resultaAluno;
	List<Aluno> resultaAluno2;
	
	public Buscar(Long matricula,EntityManager manager) {
		this.resultaAluno = manager.find(Aluno.class, matricula);		
	}
	
	public Buscar(String nome,EntityManager manager) {
		Query queryJPQL = manager.createQuery("select t from Aluno as t where t.nome = :paramFinalizado");
		queryJPQL.setParameter("paramFinalizado", nome);
		
		@SuppressWarnings("unchecked")
		List<Aluno> tasks = queryJPQL.getResultList();
		for (Aluno task : tasks) {
			resultaAluno = task;
		}
		
	}

	public Aluno getResultaAluno() {
		return resultaAluno;
	}

}
