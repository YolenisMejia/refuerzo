package co.edu.unab.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        cliente.setNombre(cliente.getNombre().toLowerCase()); 
        cliente.setApellido(cliente.getApellido().toLowerCase());
        return clienteRepository.save(cliente);
    }

    public boolean eliminarCliente(String id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }      
                             
    }      
    public Optional<ClienteModel> obtenerClientePorId(String id){
        return clienteRepository.findById(id);
    }  
    
    public ArrayList<ClienteModel> obtenerPorNombre(String nombre){
        return clienteRepository.findByNombre(nombre.toLowerCase());
    }

    public ArrayList<ClienteModel> obtenerPorNombreyApellido(String nombre, String apellido){
        return clienteRepository.findByNombreApellido(nombre.toLowerCase(), apellido.toLowerCase());
    }
    
   public ArrayList<ClienteModel> obtenerClientePorCiudad(String ciudad){
       return clienteRepository.clientesPorCiudad(ciudad.toLowerCase());
   }

   public ArrayList<ClienteModel> obtenerClientePorCiudadYDepartamento(String ciudad, String departamento){
       return clienteRepository.clientesPorCiudadyDepartamento(ciudad.toLowerCase(), departamento.toLowerCase());
   }

   public ArrayList<ClienteModel> obtenerClientesMayorIgualPuntos(Long puntos){
       return clienteRepository.findByPuntosGreaterThanEqual(puntos);
   }
  public ArrayList<ClienteModel> obtenerClientesMenorIgualPuntos(Long puntos){
      return clienteRepository.findByPuntosLessThanEqual(puntos);
  }

}