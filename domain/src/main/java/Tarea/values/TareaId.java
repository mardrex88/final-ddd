package tarea.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class TareaId extends Identity {

    public TareaId(String id) {
        super(id);
    }

    public static TareaId of(String id){ return new TareaId(id);}

}
