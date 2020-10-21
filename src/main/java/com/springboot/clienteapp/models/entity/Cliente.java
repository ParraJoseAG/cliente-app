package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "futurosclientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NOMBRES")
	@NotEmpty(message = "*Por favor, ingresa tu nombre(s)")
	@Pattern(regexp = "[^0-9]*")
	private String nombres;
	@Column(name = "APELLIDOS")
	@NotEmpty(message = "*Por favor, ingresa tu apellido(s)")
	@Pattern(regexp = "[^0-9]*")
	private String apellidos;
	@Column(name = "EDAD")
	@NotNull
	@Min(value = 18)
	private int edad;
	@Column(name = "EMAIL")
	@NotEmpty(message = "*Por favor, ingresa tu email")
	@Email
	private String email;
	@Column(name = "DIRECCION")
	@NotEmpty(message = "*Por favor, ingresa tu dirección")
	private String direccion;
	@Column(name = "GENERO")
	private String genero;
	@Column(name = "LIBROS")
	private boolean libros;
	@Column(name = "DEPORTES")
	private boolean deportes;
	@Column(name = "PELICULAS")
	private boolean peliculas;
	@Column(name = "VIDEOJUEGOS")
	private boolean videoJuegos;
	@Column(name = "COMENTARIOS")
	private String comentarios;
	@Column(name = "PAIS")
	@NotEmpty
	private String pais;
	@ManyToOne
	@JoinColumn(name = "CIUDAD")
	private Ciudad ciudad;

	/**
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param email
	 * @param direccion
	 * @param genero
	 * @param libros
	 * @param deportes
	 * @param peliculas
	 * @param otros
	 * @param pais
	 */
	public Cliente(String nombres, String apellidos, int edad, String email, String direccion, String genero,
			boolean libros, boolean deportes, boolean peliculas, boolean videoJuegos, String comentarios, String pais,
			Ciudad ciudad) {

		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.direccion = direccion;
		this.genero = genero;
		this.libros = libros;
		this.deportes = deportes;
		this.peliculas = peliculas;
		this.videoJuegos = videoJuegos;
		this.comentarios = comentarios;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public Cliente() {

	}

	// GETs and SETs

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return
	 */
	public boolean isLibros() {
		return libros;
	}

	/**
	 * @param libros
	 */
	public void setLibros(boolean libros) {
		this.libros = libros;
	}

	/**
	 * @return
	 */
	public boolean isDeportes() {
		return deportes;
	}

	/**
	 * @param deportes
	 */
	public void setDeportes(boolean deportes) {
		this.deportes = deportes;
	}

	/**
	 * @return
	 */
	public boolean isPeliculas() {
		return peliculas;
	}

	/**
	 * @param peliculas
	 */
	public void setPeliculas(boolean peliculas) {
		this.peliculas = peliculas;
	}

	/**
	 * @return
	 */
	public boolean isVideoJuegos() {
		return videoJuegos;
	}

	/**
	 * @param peliculas
	 */
	public void setVideoJuegos(boolean videoJuegos) {
		this.videoJuegos = videoJuegos;
	}

	/**
	 * @return
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + ", email="
				+ email + ", direccion=" + direccion + ", genero=" + genero + ", libros=" + libros + ", deportes="
				+ deportes + ", peliculas=" + peliculas + ", videoJuegos=" + videoJuegos + " cometarios=" + comentarios
				+ ", pais=" + pais + ", ciudad=" + ciudad + "]";
	}

}
