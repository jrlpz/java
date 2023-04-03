package centrosalud;

import datos.DAO_citas;
import excepciones.HistorialNoEncontrado;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Citable;
import model.GestionCentro;
import model.Paciente;

public class TestMain {

    public static void main(String[] args) {
        //COMPLETAR CÓDIGO    
        ArrayList<Citable> citasTotales = DAO_citas.selectCitasHoy();
        GestionCentro g = new GestionCentro(citasTotales);
        Paciente paciente = new Paciente("NH000001", "nombreapellidos1", 21);
        System.out.println("MOSTRAR TODAS LAS CONSULTAS MÉDICAS ");
        System.out.println(g.devolverListaConsultasMedico());
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("");

        System.out.println("MOSTRAR TODAS LAS CONSULTAS MÉDICAS ORDENADAS");
        System.out.println(g.devolverConsultasMedicoOrdenadas());
        System.out.println("__________________________________________________________________________________________________");

        System.out.println("");

        System.out.println("MOSTRAR TODAS LOS DETALLES DE LAS CONSULTAS MÉDICAS DEL PACIENTE CON NÚMERO DE HISTORIAL NH000001 ");
        System.out.println(g.mostrarDetallesConsultaMedica("NH000001"));
        System.out.println("__________________________________________________________________________________________________");

        System.out.println("");

        System.out.println("MOSTRAR TODAS LOS DETALLES DE LAS CONSULTAS MÉDICAS DEL PACIENTE CON NÚMERO DE HISTORIAL NH000025 ");
        System.out.println(g.mostrarDetallesConsultaMedica("NH000025"));
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("");

        System.out.println("IMPRIMIR TICKET DE CITA");
        System.out.println(g.imprimirTicket("NH000001"));
        System.out.println("__________________________________________________________________________________________________");

        System.out.println("");

        System.out.println("MOSTRAR CITAS DE UN PACIENTE CON NÚMERO DE HISTORIAL NH000001 Y  nombreapellidos1 Y EDAD 21 AÑOS");
        System.out.println(g.buscarCitas(paciente));
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("");

        System.out.println("MOSTRAR CITA DE ANÁLISIS PARA EL NÚMERO DE HISTORIAL  NH000001");
        try {
            System.out.println(g.buscarAnalisis("NH000001"));
        } catch (HistorialNoEncontrado ex) {
            System.out.println(ex.toString());
        }
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("");

        System.out.println("MOSTRAR CITA DE ANÁLISIS PARA EL NÚMERO DE HISTORIAL  NH0000025");
        try {
            System.out.println(g.buscarAnalisis("NH000025"));
        } catch (HistorialNoEncontrado ex) {
            System.out.println(ex.toString());
        }
        System.out.println("__________________________________________________________________________________________________");

    }

}
