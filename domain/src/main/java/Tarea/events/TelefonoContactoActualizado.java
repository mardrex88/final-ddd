package tarea.events;

import co.com.sofka.domain.generic.DomainEvent;
import tarea.values.ContactoId;
import tarea.values.Telefono;

public class TelefonoContactoActualizado extends DomainEvent {

    private final ContactoId contactoId;
    private final Telefono telefono;


    public TelefonoContactoActualizado( ContactoId contactoId,Telefono telefono) {
        super("TelefonoContactoActualizado");
        this.contactoId = contactoId;
        this.telefono = telefono;
    }

    public ContactoId getContactoId() {
        return contactoId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
