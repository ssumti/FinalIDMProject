import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.unsupervised.attribute.*;
import weka.filters.Filter;

public class Preprocessing {
    Instances dataset;

    public Preprocessing(Instances dataset) {
        this.dataset = dataset;
    }

    public Instances FilteringData() throws Exception {
        ReplaceMissingValues rmv = new ReplaceMissingValues();
        rmv.setInputFormat(dataset);
        Instances newDataset = Filter.useFilter(dataset, rmv);

        Normalize norm = new Normalize();
        norm.setInputFormat(newDataset);
        newDataset = Filter.useFilter(newDataset, norm);
        // OrdinalToNumeric otn = new OrdinalToNumeric();
        // String[] opt = new String[] { "-R", "first-last" };
        // otn.setOptions(opt);
        // otn.setInputFormat(newDataset);
        // newDataset = Filter.useFilter(newDataset, otn);
        // ArffSaver saver = new ArffSaver();
        // saver.setInstances(newDataset);
        // saver.setFile(new File("src/data/output.csv"));
        // saver.writeBatch();
        return newDataset;
    }
}
