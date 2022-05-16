import weka.core.Instances;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.DBSCAN;;

public class Clustering {
    Instances dataset;
    ClusterEvaluation evaluation;

    public Clustering(Instances dataset) {
        this.dataset = dataset;
    }

    public void DbScanClustering() throws Exception {
        DBSCAN dbscan = new DBSCAN();
        dbscan.setEpsilon(0.7);
        dbscan.setMinPoints(2);
        dbscan.buildClusterer(dataset);

        ClusterEvaluation eval = new ClusterEvaluation();
        eval.setClusterer(dbscan);
        eval.evaluateClusterer(dataset);
        this.evaluation = eval;
        System.out.println(eval);
    }

}
