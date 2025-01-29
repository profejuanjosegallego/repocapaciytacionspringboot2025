package com.example.ProyectoSpringboot.controladores;

import com.example.ProyectoSpringboot.modelos.Usuario;
import com.example.ProyectoSpringboot.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    //inyectar dependencia al servicio
    @Autowired
    private ServicioUsuario servicioUsuario;

    //listar los metodos para responder
    //y atender cada uno de los servicios
    //programados

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario datosEnviados)throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicioUsuario.guardarUsuario(datosEnviados));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosUsuarios()throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioUsuario.buscarTodosUsuarios());
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id)throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioUsuario.buscarUsuarioPorId(id));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Integer id, @RequestBody Usuario datosNuevos)throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioUsuario.modificarUsuario(id,datosNuevos));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id)throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicioUsuario.eliminarUsuario(id));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
