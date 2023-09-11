public class Properties {
    public static double E(double fc){
        return 120000*Math.pow(.145,2)*Math.pow(fc,.33);
    }

    public static double Area(double[][] shape){
        double area = 0;
        for(int i = 0; i < shape.length-1; i++){
            area += (shape[i+1][0] + shape[i][0])*(shape[i+1][1] - shape[i][1])/2;
        }
        return area;
    }

    public static double Xc(double[][] shape, double area){
        double xc = 0;
        for(int i = 0; i < shape.length-1; i++){
            xc += (shape[i+1][0] + shape[i][0])*(shape[i][0]*shape[i+1][1] - shape[i+1][0]*shape[i][1]);
        }
        return xc/(6*area);
    }

    public static double Yc(double[][] shape, double area){
        double yc = 0;
        for(int i = 0; i < shape.length-1; i++){
            yc += (shape[i+1][1] + shape[i][1])*(shape[i][0]*shape[i+1][1] - shape[i+1][0]*shape[i][1]);
        }
        return yc/(6*area);
    }

    public static double Iyy(double[][] shape){
        double Iyy = 0;
        for(int i = 0; i < shape.length-1; i++){
            double a = Math.pow(shape[i+1][0],2) + shape[i][0]*shape[i+1][0] + Math.pow(shape[i][0],2);
            Iyy += a*(shape[i][0]*shape[i+1][1] - shape[i+1][0]*shape[i][1]);
        }
        return Iyy/(12);
    }
    public static double Ixx(double[][] shape){
        double Ixx = 0;
        for(int i = 0; i < shape.length-1; i++){
            double a = Math.pow(shape[i+1][1],2) + shape[i][1]*shape[i+1][1] + Math.pow(shape[i][1],2);
            Ixx += a*(shape[i][0]*shape[i+1][1] - shape[i+1][0]*shape[i][1]);
        }
        return Ixx/(12);
    }
    public static double[] steelProperties(double[][] coords){
        double area = 0;
        double xc = 0;
        double yc = 0;
        double Ixx = 0;
        double Iyy = 0;
        for (double[] i: coords){
            area += i[2];
            xc += i[0]*i[2];
            yc += i[1]*i[2];
            Ixx += i[1]*i[1]*i[2];
            Iyy = i[0]*i[0]*i[2];
        }
        return new double[] {area, xc/area, yc/area, Ixx, Iyy };

    }
    public static double slope(double[] a, double[] b){
        if(a[0]-b[0] != 0){
            return (b[1] - a[1])/(b[0] - a[0]);
        }else{
            return ((b[1]-a[1])/(Math.abs(b[1]-a[1])))*Double.MAX_VALUE;
        }
    }

}
