package tarea;

import tarea.events.ContactoCreado;
import tarea.events.TareaCreada;
import co.com.sofka.domain.generic.EventChange;

public class TareaEventChange extends EventChange {
    public TareaEventChange(Tarea tarea) {
        apply((TareaCreada event) -> {

        });

        apply((ContactoCreado event) -> {
        var contactoId = event.getContactoId();
        var contacto = new Contacto(contactoId,event.getTelefono(), event.getNombre());
        tarea.contacto = contacto;
        });

    }


}
