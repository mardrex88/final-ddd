package tarea;

import tarea.values.ContactoId;
import tarea.values.Telefono;
import co.com.sofka.domain.generic.Entity;

public class Contacto extends Entity<ContactoId> {
    protected Telefono telefono;
    protected String nombre;

    public Contacto(ContactoId entityId, Telefono telefono, String nombre) {
        super(entityId);
        this.telefono = telefono;
        this.nombre = nombre;
    }

}
