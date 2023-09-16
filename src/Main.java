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
            conc.setCoordinates(new double[][] {{0,0},{0,-5},{5,-5},{5,0},{0,0}});
            conc.updateProperties();
            Steel steel = new Steel();
            steel.setCoordinates(new double[][] {{0,0},{0,-5},{5,-5},{5,0}});
            steel.setRebarArea(new double[] {1,1,1,1});
            Composite composite = new Composite();
            composite.setConcrete(conc);
            composite.setSteel(steel);

            printC(composite.getConcrete().getCoordinates());
            composite.updateProperties();
            System.out.println(composite.getYc());

            double[] P = {2.5,2.5,4};
            double[] M = {10, 10};
            Load load = new Load(P,M);

            Transform.findNeutralAxis(composite,load);

            printC(composite.getConcrete().getCoordinates());


        }catch (Exception e){
        }

    }
}