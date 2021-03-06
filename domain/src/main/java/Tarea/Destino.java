package tarea;

import tarea.values.Coordenadas;
import tarea.values.DestinoId;
import tarea.values.Direccion;
import co.com.sofka.domain.generic.Entity;

public class Destino extends Entity<DestinoId>  {
    private Direccion direccion;
    protected Coordenadas coordenadas;

    public Destino(DestinoId entityId, Direccion direccion, Coordenadas coordenadas) {
        super(entityId);
        this.direccion = direccion;
        this.coordenadas = coordenadas;
    }

}
