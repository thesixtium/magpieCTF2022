public class main {
    public static void main(String[] args)   {
        TurnKeyTCP a = new TurnKeyTCP();
        TurnKeyTCP b = new TurnKeyTCP();
        TurnKeyTCP c = new TurnKeyTCP();
        a.run(2);
        b.run(1);
        c.run(3);
        a.close();
        b.close();
        c.close();



    }
}
