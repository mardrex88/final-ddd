package tarea.events;

import tarea.values.ContactoId;
import tarea.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;


public class ContactoCreado extends DomainEvent {
    protected ContactoId contactoId;
    private final Telefono telefono;
    private final String nombre;

    public ContactoCreado( ContactoId contactoId, Telefono telefono, String nombre) {
        super("ContactoCreado");
        this.contactoId = contactoId;
        this.telefono = telefono;
        this.nombre = nombre;
    }


    public Telefono getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public ContactoId getContactoId() {
        return contactoId;
    }
}
