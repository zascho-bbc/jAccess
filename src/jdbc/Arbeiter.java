package jdbc;

public class Arbeiter {
	private String idarbeiter;
	private String name;
	private String nachname;
	private boolean status;
	private String wohnort;
	private String funktion;
	private String abteilung;
	private String kuerzel;

	public String getIdArbeiter() {
		return idarbeiter;
	}

	public String getIdarbeiter() {
		return idarbeiter;
	}

	public void setIdarbeiter(String idarbeiter) {
		this.idarbeiter = idarbeiter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getFunktion() {
		return funktion;
	}

	public void setFunktion(String funktion) {
		this.funktion = funktion;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public String getAbteilung() {
		return abteilung;
	}

	public void setAbteilung(String abteilung) {
		this.abteilung = abteilung;
	}
}
