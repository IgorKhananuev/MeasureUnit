import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnitOperator {
    //block of units for convert to m/sec
    String path;
    final double FACTOR_KMH = 0.278;
    final double FACTOR_MPH = 0.447;
    final double FACTOR_KN = 0.514;
    //block of units for convert to meter
    final int FACTOR_M = 1;
    final int FACTOR_KM = 1000;
    final int FACTOR_MILE = 1609;
    final int FACTOR_KNOT = 1852;

    String s;

    public UnitOperator(String path) {
        this.path = path;
    }

    // method for convert any unit measure to m/sec
    public void convertToMs() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        while ((s = bufferedReader.readLine()) != null) {
            if (s.contains("kmh")) {
                char c = s.charAt(0);
                int x = Character.digit(c, 10);
                double result = x * FACTOR_KMH;
                System.out.println(x + " kmh = " + result + " ms");
            } else if (s.contains("mph")) {
                char c = s.charAt(0);
                int x = Character.digit(c, 10);
                double result = x * FACTOR_MPH;
                System.out.println(x + " mph = " + result + " ms");
            } else if (s.contains("kn")) {
                char c = s.charAt(0);
                int x = Character.digit(c, 10);
                double result = x * FACTOR_KN;
                System.out.println(x + " kn = " + result + " ms");
            } else {
                char c = s.charAt(0);
                int x = Character.digit(c, 10);
                System.out.println(x + " ms = " + x + " ms");
            }
        }
        bufferedReader.close();
        System.out.println();
    }

    // method for order list of elements consider measure units
    public void sortedListByMeasureUnit() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<Integer> listByMeasureUnit = new ArrayList<Integer>();
        while ((s = bufferedReader.readLine()) != null) {
            if (s.contains("ms")) {
                char c = s.charAt(0);
                int x = Character.digit(c, 10) * FACTOR_M;
                listByMeasureUnit.add(x);
            }
            if (s.contains("kmh")) {
                char c = s.charAt(0);
                int x = Character.digit(c, 10) * FACTOR_KM;
                listByMeasureUnit.add(x);
            }
            if (s.contains("mph")) {
                char c = s.charAt(0);
                int x = Character.digit(c, 10) * FACTOR_MILE;
                listByMeasureUnit.add(x);
            }
            if (s.contains("kn")) {
                char c = s.charAt(0);
                int x = Character.digit(c, 10) * FACTOR_KNOT;
                listByMeasureUnit.add(x);
            }
        }
        Collections.sort(listByMeasureUnit);
        for (Integer i : listByMeasureUnit) {
            if (i < FACTOR_KM) {
                System.out.println(i + " ms");
            }

            if (i % FACTOR_KM == 0) {
                System.out.println(i / FACTOR_KM + " kmh");
            }
            if (i % FACTOR_MILE == 0) {
                System.out.println(i / FACTOR_MILE + " mph");
            }
            if (i % FACTOR_KNOT == 0) {
                System.out.println(i / FACTOR_KNOT + " kn");
            }
        }
        bufferedReader.close();
        System.out.println();
    }

    // method for find necessary element in list (without searching element in cycle of file )
    public void findElement() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> generalList = new ArrayList<String>();
        while ((s = bufferedReader.readLine()) != null) {
            generalList.add(s);
        }
        if (generalList.contains("2 kmh")) {
            String replaceElement = "2 kmh".replace("2 kmh", "yes");
            System.out.println(replaceElement);
        } else {
            System.out.println("no");
        }
        bufferedReader.close();
        System.out.println();
    }

    //  method for sort list by measure units and in descending order
    public void sortAndGroupByUnitMeasure() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> listKMH = new ArrayList<String>();
        List<String> listMPH = new ArrayList<String>();
        List<String> listKN = new ArrayList<String>();
        List<String> listMS = new ArrayList<String>();
        List<String> totalList = new ArrayList<String>();
        while ((s = bufferedReader.readLine()) != null) {
            if (s.contains("kmh")) {
                listKMH.add(s);
            } else if (s.contains("mph")) {
                listMPH.add(s);
            } else if (s.contains("kn")) {
                listKN.add(s);
            } else if (s.contains("ms")) {
                listMS.add(s);
            }
        }
        Collections.reverse(listKMH);
        Collections.reverse(listMPH);
        Collections.reverse(listKN);
        Collections.reverse(listMS);
        totalList.addAll(listKMH);
        totalList.addAll(listMPH);
        totalList.addAll(listKN);
        totalList.addAll(listMS);

        for (String s : totalList) {
            System.out.println(s);
        }
        bufferedReader.close();
    }
}


