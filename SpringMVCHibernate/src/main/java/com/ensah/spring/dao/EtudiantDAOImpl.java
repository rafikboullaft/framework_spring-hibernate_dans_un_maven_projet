package com.ensah.spring.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ensah.spring.model.Etudiant;

@Repository
public class EtudiantDAOImpl implements EtudiantDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EtudiantDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addEtudiant(Etudiant p) {
		Session session = this.sessionFactory.getCurrentSession();
//		session.persist(p);
		session.save(p);
		logger.info("Etudiant saved successfully, Etudiant Details="+p);
	}

	@Override
	public void updateEtudiant(Etudiant p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Etudiant updated successfully, Etudiant Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> listEtudiants() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Etudiant> EtudiantsList = session.createQuery("from Etudiant").list();
		for(Etudiant p : EtudiantsList){
			logger.info("Etudiant List::"+p);
		}
		return EtudiantsList;
	}

	@Override
	public Etudiant getEtudiantByCode(long code) {
		Session session = this.sessionFactory.getCurrentSession();		
		Etudiant p = (Etudiant) session.load(Etudiant.class, new Long(code));
		logger.info("Etudiant loaded successfully, Etudiant details="+p);
		return p;
	}

	@Override
	public void removeEtudiant(long code) {
		Session session = this.sessionFactory.getCurrentSession();
		Etudiant E = (Etudiant) session.load(Etudiant.class, new Long(code));
		if(null != E){
			session.delete(E);
		}
		logger.info("Etudiant deleted successfully, Etudiant details="+E);
	}

}
