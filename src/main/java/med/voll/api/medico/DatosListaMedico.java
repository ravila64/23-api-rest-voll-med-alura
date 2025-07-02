package med.voll.api.medico;

public record DatosListaMedico(
      Long id,
      String nombre,
      String email,
      String documento,
      Especialidad especialidad,
      String telefono  // no va en trello
) {
   public DatosListaMedico(Medico medico) {
      this( medico.getId(),
            medico.getNombre(),
            medico.getEmail(),
            medico.getDocumento(),
            medico.getEspecialidad(),
            medico.getTelefono());  // no va en trello
   }
}
