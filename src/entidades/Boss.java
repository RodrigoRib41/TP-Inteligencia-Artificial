package entidades;

public class Boss extends entidad{
	public Boss(Integer id, Integer energia) {
		super(id, energia);
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private Integer energia;
	
	
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Boss id: " + this.getId();
	}
	
}