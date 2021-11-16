package Objetos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    private int id;
    private String nombre;

    private Date fecha_nacimiento;
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();

    //JOIN
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "director_id")
//    private List<Pelicula> peliculas;
//
//    public List<Pelicula> getPeliculas() {
//        return peliculas;
//    }
//
//    public void setPeliculas(List<Pelicula> peliculas) {
//        this.peliculas = peliculas;
//    }
//    //END JOIN

    public Director() {

    }

    public Director(int id, String nombre, Date fecha_nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "nombre")

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name = "fecha_nacimiento")
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
    public List<Pelicula> getPeliculas() {
        return this.peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
