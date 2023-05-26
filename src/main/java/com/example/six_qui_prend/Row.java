package com.example.six_qui_prend;

public class Row {
    private Cartes carte_1;

    public Cartes getCarte_1() {
        return carte_1;
    }

    public void setCarte_1(Cartes carte_1) {
        this.carte_1 = carte_1;
    }

    public Cartes getCarte_2() {
        return carte_2;
    }

    public void setCarte_2(Cartes carte_2) {
        this.carte_2 = carte_2;
    }

    public Cartes getCarte_3() {
        return carte_3;
    }

    public void setCarte_3(Cartes carte_3) {
        this.carte_3 = carte_3;
    }

    public Cartes getCarte_4() {
        return carte_4;
    }

    public void setCarte_4(Cartes carte_4) {
        this.carte_4 = carte_4;
    }

    public Cartes getCarte_5() {
        return carte_5;
    }

    public void setCarte_5(Cartes carte_5) {
        this.carte_5 = carte_5;
    }

    public Cartes getCarte_6() {
        return carte_6;
    }

    public void setCarte_6(Cartes carte_6) {
        this.carte_6 = carte_6;
    }

    private Cartes carte_2;
    private Cartes carte_3;
    private Cartes carte_4;
    private Cartes carte_5;
    private Cartes carte_6;
    public Row(Cartes carte_1,Cartes carte_2,Cartes carte_3,Cartes carte_4,Cartes carte_5,Cartes carte_6) {
        this.carte_1=carte_1;
        this.carte_2=carte_2;
        this.carte_3=carte_3;
        this.carte_4=carte_4;
        this.carte_5=carte_5;
        this.carte_6=carte_6;
    }
}
