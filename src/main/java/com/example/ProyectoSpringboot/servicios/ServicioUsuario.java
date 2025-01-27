package com.example.ProyectoSpringboot.servicios;

import com.example.ProyectoSpringboot.modelos.Usuario;
import com.example.ProyectoSpringboot.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {

    //Inyectar una dependencia al repositorio
    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;

    //Un listado de metodos que
    //deben ser implementados
    //con los servicios a ofrecerle al cliente

    //guardar usuario
    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception{
        try{
            //Capa validaciones y Operaciones logica
            return this.iUsuarioRepositorio.save(datosUsuario);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //buscar todos los usuarios
    public List<Usuario> buscarTodosUsuarios() throws Exception{
        try{
            return this.iUsuarioRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //buscar un usuario por ID
    public Usuario buscarUsuarioPorId(Integer id) throws Exception{
        try{

            Optional<Usuario> usuarioEncontrado=this.iUsuarioRepositorio.findById(id);
            if(usuarioEncontrado.isPresent()){
                return usuarioEncontrado.get();
            }else{
                throw new Exception("Usuario No encontrado "+id);
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //buscar usuario nombre ***

    //modificarUsuario
    public Usuario modificarUsuario(Integer id, Usuario datosNuevosUsuario) throws Exception{
        try{
            Optional<Usuario> usuarioEncontrado= this.iUsuarioRepositorio.findById(id);
            if(usuarioEncontrado.isPresent()){
                //Entro a modificar el objeto usuario
                Usuario usuarioQueSiEsta=usuarioEncontrado.get(); //Datos viejos
                usuarioQueSiEsta.setCiudad(datosNuevosUsuario.getCiudad());
                usuarioQueSiEsta.setTelefono(datosNuevosUsuario.getTelefono());
                return this.iUsuarioRepositorio.save(usuarioQueSiEsta);
            }else{
                throw new Exception("Usuario No encontrado "+id);
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //eliminarUsuario
    public Boolean eliminarUsuario(Integer id) throws Exception{
        try{
            Optional<Usuario> usuarioEncontrado=this.iUsuarioRepositorio.findById(id);
            if(usuarioEncontrado.isPresent()){
                this.iUsuarioRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario No encontrado "+id);
            }

        }catch(Exception error){
            throw  new Exception(error.getMessage());

        }
    }

}
