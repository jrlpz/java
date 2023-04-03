/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import utilidades.UtilFechas;

/**
 *
 * @author idesadadaw
 */
public class ConsultaMedica implements Citable,Comparable<ConsultaMedica>{
    
    private Paciente paciente;
    private String sala; 
    private LocalDateTime horaCita;

    public ConsultaMedica(Paciente paciente, String sala, LocalDateTime horaCita) {
        this.paciente = paciente;
        this.sala = sala;
        this.horaCita = horaCita;
    }

      public ConsultaMedica(ConsultaMedica consulta) {
        this.paciente = consulta.getPaciente();
        this.sala = consulta.getSala();
        this.horaCita = consulta.getHoraCita();
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.horaCita);
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
        final ConsultaMedica other = (ConsultaMedica) obj;
        return Objects.equals(this.horaCita, other.horaCita);
    }

    public LocalDateTime getHoraCita() {
        return horaCita;
    }

    public Paciente getPaciente() {
       
        return paciente;
    }

    public String getSala() {
        return sala;
    }

   

    @Override
    public String consultarDetalle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public int compare(ConsultaMedica t, ConsultaMedica t1) {
//        String fecha = UtilFechas.convertirFechaHora(this.getHoraCita());
//        String fecha2 = UtilFechas.convertirFechaHora(t.getHoraCita());
//        return fecha.compareTo(fecha2);
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nConsulta médica:");
   
        sb.append("\npaciente=").append(paciente.toString());
        sb.append(",\nsala=").append(sala);
        sb.append(",\nhoraCita=").append(horaCita+ "\n");
     
        return sb.toString();
    }

    @Override
    public int compareTo(ConsultaMedica t) {
         String fecha = UtilFechas.convertirFechaHora(this.getHoraCita());
        String fecha2 = UtilFechas.convertirFechaHora(t.getHoraCita());
        return fecha.compareTo(fecha2);
    }

   
   

   
    

    

    
}
