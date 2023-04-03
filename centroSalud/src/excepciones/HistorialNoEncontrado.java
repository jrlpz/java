package excepciones;

import java.time.LocalDate;
import java.util.Objects;

public class HistorialNoEncontrado extends Exception{

    String numHistorial;
    LocalDate hora;

    public HistorialNoEncontrado(String numHistorial, LocalDate hora) {
        this.numHistorial = numHistorial;
        this.hora = hora;
    }

    public String getNumHistorial() {
        return numHistorial;
    }

    public LocalDate getHora() {
        return hora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.numHistorial);
        hash = 61 * hash + Objects.hashCode(this.hora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HistorialNoEncontrado other = (HistorialNoEncontrado) obj;
        if (!Objects.equals(this.numHistorial, other.numHistorial)) {
            return false;
        }
        return Objects.equals(this.hora, other.hora);
    }

    @Override
    public String toString() {
        return "Historial no encontrado: " + numHistorial + ", hora de búsqueda: " + hora+".";
    }
    
    
    
}
