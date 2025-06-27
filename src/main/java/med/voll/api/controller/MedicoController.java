package med.voll.api.controller;

import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/medicos")
public class MedicoController {
   @Autowired
   private MedicoRepository repositoryMed;

   @PostMapping
   public void registrarMedico(@RequestBody DatosRegistroMedico datos){
      //System.out.println(datos);
      repositoryMed.save(new Medico(datos));
   }
}
