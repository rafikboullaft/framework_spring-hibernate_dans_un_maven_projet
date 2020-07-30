package com.ensah.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.spring.dao.EtudiantDAO;
import com.ensah.spring.model.Etudiant;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	
	private EtudiantDAO etudiantDAO;

	public void setEtudiantDAO(EtudiantDAO etudiantDAO) {
		this.etudiantDAO = etudiantDAO;
	}

	@Override
	@Transactional
	public void addEtudiant(Etudiant E) {
		this.etudiantDAO.addEtudiant(E);
	}

	@Override
	@Transactional
	public void updateEtudiant(Etudiant E) {
		this.etudiantDAO.updateEtudiant(E);
	}

	@Override
	@Transactional
	public List<Etudiant> listEtudiants() {
		return this.etudiantDAO.listEtudiants();
	}

	@Override
	@Transactional
	public Etudiant getEtudiantByCode(long code) {
		return this.etudiantDAO.getEtudiantByCode(code);
	}

	@Override
	@Transactional
	public void removeEtudiant(long code) {
		this.etudiantDAO.removeEtudiant(code);
	}

}
