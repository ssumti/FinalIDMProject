import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.supervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToBinary;
import weka.filters.unsupervised.attribute.StringToNominal;

import java.io.File;

import weka.associations.FPGrowth;

public class AssociationRule {
    Instances dataset;

    public AssociationRule(Instances dataset) {
        this.dataset = dataset;
    }

    public void FpGrowthAlgo() throws Exception {

        NominalToBinary ntb = new NominalToBinary();
        ntb.setInputFormat(dataset);
        Instances newdata = Filter.useFilter(dataset, ntb);

        // ArffSaver saver = new ArffSaver();
        // saver.setInstances(newdata);
        // saver.setFile(new File("src/data/ooutput.csv"));
        // saver.writeBatch();
        FPGrowth fp = new FPGrowth();
        fp.buildAssociations(newdata);
        System.out.println(fp);
    }
}
