package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//MedicoController mc = new MedicoController();


@RestController
@RequestMapping("/hello")
public class HelloController {
   @GetMapping
   public String hello(){
      //System.out.println(mc.registrarMedico());
      return "Hello World !!!";

   }
}
