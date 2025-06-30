package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;
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
      this.nombre = datos.nombre();
      this.email = datos.email();
      this.telefono = datos.telefono();
      this.documento = datos.documento();
      this.especialidad = datos.especialidad();
      this.direccion = new Direccion(datos.direccion());
   }
}
