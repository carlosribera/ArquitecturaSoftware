package Negocio;

import Datos.DMecanico;
import Datos.PatronPlantilla.ListarPorID;
import Datos.PatronPlantilla.ListarTodos;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class NMecanico {
     private DMecanico dmecanico;

    public NMecanico() {
       // this.dmecanico = new DMecanico();
       this.dmecanico = new ListarPorID();
    }
    public void agregar(String nombre,String apPaterno,String apMaterno, int telefono, int idEspecialidad){
        this.dmecanico.setNombre(nombre);
        this.dmecanico.setApPaterno(apPaterno);
        this.dmecanico.setApMaterno(apMaterno);
        this.dmecanico.setTelefono(telefono);
        this.dmecanico.setIdEspecialidad(idEspecialidad);        
        this.dmecanico.agregar();
    }
    
    public void modificar(int id,String nombre, String apPaterno,String apMaterno, int telefono, int idEspecialidad){
        this.dmecanico.setIdMecanico(id);
        this.dmecanico.setNombre(nombre);
        this.dmecanico.setApPaterno(apPaterno);
        this.dmecanico.setApMaterno(apMaterno);
        this.dmecanico.setTelefono(telefono);
        this.dmecanico.setIdEspecialidad(idEspecialidad);        
        this.dmecanico.modificar();
    }
    
    public void eliminar(int id){
        this.dmecanico.setIdMecanico(id);
        this.dmecanico.eliminar();
    }
    
    public ArrayList listar(){
       dmecanico = new ListarTodos();
       return this.dmecanico.MetodoTemplate_listar();               
    }
    
    public ArrayList listar(int idespecialidad){
//        System.out.println("negocio "+idespecialidad);
        this.dmecanico = new ListarPorID();
        this.dmecanico.setIdEspecialidad(idespecialidad);
        return this.dmecanico.MetodoTemplate_listar();
    }
}
