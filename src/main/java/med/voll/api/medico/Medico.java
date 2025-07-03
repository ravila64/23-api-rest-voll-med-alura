package med.voll.api.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

import java.sql.Array;

// crear la tabla medicos
@Table(name="medicos")
@Entity(name="Medico")
// utiliza lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Medico {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private boolean activo;
   private String nombre;
   private String email;
   private String telefono;
   private String documento;

   @Enumerated(EnumType.STRING)
   private Especialidad especialidad;

   // embebido queda la tabla de direccion dentro de medicos
   @Embedded
   private Direccion direccion;

   public Medico(DatosRegistroMedico datos) {
      this.id = null;
      this.activo=true;
      this.nombre = datos.nombre();
      this.email = datos.email();
      this.telefono = datos.telefono();
      this.documento = datos.documento();
      this.especialidad = datos.especialidad();
      this.direccion = new Direccion(datos.direccion());
   }

   public void actualizarDatos(@Valid DatosActualizarMedico datos) {
      boolean[] actualizo = {false, false, false};
      String[] campos = {"nombre","telefono","direccion"};
      if(datos.nombre()!=null){
         this.nombre = datos.nombre();
         actualizo[0]=true;
      }

      if(datos.telefono()!=null){
         this.telefono = datos.telefono();
         actualizo[1]=true;
      }

      if(datos.direccion()!=null){
         this.direccion.actualizarDireccion(datos.direccion());
         actualizo[2]=true;
      }

      String str="";
      for (int i = 0; i < actualizo.length ; i++) {
         if(actualizo[i]){
            str=str+campos[i]+" - ";
         }
      }
      System.out.println("Actualizo campos en medicos "+str);

   }

   public void eliminar() {
      this.activo = false;
   }

}
