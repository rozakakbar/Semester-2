package kendaraan.pribadi;

import kendaraan.Kendaraan;

public class Motor extends Kendaraan {
    public void Start() {
    }

    public void Stop() {
        System.out.println("Motor " + this.getName() + " dimatikan");
    }

    public void Brake() {
        System.out.println("berhenti");
    }
}
