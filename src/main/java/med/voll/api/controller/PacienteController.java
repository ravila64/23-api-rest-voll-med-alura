package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.DatosActualizarPaciente;
import med.voll.api.paciente.DatosListaPaciente;
import med.voll.api.paciente.DatosRegistroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
   @Autowired
   private PacienteRepository repository;

   //registrar paciente
   @Transactional
   @PostMapping
   public void registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datos){
      repository.save(new Paciente(datos));
      System.out.println("Paciente grabado \n"+datos);
   }
   // listar pacientes
   @GetMapping
   public Page<DatosListaPaciente> listar(@PageableDefault(page=0, size=10,sort = {"nombre"} ) Pageable page){
      return repository.findAllByActivoTrue(page).map(DatosListaPaciente::new);
      //return repository.findAll(pagina).map(DatosListaPaciente::new);
   }

   @PutMapping
   @Transactional
   public void actualizar(@RequestBody @Valid DatosActualizarPaciente datos) {
      var paciente = repository.getReferenceById(datos.id());
      paciente.actualizarDatos(datos);
   }

   @DeleteMapping("/{id}")
   @Transactional
   public void eliminar(@PathVariable Long id) {
      var paciente = repository.getReferenceById(id);
      paciente.desactivar();
   }
}
