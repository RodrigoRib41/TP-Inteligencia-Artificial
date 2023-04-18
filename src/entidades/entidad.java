package entidades;

public abstract class entidad {
	protected  Integer id;
	protected  Integer energia;
	
	public entidad (Integer id, Integer energia) {
		this.id=id;
		this.energia=energia;
	}
}
