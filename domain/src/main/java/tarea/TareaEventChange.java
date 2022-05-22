package tarea;

import tarea.events.ContactoCreado;
import tarea.events.DestinoCreado;
import tarea.events.TareaCreada;
import co.com.sofka.domain.generic.EventChange;
import tarea.events.TelefonoContactoActualizado;

public class TareaEventChange extends EventChange {
    public TareaEventChange(Tarea tarea) {
        apply((TareaCreada event) -> {

        });

        apply((ContactoCreado event) -> {
        var contactoId = event.getContactoId();
        var contacto = new Contacto(contactoId,event.getTelefono(), event.getNombre());
        tarea.contacto = contacto;
        });

        apply((DestinoCreado event) -> {
            var destinoId = event.getDestinoId();
            var destino = new Destino(destinoId,event.getDireccion(), event.getCoordenadas());
            tarea.destino = destino;
        });

        apply((TelefonoContactoActualizado event) -> {
            tarea.contacto.actualizarTelefono(event.getTelefono());
        });
    }


}
