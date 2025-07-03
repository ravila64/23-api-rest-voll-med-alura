package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

// crear la tabla pacientes
@Table(name="pacientes")
@Entity(name="Paciente")
// utiliza lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Paciente {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private String email;
   private String telefono;
   private String documento;
   // embebido queda la tabla de direccion dentro de medicos
   @Embedded
   private Direccion direccion;
   private boolean activo;

   public Paciente(DatosRegistroPaciente paciente) {
     // this.id = null;
      this.activo = true;
      this.nombre = paciente.nombre();
      this.email = paciente.email();
      this.telefono = paciente.telefono();
      this.documento = paciente.documento();
      this.direccion = new Direccion(paciente.direccion());
   }

   // actualiza paciente, valida si tiene datos los campos
   public void actualizarDatos(@Valid DatosActualizarPaciente datos) {
      if(datos.nombre()!=null){
         this.nombre = datos.nombre();
      }

      if(datos.telefono()!=null){
         this.telefono = datos.telefono();
      }

      if(datos.direccion()!=null){
         this.direccion.actualizarDireccion(datos.direccion());
      }
   }

   public void desactivar() {
      this.activo = false;
   }

}
