public class Main {
    public static void main(String[] args) {
        char[] gartenzaun = {'G', 'a', 'r', 't', 'e', 'n', 'z', 'a', 'u', 'n'};
        GartenzaunTransposition g = new GartenzaunTransposition();
        char[] text = g.verschluesseln(gartenzaun);
        g.entschluesseln(text);
    }
}