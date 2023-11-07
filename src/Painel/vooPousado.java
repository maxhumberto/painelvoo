package Painel;
import java.time.LocalDateTime;

public class vooPousado {
    private voo voo;
    private LocalDateTime horarioDePouso;

    public vooPousado(voo voo) {
        this.voo = voo;
        this.horarioDePouso = LocalDateTime.now();
    }
 
  
   

 public vooPousado(voo voo, LocalDateTime horarioDePouso) {
	 	 this.voo = voo;	
         this.horarioDePouso = horarioDePouso;
         
        }

public LocalDateTime getHorarioDePouso() {
            return this.horarioDePouso;
        }
    
    public voo getVoo() {
        return this.voo;
    }
}