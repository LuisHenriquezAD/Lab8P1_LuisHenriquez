
package lab8p1_luishenriquez;


public class Libro {
        String titulo;
        String escritor;
        int publicacion;
        
        public Libro(String titulo, String escritor, int publicacion) {
        this.titulo = titulo;
        this.escritor = escritor;
        this.publicacion = publicacion;
    }
        
        
        public String titulo(){
        return titulo;
        }
        
        public String escritor(){
        return escritor;    
        }
        
        public int publicacion(){
        return publicacion;    
        }
        
        
}
