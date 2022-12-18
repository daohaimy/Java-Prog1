public class Familie{
    public static void main(String[] args) {
        Enkel e = new Enkel();
        e.summe();
    }
}

class Grossvater {
    int x = 3;
    int y = -4;

}


class Vater extends Grossvater {
    float x = 4.5F;
    int z;
    public Vater(int z) {
        this.z = z;
    }
}
class Sohn extends Vater {
    long a;
    double x = -18.5;
    public Sohn(long a) {
        super(5);
        this.a = a;
    }
}

class Enkel extends Sohn{
    public Enkel() {
        super(0);
    }

    public void summe(){
        double summeX;
        summeX = (double) ((Grossvater)this).x + ((Vater)this).x + ((Sohn)this).x;
        double summeY;
        summeY = ((Grossvater)this).y + ((Vater)this).y + ((Sohn)this).y;
        double summeZ;
        summeZ = ((Vater)this).z + ((Sohn)this).z;
        System.out.println("x = " + summeX);
        System.out.println("y = " + summeY);
        System.out.println("z = " + summeZ);
    }
}
