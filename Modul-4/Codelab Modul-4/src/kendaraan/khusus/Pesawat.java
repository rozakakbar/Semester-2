package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.Flyable;

public class Pesawat extends Kendaraan implements Flyable {

    public void Start() {
        System.out.println("Mennyalakan pesawat " + this.getName());
    }

   
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + this.getName());
    }


   
   
    public void Brake() {
            System.out.println("Pesawat berhenti");
        }
   



    public void fly() {
        System.out.println("Pesawat " + this.getName() + " lepas landas");
    }
}
