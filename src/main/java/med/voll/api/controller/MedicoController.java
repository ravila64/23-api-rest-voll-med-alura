package med.voll.api.controller;

import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/medicos")
public class MedicoController {
   @Autowired
   private MedicoRepository repository;

   @Transactional
   @PostMapping
   public void registrarMedico(@RequestBody DatosRegistroMedico datos){
      repository.save(new Medico(datos));
      //System.out.println(datos);
   }
}
