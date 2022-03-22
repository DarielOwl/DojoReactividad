package sofka.correo;

import java.util.Objects;
import reactor.core.publisher.Flux;

public class Correo {

    String nombre;
    String tipoCorreo;
    Boolean enviado=true;
    Boolean valido=false;

    public Correo(String nombre, String tipoCorreo) {
        this.nombre = nombre;
        this.tipoCorreo = tipoCorreo;
    }

    public Correo(String nombre, String tipoCorreo, Boolean enviado) {
        this.nombre = nombre;
        this.tipoCorreo = tipoCorreo;
        this.enviado = enviado;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipoCorreo() {
        return tipoCorreo;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public Flux<Correo> defaultIfEmpty(Correo fluxEstudiantes) {
        return null;
    }

    public Boolean getValido() {
        return valido;
    }


    //Setters
    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + "\n" +
                "enviado=" + enviado + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo = (Correo) o;
        return nombre.equals(correo.nombre) && tipoCorreo.equals(correo.tipoCorreo) && enviado.equals(correo.enviado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCorreo, enviado);
    }

}
