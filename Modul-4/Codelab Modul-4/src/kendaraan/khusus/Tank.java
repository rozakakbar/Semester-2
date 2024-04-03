package kendaraan.khusus;

import kendaraan.Kendaraan;



public class Tank extends Kendaraan{
  
    public void Start() {
        System.out.println("Menyalakan " + this.getName() + " tank");
    }

    public void Stop() {

        System.out.println("Mematikan tank " + this.getName());
    }


    public void Brake() {

        System.out.println("Tank berhenti");
    }


    public void Shootingg(String vehicle) {
        
        System.out.println("Tank menembak " + vehicle);
    }
}
