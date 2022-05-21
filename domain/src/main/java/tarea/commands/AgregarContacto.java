package tarea.commands;

import tarea.values.TareaId;
import tarea.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class AgregarContacto extends Command {
    protected TareaId tareaId;
    private final Telefono telefono;
    private final String nombre;

    public AgregarContacto(TareaId tareaId, Telefono telefono, String nombre) {
        this.tareaId = tareaId;
        this.telefono = telefono;
        this.nombre = nombre;

    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }
}
