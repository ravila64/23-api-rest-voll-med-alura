package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

// crear la tabla medicos
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
   private boolean activo;
   private String nombre;
   private String email;
   private String telefono;
   private String documento;
   // embebido queda la tabla de direccion dentro de medicos
   @Embedded
   private Direccion direccion;

}
