
package listasimples.estudiantesu;

/**
 *
 * @author luis
 */
public class Lista {
    private Nodo cabeza;
    
    public Lista()
    {
        cabeza = null;
    }
    
    public void setCabeza(Nodo n){
        cabeza = n;
    }
    public Nodo getCabeza(){
        return cabeza; 
    }
    
    public boolean validarId(int c)
    {
        Nodo temp = cabeza;
        boolean igual = false;
        
        while(temp != null){
            if(temp.getId() == c){
                igual  =    true;
                break;
            }
            temp = temp.getSiguiente();
        }
        
        return igual;        
    }    
    
    public Nodo ultimo()
    {
        Nodo temp = cabeza;
        while(temp != null)
        {
            if (temp.getSiguiente() == null)
            {
                break; 
            }
            else
            {
                temp = temp.getSiguiente(); 
            }
        }
       
        return temp; 
    }
    
    public int contarNodos(){
        Nodo temp = cabeza;
        int cont = 0;
        
        while (temp !=  null){
            cont++;
            temp = temp.getSiguiente();            
        }
        return cont;
    }
    
    public void agregarFinal(Nodo n){
      if(cabeza == null)
      {
            setCabeza(n);
        }else{
            ultimo().setSiguiente(n);
        }       
    }
    
     Nodo buscarId(int c)
    {
        Nodo temp = cabeza;
        while(temp != null)
        {
            if(temp.getId() == c)
            {
                break;
            }
            temp = temp.getSiguiente();
        }
        return temp;
    }
     
    public void ordenarAscendentemente(Nodo n)
    {
        Nodo actual, siguiente;        
        actual = n;
       
        while(actual.getSiguiente() != null){
           
            siguiente = actual.getSiguiente();
            
            while(siguiente != null)
            {
                if(actual.getSemestre() > siguiente.getSemestre())
                {
                    cambiar(actual, siguiente);
                }
                
                siguiente = siguiente.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
    }
    
    public void ordenarDescendentemente(Nodo n)
    {       
        Nodo actual, siguiente;
        actual = n;
        while(actual.getSiguiente() != null)
        {
            siguiente = actual.getSiguiente();
          
            while(siguiente != null)
            {
               
                if(actual.getSemestre() < siguiente.getSemestre())
                {
                    cambiar(actual, siguiente);
                }
                siguiente = siguiente.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
    }
    
    public void cambiar(Nodo p1, Nodo p2)
    {
        // creo un nuevo nodo para poder realizar la copia 
        Nodo temp = new Nodo();       
        temp.copiar(p1);        
        p1.copiar(p2);       
        p2.copiar(temp);
    }
    
    public float promedioGeneral(){
        
        Nodo temp = cabeza;
        float suma = 0;
        
        while (temp != null){
            suma+= temp.promedio();
            temp = temp.getSiguiente();
        }
        return suma/contarNodos();
    }
    
    public void eliminar(Nodo n)
    {
        Nodo anterior;
        if(n.promedio() == promedioGeneral())
        {
            if(n  == cabeza)
            {
                cabeza = cabeza.getSiguiente();
            }
            else
            {
                anterior = cabeza;
                while(anterior.getSiguiente() != n)
                {
                    anterior = anterior.getSiguiente();
                }
                anterior.setSiguiente(n.getSiguiente());
            }
            n.setSiguiente(null);
        }
    }
    
  
    public void limpiar()
    {
        while(cabeza != null)
        {
            eliminar(cabeza);
        }
    }
     
}
