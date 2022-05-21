package tarea.commands;

import tarea.Contacto;
import tarea.Destino;
import tarea.values.TareaId;
import co.com.sofka.domain.generic.Command;

public class CrearTarea extends Command {

    private TareaId tareaId;
    protected Contacto contacto;
    protected Destino destino;
    protected final String estado;

    public CrearTarea(TareaId tareaId, Contacto contacto, Destino destino, String estado) {
        this.tareaId = tareaId;
        this.contacto = contacto;
        this.destino = destino;
        this.estado = estado;
    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public Destino getDestino() {
        return destino;
    }

    public String getEstado() {
        return estado;
    }
}
