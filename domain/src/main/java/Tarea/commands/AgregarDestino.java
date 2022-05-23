package tarea.commands;

import co.com.sofka.domain.generic.Command;
import tarea.values.Coordenadas;
import tarea.values.DestinoId;
import tarea.values.Direccion;
import tarea.values.TareaId;

public class AgregarDestino extends Command {

    protected TareaId tareaId;

    private final  Direccion direccion;
    private final  Coordenadas coordenadas;

    public AgregarDestino(TareaId tareaId,Direccion direccion, Coordenadas coordenadas) {
        this.tareaId = tareaId;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
    }



    public Direccion getDireccion() {
        return direccion;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public TareaId getTareaId() {
        return tareaId;
    }
}
