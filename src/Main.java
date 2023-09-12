public class Main {
    public static void printC(double[][] coords){
        for(double[] i:coords){
            System.out.print("{" + i[0] + "," + i[1] + "}  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Concrete concrete = new Concrete();
        double[][] coords = {{0,0},{1,-1},{2,0},{1,1},{0,0}};
        concrete.setCoordinates(coords);
        concrete.updateProperties();
        System.out.println(concrete.getArea());
        concrete.Translate(-1,0);
        concrete.Rotate(Math.PI/4);
        printC(concrete.getCoordinates());
        concrete.ReduceSection();
        printC(concrete.getCoordinates());
        System.out.println(concrete.getArea());
    }
}