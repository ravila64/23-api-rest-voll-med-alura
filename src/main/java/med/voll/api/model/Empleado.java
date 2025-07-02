package med.voll.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Empleado")
@Table(name = "empleados")
public class Empleado {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private String email;

   @JsonIgnore
   private BigDecimal salario;

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public BigDecimal getSalario() {
      return salario;
   }

   public void setSalario(BigDecimal salario) {
      this.salario = salario;
   }
}
