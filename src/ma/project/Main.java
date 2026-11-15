package ma.project;

import java.util.Date;
import java.util.List;

import ma.project.entities.Machine;
import ma.project.entities.Salle;
import ma.project.service.MachineService;
import ma.project.service.SalleService;

public class Main {

	public static void main(String[] args) {

		SalleService salleService = new SalleService();
		MachineService machineService = new MachineService();

		// Création et ajout des salles

		Salle s1 = new Salle(1, "I1", "Salle Informatique");
		Salle s2 = new Salle(2, "I2", "Salle Réseau");
		salleService.ajouter(s1);
		salleService.ajouter(s2);

		// Création et ajout des machines
		Machine m1 = new Machine(1, "PC-DELL-01", new Date(), s1);
		Machine m2 = new Machine(2, "PC-HP-02", new Date(), s1);
		Machine m3 = new Machine(3, "SERV-IBM-01", new Date(), s2);

		machineService.ajouter(m1);
		machineService.ajouter(m2);
		machineService.ajouter(m3);

		// Affichage des machines de la salle I1
		System.out.println("\n <<<  Machines dans la salle I1 >>> ");
		List<Machine> machinesI1 = machineService.getMachinesBySalle(1);
		for (int i = 0; i < machinesI1.size(); i++) {
			System.out.println(machinesI1.get(i));
		}

		// Affichage des machines de la salle I2
		System.out.println("\n <<<  Machines dans la salle I2 >>> ");
		List<Machine> machinesI2 = machineService.getMachinesBySalle(2);
		for (int i = 0; i < machinesI2.size(); i++) {
			System.out.println(machinesI2.get(i));
		}

		
		// Test de modification
		m1.setRef("PC-DELL-PRO");
		machineService.modifier(m1);
		System.out.println("\n <<<  Après modification de m1 >>>");
		System.out.println(machineService.getById(1));
		
		m2.setRef("PC-HP-ProDesk");
		machineService.modifier(m2);
		System.out.println("\n <<<  Après modification de m2  >>>");
		System.out.println(machineService.getById(2));

		//  Test de suppression
		machineService.supprimer(m3);
		System.out.println("\n <<< Liste de toutes les machines après suppression >>> ");
		List<Machine> toutes = machineService.getAll();
		for (int i = 0; i < toutes.size(); i++) {
		    System.out.println(toutes.get(i));
		}
	}

}
