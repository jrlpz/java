package model;

import datos.DAO_citas;
import excepciones.HistorialNoEncontrado;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import static utilidades.UtilFechas.convertirFechaHora;

/**
 *
 * @author
 */
public class GestionCentro implements Gestionable{

    private ArrayList<Citable> citas; //constructor que inicializa la copia en un metodo

    public GestionCentro(ArrayList<Citable> citas) {
        this.citas = citas;
    }

    @Override
    public ArrayList<ConsultaMedica> devolverListaConsultasMedico() {
        ArrayList<ConsultaMedica> consultas = new ArrayList();
        for (Citable c : citas) {
            if (c instanceof ConsultaMedica) {
                consultas.add((ConsultaMedica) c);
            }
        }
        return consultas;
    }

    @Override
    public ArrayList<ConsultaMedica> devolverConsultasMedicoOrdenadas() {
        ArrayList<ConsultaMedica> consultas = new ArrayList();
        for (Citable c : citas) {
            if (c instanceof ConsultaMedica) {
                consultas.add((ConsultaMedica) c);
            }
        }
        Collections.sort(consultas);
        return consultas;
    }

    @Override
    public String mostrarDetallesConsultaMedica(String numHistorial) {
        int contador = 0;
        int contador2 = 0;
        StringBuilder sb = new StringBuilder();
        for (Citable c : citas) {
            if (c instanceof ConsultaMedica) {
                contador++; //totales
                if (((ConsultaMedica) c).getPaciente().getNumHistorial().equals(numHistorial)) {

                    sb.append(c.toString());
                } else {
                    contador2++; //las que no
                }
            }

        }
        if (contador2 == contador) {
            sb.append("Número de historia no existe.");
        }
        return sb.toString();
    }

    @Override
    public String imprimirTicket(String numHistorial) {

        int contador = 0;
        int contador2 = 0;
        int contador3 = 0;

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Citable c : citas) {
            if (c instanceof ConsultaMedica) {
                contador++; //totales
                if (((ConsultaMedica) c).getPaciente().getNumHistorial().equals(numHistorial)) {
                    
                   sb.append("PACIENTE " + ((ConsultaMedica) c).getPaciente().getNumHistorial());
                    sb.append("\n");
                    sb.append("CONSULTA MEDICA EN SALA " + ((ConsultaMedica) c).getSala());
                    sb.append("\n");
                    sb.append("CITADO " +convertirFechaHora( ((ConsultaMedica) c).getHoraCita()));
                    sb.append("\n");
                 sb.append("\n");
                 contador2++;
                 
                } else {
                    contador3++; //las que no
                }
            }

        }
        System.out.println("Contador " + contador);
          System.out.println("Contador2 " + contador2);
            System.out.println("Contador3 " + contador3);
              if (contador2>0) {
            sb2.append(sb.toString());
        }
        if (contador3 == contador) {
            sb2.append("Número de historia no existe.");
        }
        return sb2.toString();
    }

    @Override
    public ArrayList<ConsultaMedica> buscarCitas(Paciente paciente) {
        
        ArrayList<ConsultaMedica> consultas = new ArrayList<ConsultaMedica>();
        for (Citable c :citas) {
            if (c instanceof  ConsultaMedica) {
                if(((ConsultaMedica) c).getPaciente().getNumHistorial().equals(paciente.getNumHistorial())){
                      if(((ConsultaMedica) c).getPaciente().getEdad()==(paciente.getEdad())){
                          consultas.add((ConsultaMedica) c);
                      }
                    }
            }
            }
                return consultas;
        }
    

    @Override
    public Analisis buscarAnalisis(String numHistorial) throws HistorialNoEncontrado {
    Analisis analisis = null;
     boolean bandera = false;
    for(Citable c: citas){
        if (c instanceof  Analisis) {
            if (((Analisis) c).getNumHistorial().equals(numHistorial)) {
                analisis = (Analisis) c;
           bandera = true;
            }
        }
    }
            if (!bandera) {
            throw new HistorialNoEncontrado(numHistorial, LocalDate.now());
        }
            
        return analisis;
    }
    
}
