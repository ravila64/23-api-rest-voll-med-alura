package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico(
      String nombre,
      String email,
      String documento,
      Especialidad especialidad,
      DatosDireccion direccion
) {
   @Override
   public String toString() {
      return "DatosRegistroMedico{" +
            "Nombre='" + nombre +
            ", email='" + email +
            ", documento='" + documento +
            ", especialidad=" + especialidad + '\n' +
            "Direccion=" + direccion +
            '}';
   }
}
