package ex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

enum Orientare {
    LUNGIME,
    LATIME,
    ORICARE
}

class Placa {
    private String descriere;
    private int lungime;
    private int latime;
    private Orientare orientare;
    private boolean[] canturi;
    private int nr_bucati;

    public Placa() {
    }

    public String getDescriere() {
        return descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public int getLatime() {
        return latime;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }
}

class Mobilier {
    private String nume;
    private List<Placa> placi;

    public Mobilier() {
    }

    public String getNume() {
        return nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }
}

public class MainApp {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Mobilier> mobilierList = objectMapper.readValue(new File("mobilier.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Mobilier.class));


            for (Mobilier mobilier : mobilierList) {
                System.out.println("Nume: " + mobilier.getNume());
            }


            for (Mobilier mobilier : mobilierList) {
                System.out.println("Nume: " + mobilier.getNume());
                System.out.println("Placi:");
                for (Placa placa : mobilier.getPlaci()) {
                    System.out.println("  Descriere: " + placa.getDescriere());
                    System.out.println("  Lungime: " + placa.getLungime());
                    System.out.println("  Latime: " + placa.getLatime());
                    System.out.println("  Orientare: " + placa.getOrientare());
                    System.out.println("  Canturi: " + placa.getCanturi());
                    System.out.println("  Nr. Bucati: " + placa.getNr_bucati());
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
