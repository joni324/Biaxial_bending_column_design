public class GeometricProperties {
    public static double E(double fc){
        return 120000*Math.pow(.145,2)*Math.pow(fc,.33);
    }

    public static double Area(double[][] coords){
        double area = 0;
        for(int i = 0; i < coords.length-1; i++){
            area += (coords[i+1][0] + coords[i][0])*(coords[i+1][1] - coords[i][1])/2;
        }
        return area;
    }

    public static double Xc(double[][] coords, double area){
        double xc = 0;
        for(int i = 0; i < coords.length-1; i++){
            xc += (coords[i+1][0] + coords[i][0])*(coords[i][0]*coords[i+1][1] - coords[i+1][0]*coords[i][1]);
        }
        return xc/(6*area);
    }

    public static double Yc(double[][] coords, double area){
        double yc = 0;
        for(int i = 0; i < coords.length-1; i++){
            yc += (coords[i+1][1] + coords[i][1])*(coords[i][0]*coords[i+1][1] - coords[i+1][0]*coords[i][1]);
        }
        return yc/(6*area);
    }

    public static double Iyy(double[][] coords){
        double Iyy = 0;
        for(int i = 0; i < coords.length-1; i++){
            double a = Math.pow(coords[i+1][0],2) + coords[i][0]*coords[i+1][0] + Math.pow(coords[i][0],2);
            Iyy += a*(coords[i][0]*coords[i+1][1] - coords[i+1][0]*coords[i][1]);
        }
        return Iyy/(12);
    }
    public static double Ixx(double[][] coords){
        double Ixx = 0;
        for(int i = 0; i < coords.length-1; i++){
            double a = Math.pow(coords[i+1][1],2) + coords[i][1]*coords[i+1][1] + Math.pow(coords[i][1],2);
            Ixx += a*(coords[i][0]*coords[i+1][1] - coords[i+1][0]*coords[i][1]);
        }
        return Ixx/(12);
    }
    public static double Ixy(double[][] coords){
        double Ixy = 0;
        for (int i = 0; i < coords.length-1;i++){
            double xi = coords[i][0];
            double yi = coords[i][1];
            double xn = coords[i+1][0];
            double yn = coords[i+1][1];

            Ixy += (2*xn*yn + xn*yi + xi*yn + 2*xi*yi)*(xi*yn - xn*yi);

        }
        return Ixy/24;
    }
    public static double[] steelProperties(double[][] coords, double[] rebarArea){
        double area = 0;
        double xc = 0;
        double yc = 0;
        double Ixx = 0;
        double Iyy = 0;
        for (int i = 0; i < coords.length; i++){
            area += rebarArea[i];
            xc += coords[i][0]*rebarArea[i];
            yc += coords[i][1]*rebarArea[i];
            Ixx += coords[i][1]*coords[i][1]*rebarArea[i];
            Iyy = coords[i][0]*coords[i][0]*rebarArea[i];
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

    public static double angleBetweenVectors(double[] v1, double[] v2){
        double dotProduct = v1[0]*v2[0] + v1[1]*v2[1];
        double v1Mag = Math.pow(v1[0]*v1[0] + v1[1]*v1[1], .5);
        double v2Mag = Math.pow(v2[0]*v2[0] + v2[1]*v2[1], .5);

        double angle = Math.acos(dotProduct/(v1Mag*v2Mag));
        return angle;
    }
}
