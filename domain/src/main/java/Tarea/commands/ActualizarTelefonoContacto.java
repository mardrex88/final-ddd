package tarea.commands;

import co.com.sofka.domain.generic.Command;
import tarea.values.ContactoId;
import tarea.values.TareaId;
import tarea.values.Telefono;

public class ActualizarTelefonoContacto extends Command {

    private final TareaId tareaId;
    private final ContactoId contactoId;
    private final Telefono telefono;

    public ActualizarTelefonoContacto(TareaId tareaId, ContactoId contactoId, Telefono telefono) {
        this.tareaId = tareaId;
        this.contactoId = contactoId;
        this.telefono = telefono;
    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public ContactoId getContactoId() {
        return contactoId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
