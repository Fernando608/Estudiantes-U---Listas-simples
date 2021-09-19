
package listasimples.estudiantesu;

/**
 *
 * @author luis
 */
public class Nodo {
    
    private int id;
    private String nombre;
    private int semestre;
    private float notas [];
    private Nodo siguiente;


    public Nodo(){
    
        id =0;
        nombre = "";
        semestre =0;
        notas = new float [3];
        siguiente = null;
    }
    
    //Setters
    public void setId (int val){
        id = val;
    }
    public void setNombre(String val){
        nombre = val;
    }    
    public void setSemestre (int val){
        semestre = val;
    }
    public void setNotas(int pos, float val){
        notas[pos] = val;
    }
    public void setSiguiente (Nodo val){
        siguiente = val;
    }
    
    //Getters
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getSemestre (){
       return semestre;
    }
    public float getNotas(int pos){
        return notas[pos];
    }
    public Nodo getSiguiente (){
        return siguiente;
    } 
    
    //copiar la información de un nodo
    public void copiar(Nodo nd)
    {
        id = nd.getId();
        nombre = nd.getNombre();
        semestre = nd.getSemestre();
        for(int i =0;i < 3; i++){
            notas[i] = nd.getNotas(i);
        }
        
    }
    
    public float promedio(){
        float sum = 0;
        for(int i = 0;i < 3;i++){
            sum += getNotas(i);
        }
        return sum;
    }
    
    
}
