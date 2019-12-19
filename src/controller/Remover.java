package controller;

import javax.persistence.EntityManager;

import model.Aluno;

public class Remover {
	public Remover(Aluno aluno, EntityManager manager) {
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
	}
}
