
package model;


public class Paciente {
    
    private String numHistorial;
    private String nombreApellidos;
    private int edad; 

    public Paciente(String numHistorial, String nombreApellidos, int edad) {
        this.numHistorial = numHistorial;
        this.nombreApellidos = nombreApellidos;
        this.edad = edad;
    }
   public Paciente(Paciente paciente) {
        this.numHistorial = paciente.getNumHistorial();
        this.nombreApellidos = paciente.getNombreApellidos();
        this.edad = paciente.getEdad();
    }

    public String getNumHistorial() {
        return numHistorial;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Paciente{" + "numHistorial=" + numHistorial + ", nombreApellidos=" + nombreApellidos + ", edad=" + edad + '}';
    }

   
}
