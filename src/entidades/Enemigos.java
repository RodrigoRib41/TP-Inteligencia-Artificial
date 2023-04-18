package entidades;

public class Enemigos extends entidad{
	public Enemigos(Integer id, Integer energia) {
		super(id, energia);
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private Integer energia;
	private Integer nivel;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEnergia() {
		return energia;
	}
	public void setEnergia(Integer energia) {
		this.energia = energia;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Enemigo id: " + this.getId();
	}
	
}
