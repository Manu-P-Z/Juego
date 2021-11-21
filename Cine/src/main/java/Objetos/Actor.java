package Objetos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {

    private int id;

    private String nombre;

    private Date fecha_nacimiento;

    private List<Pelicula> peliculas = new ArrayList<Pelicula>();
    //JOIN
    //Nota: no consigo eliminar entidades relacionadas, aunque no estén usadas en una tabla relacional
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "actores_peliculas",
//            joinColumns = @JoinColumn(name = "actor_id"),
//            inverseJoinColumns = @JoinColumn(name = "peliculas_id"))
//    private List<Pelicula> peliculas;
//
//    public List<Pelicula> getPeliculas() {
//        return peliculas;
//    }
//
//    public void setPeliculas(List<Pelicula> peliculas) {
//        this.peliculas = peliculas;
//    }
    //END JOIN

    public Actor (){

}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "actores_peliculas", catalog = "db_peliculas", joinColumns = { @JoinColumn(name = "id_actor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_pelicula", nullable = false, updatable = false) })

    public List <Pelicula> getPeliculas() {
        return  this.peliculas;
    }

    public void setPeliculas(List <Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

}