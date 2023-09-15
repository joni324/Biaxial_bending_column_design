public class Main {
    public static void printC(double[][] coords){
        for(double[] i:coords){
            System.out.print("{" + i[0] + "," + i[1] + "}  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Concrete conc = new Concrete();
            conc.setCoordinates(new double[][] {{0,0},{0,-1},{1,-1},{1,0},{0,0}});
            conc.updateProperties();
            Composite c1 = new Composite();
            c1.setConcrete(conc);
            c1.UpdateProperties();;
            Composite c2;
            c2 =(Composite) c1.clone();
            //c1.setArea(3);
            c1.getConcrete().setCoordinates(new double[][] {{0,4},{0,-1},{1,-1},{1,0},{0,4}});
            conc.updateProperties();
            c1.getConcrete().updateProperties();
            c1.UpdateProperties();
            c2.UpdateProperties();
            System.out.println(c2.getArea());
        }catch (Exception e){
        }

    }
}