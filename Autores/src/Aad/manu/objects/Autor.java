package Aad.manu.objects;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

public class Autor {
    public static String COLECCION = "autores";
    private ObjectId id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechanaci;

    public Autor(){

    }

    public Autor(ObjectId id, String nombre, String apellido1, String apellido2, Date fechanaci) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechanaci = fechanaci;
    }



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(Date fechanaci) {
        this.fechanaci = fechanaci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nombre, autor.nombre) && Objects.equals(apellido1, autor.apellido1) && Objects.equals(apellido2, autor.apellido2) && Objects.equals(fechanaci, autor.fechanaci);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido1, apellido2, fechanaci);
    }
}
