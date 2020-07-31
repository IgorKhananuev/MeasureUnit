import java.io.IOException;


public class Runner {
    public static void main(String[] args) throws IOException {
        String path = "src\\main\\resources\\inputText.txt";
        UnitOperator unitOperator = new UnitOperator(path);
        unitOperator.convertToMs();
        unitOperator.sortedListByMeasureUnit();
        unitOperator.findElement();
        unitOperator.sortAndGroupByUnitMeasure();
    }
}
