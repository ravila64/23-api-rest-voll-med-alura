package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
   @Autowired
   private PacienteRepository repository;
   @PutMapping
   @Transactional
   public void atualizar(@RequestBody @Valid DatosActualizacionPaciente datos) {
      var paciente = repository.getReferenceById(datos.id());
      paciente.atualizarInformacion(datos);
   }

   @DeleteMapping("/{id}")
   @Transactional
   public void eliminar(@PathVariable Long id) {
      var paciente = repository.getReferenceById(id);
      paciente.desactivar();
   }
}
