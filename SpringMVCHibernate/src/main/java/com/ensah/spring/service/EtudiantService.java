package com.ensah.spring.service;

import java.util.List;

import com.ensah.spring.model.Etudiant;

public interface EtudiantService {

	public void addEtudiant(Etudiant E);
	public void updateEtudiant(Etudiant E);
	public List<Etudiant> listEtudiants();
	public Etudiant getEtudiantByCode(long code);
	public void removeEtudiant(long code);
	
}
