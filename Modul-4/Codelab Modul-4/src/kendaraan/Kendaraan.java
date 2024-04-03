package kendaraan;

public abstract class Kendaraan {
    String name;
    String model;
    String warna;
    int tahun;

    public abstract void Start();
    public abstract void Stop();
    public abstract void Brake();
    //==============================
    public void getInfo(){
        System.out.println("Kendaraan: " + name);
        System.out.println("Model : " + model);
        System.out.println("Warna : " + warna);
        System.out.println("Tahun : " + tahun);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setModel(String model){
        this.model = model;
    }


    public void setWarna(String warna){
        this.warna = warna;
    }


    public void setTahun(int tahun){
        this.tahun = tahun;
    }
}
