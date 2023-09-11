public class Main {
    public static void printC(double[][] coords){
        for(double[] i:coords){
            System.out.print("{" + i[0] + "," + i[1] + "}  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Concrete concrete = new Concrete();
        double[][] coords = {{1,1},{0,0},{1,-1},{2,0},{1,1}};
        concrete.setCoords(coords);
        printC(concrete.getCoords());
        printC(Transform.ReduceSection(Transform.TranslateCoords(0,.2,concrete.getCoords())));
        printC(concrete.getCoords());
    }
}