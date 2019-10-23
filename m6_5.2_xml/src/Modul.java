
public class Modul {
	String id;
	String titol;
	Profe[] profeArray = new Profe[0];
	Uf[] ufArray = new Uf[0];
	
	public Modul() {
		super();
	}
	
	public Modul(String id, String titol, Profe[] profeArray, Uf[] ufArray) {
		super();
		this.id = id;
		this.titol = titol;
		this.profeArray = profeArray;
		this.ufArray = ufArray;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public Profe[] getProfeArray() {
		return profeArray;
	}

	public void setProfeArray(Profe[] profeArray) {
		this.profeArray = profeArray;
	}

	public Uf[] getUfArray() {
		return ufArray;
	}

	public void setUfArray(Uf[] ufArray) {
		this.ufArray = ufArray;
	}
}
