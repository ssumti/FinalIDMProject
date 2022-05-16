import weka.core.Instances;

public class App {
    public static void main(String[] args) throws Exception {
        Instances instances = LoadData.LoadingData();
        Preprocessing preprocessing = new Preprocessing(instances);
        Instances i = preprocessing.FilteringData();
        Clustering clustering = new Clustering(i);
        // clustering.DbScanClustering();
        AssociationRule a = new AssociationRule(i);
        a.FpGrowthAlgo();
    }
}
