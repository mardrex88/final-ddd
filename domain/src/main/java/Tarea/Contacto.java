package Tarea;

import Tarea.values.ContactoId;
import Tarea.values.Telefono;
import co.com.sofka.domain.generic.Entity;

public class Contacto extends Entity<ContactoId> {
    private Telefono telefono;
    private final String nombre;

    public Contacto(ContactoId entityId, Telefono telefono, String nombre) {
        super(entityId);
        this.telefono = telefono;
        this.nombre = nombre;
    }

}
