package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.DenseInstance;
import weka.core.Instances;

public class Controller {

    public static Instances getInstancesByName(String name) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(name);
        Instances instances = new Instances(fr);
        instances.setClassIndex(0);
        return instances;
    }

    public static long train(double[] values) {

        try {
            Instances insClassifier = getInstancesByName("src/storage/Glass.arff");
            Instances insTest = getInstancesByName("src/storage/GlassTest.arff");

            FileInputStream fileInputStream = new FileInputStream("src/storage/MultilayerPercepton.model");
            MultilayerPerceptron mlp = (MultilayerPerceptron) (new ObjectInputStream(fileInputStream)).readObject();
            mlp.buildClassifier(insClassifier);

            Evaluation evaluation = new Evaluation(insClassifier);
            evaluation.evaluateModel(mlp, insTest);

            DenseInstance denseInstance = new DenseInstance(10);
            denseInstance.setDataset(insClassifier);

            for (int i = 1; i < 10; i++) {
                denseInstance.setValue(i, values[i]);
            }

            double prob[] = mlp.distributionForInstance(denseInstance);
            System.out.println(Double.valueOf(new DecimalFormat("#").format(prob[0])));
            return Math.round(Double.valueOf(new DecimalFormat("#").format(prob[0])));

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
