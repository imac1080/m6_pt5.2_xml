
//Clase Persona
import java.io.Serializable;

public class Curs implements Serializable {
	private String id;
	private Profe tutor;
	private Alumne[] alumesArray = new Alumne[0];
	private Modul[] modulArray = new Modul[0];

	public Curs() {
		super();
	}

	public Curs(String id, Profe tutor, Alumne[] alumesArray, Modul[] modulArray) {
		super();
		this.id = id;
		this.tutor = tutor;
		this.alumesArray = alumesArray;
		this.modulArray = modulArray;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profe getTutor() {
		return tutor;
	}

	public void setTutor(Profe tutor) {
		this.tutor = tutor;
	}

	public Alumne[] getAlumesArray() {
		return alumesArray;
	}

	public void setAlumesArray(Alumne[] alumesArray) {
		this.alumesArray = alumesArray;
	}

	public Modul[] getModulArray() {
		return modulArray;
	}

	public void setModulArray(Modul[] modulArray) {
		this.modulArray = modulArray;
	}

}
