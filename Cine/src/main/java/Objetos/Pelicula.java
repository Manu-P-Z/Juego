package Objetos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    private int id;
  // private int id_director;
    private Director director;

    private String titulo;

    private Date fecha_estreno;
    private List<Actor> actores = new ArrayList<Actor>();

    public Pelicula() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_director")
    public Director getDirector() {
        return this.director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

//    @Column(name = "id_director")

//    public int getId_director() {
//        return id_director;
//    }

//    public void setId_director(int id_director) {
//        this.id_director = id_director;
//    }
    @Column(name = "titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Column(name = "fecha_extreno")
    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "actores_peliculas", catalog = "db_peliculas", joinColumns = { @JoinColumn(name = "id_pelicula", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_actor", nullable = false, updatable = false) })
    public List<Actor> getActors() {
        return  this.actores;
    }

    public void setActors(List<Actor> actors) {
        this.actores = actors;
    }

}
