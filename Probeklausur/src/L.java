public class L {
    private static Integer[] z = new Integer[5];

    public static void init(){
        Integer i = 1;
        System.out.print("init: ");
        for(int j = 0; j < z.length; j++){
            z[j] = i;
            i = i + j % 5;
            System.out.print(z[j] + "\t");
        }
        System.out.println();
    }

    public static Integer drei(){
        Integer ergebnis = 0;
        Integer zaehler = 0;
        System.out.print("drei: ");
        while(zaehler < z.length){
            if(zaehler % 3 == 0){
                System.out.print(z[zaehler] + "\t");
            }
            zaehler = zaehler + 1;
        }
        System.out.println();
        return ergebnis;
    }

    public static void sum(){
        Integer zaehler = 0;
        System.out.print("sum: ");
        while (zaehler < z.length - 1){
            Integer tmp = z[zaehler] + z[zaehler + 1];
            System.out.print(tmp+"\t");
            zaehler = zaehler + 1;
        }
        System.out.println();
    }

    public static void mult(){
        Integer zaehler = 1;
        System.out.print("mult: ");
        while (zaehler < z.length - 4){
            Integer zaehler2 = 5;
            while (zaehler2 < z.length){
                Integer tmp = z[zaehler] * z[zaehler2];
                System.out.print(tmp);
                zaehler2 = zaehler2 + 1;
            }
            zaehler = zaehler + 1;
        }
    }

    public static void main(String[] args) {
        init();
        drei();
        sum();
        mult();
    }
}
