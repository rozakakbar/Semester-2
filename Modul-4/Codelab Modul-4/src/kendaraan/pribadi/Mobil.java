package kendaraan.pribadi;

import kendaraan.Kendaraan;

public class Mobil extends Kendaraan {
    
    public void Start() {
        System.out.println("Mobil " + this.getName() + " dinyalakan");
    }

   
    public void Stop() {
        System.out.println("Mobil " + this.getName() + " dimatikan");
    }

    
    public void Brake() {
        System.out.println("berhenti");
    }
}
