package com.ensah.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Etudiant")
public class Etudiant {

	@Id
	@Column(name="code")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code;
	
	private String nom;
	
	private String prenom;
	private int age;
	private String ville;
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Etudiant [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", ville=" + ville
				+ "]";
	}
	
}
