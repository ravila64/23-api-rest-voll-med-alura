package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// utiliza lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {
   private String calle;
   private String numero;
   private String complemento;
   private String barrio;
   private String ciudad;
   private String codigo_postal;
   private String estado;

   public Direccion(DatosDireccion datosDireccion) {
      this.calle=datosDireccion.calle();
      this.numero=datosDireccion.numero();
      this.complemento=datosDireccion.complemento();
      this.barrio=datosDireccion.barrio();
      this.ciudad=datosDireccion.ciudad();
      this.codigo_postal=datosDireccion.codigo_postal();
      this.estado=datosDireccion.estado();
   }

   public void actualizarDireccion(DatosDireccion direc) {
      if(direc.calle()!=null){
         this.calle = direc.calle();
      }
      if(direc.numero()!=null){
         this.numero = direc.numero();
      }
      if(direc.complemento()!=null){
         this.complemento = direc.complemento();
      }
      if(direc.barrio()!=null){
         this.barrio = direc.barrio();
      }
      if(direc.ciudad()!=null){
         this.ciudad = direc.ciudad();
      }
      if(direc.codigo_postal()!=null){
         this.codigo_postal = direc.codigo_postal();
      }
      if(direc.estado()!=null){
         this.estado = direc.estado();
      }

   }
}
