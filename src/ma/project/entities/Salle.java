package ma.project.entities;

import java.util.ArrayList;
import java.util.List;

public class Salle implements Identifiable {

	private int id;
	private String code;
	private String libelle;
	private List<Machine> machines;

	public Salle(int id, String code, String libelle) {

		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.machines = new ArrayList<Machine>();

	}

	@Override
	public int getId() {

		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	public String getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	@Override
	public String toString() {
		return "\n Salle  : id = " + id + ", code = " + code + ", libelle = " + libelle ;
	}

}
