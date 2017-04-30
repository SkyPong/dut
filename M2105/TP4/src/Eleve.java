package model;

import java.util.ArrayList;
import java.time.*;
import java.time.format.*;

public class Eleve
{
	private String nom;
	private String prenom;
	private String sexe;
	private String mail;
	private LocalDate anneeNaissance;
	private boolean r1a;
	private boolean r2a;
	private ArrayList<Evaluation> evaluations;
	private double moyGen;

	public Eleve()
	{
		evaluations = new ArrayList<Evaluation>();
	}

	public void setNom(String nom) throws EleveException
	{
		if(nom != null)
			this.nom = nom;
		else
			throw new EleveException("Nom invalide");
	}

	public void setPrenom(String prenom) throws EleveException
	{
		if(prenom != null)
			this.prenom = prenom;
		else
			throw new EleveException("Prenom invalide");
	}

	public void setSexe(String sexe) throws EleveException
	{
		if(sexe != null && (sexe.equals("homme") || sexe.equals("femme")))
			this.sexe = sexe;
		else
			throw new EleveException("Sexe invalide");
	}

	public void setMail(String mail) throws EleveException
	{
		if(mail != null && mail.contains("@"))
			this.mail = mail;
		else
			throw new EleveException("Mail invalide");
	}

	public void setAnneeNaissance(LocalDate anneeNaissance) throws EleveException
	{
		if(anneeNaissance != null && anneeNaissance.compareTo(LocalDate.now()) < 0)
			this.anneeNaissance = anneeNaissance;
		else
			throw new EleveException("Annee de naissance invalide");
	}

	public void setR1a(boolean r)
	{
		this.r1a = r;
	}

	public void setR2a(boolean r)
	{
		this.r2a = r;
	}

	public void ajouteEvaluation(Evaluation e)
	{
		if(e != null)
		{
			this.evaluations.add(e);
		}
	}

	public void calculeMoyGen()
	{
		if(this.evaluations.size() != 0)
		{
			double note = 0.0;
			for(Evaluation n : this.evaluations)
				note += n.getNote();
			note /= this.evaluations.size();
			this.moyGen = note;
		}
		else
		{
			this.moyGen = 0;
		}
	}

	public double getMoyGen()
	{
		calculeMoyGen();
		return this.moyGen;
	}
}