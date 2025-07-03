package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosActualizarMedico;
import med.voll.api.medico.DatosListaMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;  // para este caso de paginacion, reemplazo por Page, en listar()

@RestController
@RequestMapping("/medicos")
public class MedicoController {
   @Autowired
   private MedicoRepository repository;

   @Transactional
   @PostMapping
   public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datos){
      repository.save(new Medico(datos));
      System.out.println("Registro grabado \n"+datos);
   }

   @GetMapping
   public Page<DatosListaMedico> listar(@PageableDefault(size=10,sort = "nombre") Pageable pageable){
      return repository.findAllByActivoTrue(pageable).map(DatosListaMedico::new);
      //return repository.findAll(pageable).map(DatosListaMedico::new);
   }
   //return repository.findAll(pageable).stream().map(DatosListaMedico::new).toList();
   //cuando se maneja List()

   @Transactional
   @PutMapping
   public void actualizar(@RequestBody @Valid DatosActualizarMedico datos){
      var medico = repository.getReferenceById(datos.id());
      medico.actualizarDatos(datos); // se ejecuta dentro de una transaccion y no necesita save
      System.out.println("Medico actualizado \n"+datos);
   }

// se utiliza si es eliminado fisico
//   @Transactional
//   @DeleteMapping("/{id}")
//   public void eliminar(@PathVariable Long id){
//      repository.deleteById(id); // elimina un medico fisico de la bd
//   }

   @Transactional
   @DeleteMapping("/{id}")
   public void eliminar(@PathVariable Long id){
      var medico = repository.getReferenceById(id);
      medico.eliminar(); // elimina un medico fisico de la bd
      System.out.println("Medico no activo en base de datos");
   }
}
