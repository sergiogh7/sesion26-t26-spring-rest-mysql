package app.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Asigna entidad
@Entity
@Table(name="cientificos")
public class Cientifico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<AsignadoA> asignadoA;
	
//	Constructores
	public Cientifico() {
		
	}

	public Cientifico(int id, String nombre, List<AsignadoA> asignadoA) {
		this.id = id;
		this.nombre = nombre;
		this.asignadoA = asignadoA;
		
	}
	
//	Metodos
	@Override
	public String toString() {
		return "Cientifico:"+ 
				"id: " + id + 
				"\nNombre: " + nombre;
		
	}
	
//	Getters setters
	public int getId() {
		return id;
		
	}

	public void setId(int id) {
		this.id = id;
		
	}

	public String getNombre() {
		return nombre;
		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignadoA")
	public List<AsignadoA> getAsignadoA() {
		return asignadoA;
		
	}

	public void setAsignadoA(List<AsignadoA> asignadoA) {
		this.asignadoA = asignadoA;
		
	}
}