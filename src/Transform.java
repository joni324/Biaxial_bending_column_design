import java.util.ArrayList;

public class Transform {

    public static double[][] RotateCoords(double theta,double[][] coordinates){
        double[][] coords = coordinates.clone();
        for (double[] i: coords){
            double x = i[0];
            double y = i[1];

            i[0] = x*Math.cos(theta) - y*Math.sin(theta);
            i[1] = y*Math.cos(theta) + x*Math.sin(theta);
        }
        return coords;
    }

    public static double[][] TranslateCoords(double deltaX, double deltaY, double[][] coordinates){
        double[][] coords = coordinates.clone();
        for (double[] i: coords){
            i[0] += deltaX;
            i[1] += deltaY;
        }
        return coords;
    }

    public static double[][] ReduceSection(double[][] coords){ //removes concrete in tension from section
        ArrayList<double[]> list = new ArrayList<>();
        double[] prev = coords[coords.length-1];
        double[] next = coords[1];
        for (int i = 0; i<coords.length-1; i++){
            if(coords[i][1] < 0) {
                if (prev[1] > 0 && next[1] > 0) {
                    double[] left = new double[2];
                    double[] right = new double[2];
                    if (prev[0] == coords[i][0]) {
                        left[0] = coords[1][0];
                        left[1] = 0;
                    } else {
                        double m = Properties.slope(coords[i], prev);
                        left[1] = 0;
                        left[0] = coords[i][0] - coords[i][1] / m;
                    }
                    if (next[0] == coords[i][0]) {
                        right[0] = coords[1][0];
                        right[1] = 0;
                    } else {
                        double m = Properties.slope(coords[i], next);
                        right[1] = 0;
                        right[0] = coords[i][0] - coords[i][1] / m;
                        list.add(left);
                        list.add(right);
                    }
                } else if (prev[1] > 0) {
                    double[] temp = new double[2];
                    if (prev[0] == coords[i][0]) {
                        temp[0] = coords[i][0];
                        temp[1] = 0;
                        list.add(temp);
                    } else {
                        double m = Properties.slope(coords[i], prev);
                        temp[1] = 0;
                        temp[0] = coords[i][0] - coords[i][1] / m;
                        list.add(temp);
                    }
                } else if (next[1] > 0) {
                    double[] temp = new double[2];
                    if (next[0] == coords[i][0]) {
                        temp[0] = coords[i][0];
                        temp[1] = 0;
                        list.add(temp);
                    } else {
                        double m = Properties.slope(coords[i], next);
                        temp[1] = 0;
                        temp[0] = coords[i][0] - coords[i][1] / m;
                        list.add(temp);
                    }
                } else {
                    double[] temp = new double[2];
                    temp[0] = coords[i][0];
                    temp[1] = 0;
                    list.add(temp);
                }
            }else{
                list.add(coords[i]);
            }
            prev = coords[i];
            if (i + 2 < coords.length) {
                next = coords[i + 2];
            }
        }
        list.add(list.get(0));
        return list.toArray(new double[0][0]);
    }
}
