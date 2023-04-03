package model;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class Analisis implements Citable {

    private String numHistorial;
    private String tipo;
    private LocalDateTime horaAnalisis;

    public Analisis(String numHistorial, String tipo, LocalDateTime horaAnalisis) {
        this.numHistorial = numHistorial;
        this.tipo = tipo;
        this.horaAnalisis = horaAnalisis;
    }

    public Analisis(Analisis analisis) {
        this.numHistorial = analisis.getNumHistorial();
        this.tipo = analisis.getTipo();
        this.horaAnalisis = analisis.getHoraAnalisis();
    }

    public String getNumHistorial() {
        return numHistorial;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getHoraAnalisis() {
        return horaAnalisis;
    }

    @Override
    public String consultarDetalle() {
        String texto = getNumHistorial() + getHoraAnalisis();
        return texto;
    }

    @Override
    public String toString() {
        return "Analisis{" + "numHistorial=" + numHistorial + ", tipo=" + tipo + ", horaAnalisis=" + horaAnalisis + '}';
    }

}
