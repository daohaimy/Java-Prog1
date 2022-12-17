public class Produkt {
    String Name;
    int Produktnummer;
    double Preis;

    Produkt(String Name, int Produktnummer, double Preis){
        this.Name = Name;
        this.Produktnummer = Produktnummer;
        this.Preis= Preis;
    }

    Produkt(String Name){
        this(Name, 123, 1.50);
    }

    Produkt(int Produktnummer){
        this("Stift", Produktnummer, 1.50);
    }

    Produkt(double Preis){
        this("Stift", 123, Preis);
    }

    Produkt(String Name, int Produktnummer){
        this(Name, Produktnummer, 1.50);
    }

    Produkt(int Produktnummer, double Preis){
        this("Stift", Produktnummer, Preis);
    }

    Produkt(String Name, double Preis){
        this(Name, 123, Preis);
    }
    Produkt(){
        this("Stift", 123, 1.50);
    }
}

/*
        Produkt produkt = new Produkt("Stift", 123, 1.50);
        Produkt produkt1 = new Produkt("Stift");
        Produkt produkt2 = new Produkt(123);
        Produkt produkt3 = new Produkt(1.50);
        Produkt produkt4 = new Produkt("Stift", 123);
        Produkt produkt5 = new Produkt(123, 1.50);
        Produkt produkt6 = new Produkt("Stift", 1.50);
        Produkt produkt7 = new Produkt();
        */
