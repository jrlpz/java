package model;

import datos.DAO_citas;
import excepciones.HistorialNoEncontrado;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utilidades.UtilFechas.convertirFechaHora;

/**
 *
 * @author
 */
public class GestionCentro implements Gestionable {

    private ArrayList<Citable> citas; //constructor que inicializa la copia en un metodo
    private ArrayList<Paciente> pacientes;
    ArrayList<Analisis> analisis = new ArrayList();
    String resultado = "";
    Paciente paciente;

    public GestionCentro(ArrayList<Citable> citas) {
        this.citas = citas;

    }

    @Override
    public ArrayList<ConsultaMedica> devolverListaConsultasMedico() {
        ArrayList<ConsultaMedica> clon = new ArrayList();

        for (Citable c : citas) {
            if (c instanceof ConsultaMedica) {
                clon.add(new ConsultaMedica((ConsultaMedica) c));
            }
        }
        return clon;
    }

    @Override
    public ArrayList<ConsultaMedica> devolverConsultasMedicoOrdenadas() {
        ArrayList<ConsultaMedica> clon = devolverListaConsultasMedico();
        Collections.sort(clon);
        return clon;
    }

    @Override
    public String mostrarDetallesConsultaMedica(String numHistorial) {
        StringBuilder sb = new StringBuilder();
        for (Citable c : citas) {
            if (c instanceof ConsultaMedica) {
                if (((ConsultaMedica) c).getPaciente().getNumHistorial().equals(numHistorial)) {
                    sb.append(c.toString());

                }
            }
        }

        return sb.toString();
    }

    @Override
    public String imprimirTicket(String numHistorial) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;

        for (Citable c : citas) {

            if (c instanceof ConsultaMedica) {
                contador1++;//es consulta
                if (((ConsultaMedica) c).getPaciente().getNumHistorial().equals(numHistorial)) {
                    contador3++;//coincide
                    sb.append("PACIENTE " + ((ConsultaMedica) c).getPaciente().getNumHistorial());
                    sb.append("\n");
                    sb.append("CONSULTA MEDICA EN SALA " + ((ConsultaMedica) c).getSala());
                    sb.append("\n");
                    sb.append("CITADO " + convertirFechaHora(((ConsultaMedica) c).getHoraCita()));
                    sb.append("\n");
                    sb.append("\n");

                } else {
                    contador2++;//no coincide
                }
            }

        }
//        System.out.println(" (Contador1) Es consulta " + contador1);
//        System.out.println(" (Contador2) No coincide " + contador2);
//        System.out.println(" (Contador3)    Coincide " + contador3);
//        System.out.println("Si 3 mayor que 0 existe");
//        System.out.println("Si 1 = 2 no existe");

        if (contador3 > 0) {
            sb2.append("IMPRIMIR TICKET DE CITA");
            sb2.append("\n");
            sb2.append(sb);
        } else if (contador1 == contador2) {
            sb2.append("EL NÚMERO DE HISTORIAL NO EXISTE");
        }

        return sb2.toString();
    }

    @Override
    public ArrayList<ConsultaMedica> buscarCitas(Paciente paciente) {
        ArrayList<ConsultaMedica> clon = new ArrayList();
        for (Citable c : citas) {
            if (c instanceof ConsultaMedica) {

                if (paciente.getNumHistorial().equals(((ConsultaMedica) c).getPaciente().getNumHistorial())) {

                    if (paciente.getNombreApellidos().equals(((ConsultaMedica) c).getPaciente().getNombreApellidos())) {
                        if (paciente.getEdad() == (((ConsultaMedica) c).getPaciente().getEdad())) {
                            clon.add(new ConsultaMedica((ConsultaMedica) c));
                        }
                    }
                }
            }

        }
        return clon;
    }

    @Override
    public Analisis buscarAnalisis(String numHistorial) throws HistorialNoEncontrado {

        Analisis analisis = null;
        boolean bandera = false;
        for (Citable c : citas) {
            if (c instanceof Analisis) {
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
