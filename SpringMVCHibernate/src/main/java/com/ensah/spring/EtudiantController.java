package com.ensah.spring;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensah.spring.model.Etudiant;
import com.ensah.spring.service.EtudiantService;

@Controller
public class EtudiantController {
	
	private EtudiantService etudiantService;
	
	@Autowired(required=true)
	@Qualifier(value="etudiantService")
	public void setEtudiantService(EtudiantService es){
		this.etudiantService = es;
	}
	
	@RequestMapping(value = "/etudiants", method = RequestMethod.GET)
	public String listEtudiants(Model model) {
		model.addAttribute("etudiant", new Etudiant());
		model.addAttribute("listEtudiants", this.etudiantService.listEtudiants());
		return "etudiant";
	}
	
	//For add and update etudiant both
	@RequestMapping(value= "/etudiant/add", method = RequestMethod.POST)
	public String addEtudiant(@ModelAttribute("etudiant") Etudiant p){
		
//		if(p.getCode() == 0){
//			//new etudiant, add it
			
		//}
//		else{
//			//existing etudiant, call update
//			this.etudiantService.updateEtudiant(p);
//		}
		int tmp = 0;
		Iterator<Etudiant> it = etudiantService.listEtudiants().iterator();
		while (it.hasNext()) {
			Etudiant e = it.next();
			if (p.getCode() == e.getCode()) {
				tmp = 1;
			}
		}
		if (tmp == 0) {
			this.etudiantService.addEtudiant(p);
		}
		else {
			this.etudiantService.updateEtudiant(p);
		}
		return "redirect:/etudiants";
		
	}
	@RequestMapping("/remove/{code}")
    public String removeEtudiant(@PathVariable("code") long code){
		
        this.etudiantService.removeEtudiant(code);
        return "redirect:/etudiants";
    }
 
    @RequestMapping("/edit/{code}")
    public String editEtudiant(@PathVariable("code") long code, Model model){
        model.addAttribute("etudiant", this.etudiantService.getEtudiantByCode(code));
        model.addAttribute("listEtudiants", this.etudiantService.listEtudiants());
        return "etudiant";
    }
	
}
