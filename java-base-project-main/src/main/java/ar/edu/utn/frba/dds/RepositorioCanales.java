package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioCanales {
    private List<Canal> canales=new ArrayList<>();
    private static final RepositorioCanales instance = new RepositorioCanales();

    public List<Canal> listarCanales(){
        return this.canales;
    }

    public static RepositorioCanales getInstancia() {
        return instance;
    }
    public Canal buscarCanal(Canal canal){
        return this.canales.stream().filter(c -> c.equals(canal))
            .findFirst()
            .orElseThrow(()-> new RuntimeException("No existe el canal"));

    }

    public List<Transmision> listarTransmisionesHistoricas(Canal canal){
       return this.buscarCanal(canal).getTransmisionesHistoricas();
    }
    public void agregarCanal(Canal canal){
        this.canales.add(canal);
    }
    public void eliminarCanal(Canal canal){
        this.canales.remove(canal);
    }
    public List<Transmision> listarTransmisionesEnVivo(){
        return this.canales.stream().filter(c->c.hayTransmisionEnVivo())
            .map(c->c.getTransmisionEnVivo()).toList();
    }

}
