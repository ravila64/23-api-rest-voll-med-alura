package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico(
      @NotBlank String nombre,
      @NotBlank @Email String email,
      @NotBlank String telefono,
      @NotBlank @Pattern(regexp ="\\d{6,10}") String documento,
      @NotNull Especialidad especialidad,
      @NotNull @Valid DatosDireccion direccion
) {
   @Override
   public String toString() {
      return "DatosRegistroMedico{" +
            "Nombre='" + nombre +"\'"+
            ", email='" + email + "\'"+
            ", telefono='" + telefono + "\'"+
            ", documento='" + documento + "\'"+
            ", especialidad=" + especialidad + '\n' +
            "Direccion=" + direccion +
            '}';
   }
}
