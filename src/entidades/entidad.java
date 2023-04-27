package entidades;

public abstract class entidad {
	protected  Integer id;
	protected  Integer energia;
	
	public entidad (Integer id, Integer energia) {
		this.id=id;
		this.energia=energia;
	}
	
	public void setEnergia(Integer energia1) {
		energia=energia1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnergia() {
		return energia;
	}
	
}
