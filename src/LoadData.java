import java.io.File;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

public class LoadData {
    public static Instances LoadingData() throws Exception {
        DataSource source = new DataSource("src/data/data.csv");
        Instances dataset = source.getDataSet();
        dataset.setClassIndex(3);
        // System.out.println(dataset.toSummaryString());
        // CSVLoader loader = new CSVLoader();
        // loader.setSource(new
        // File("D:\\Intro2DataMining\\FinalIDMProject\\src\\data\\data.csv"));
        // Instances dataset = loader.getDataSet();
        return dataset;
    }
}
