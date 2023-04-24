import java.util.Arrays;

public class NeuralNetwork {
    private double[] weights;
    private double bias;
    private double learningRate;

    public NeuralNetwork(int numInputs, double learningRate) {
        this.weights = new double[numInputs];
        this.bias = 0;
        this.learningRate = learningRate;

        // Initialize weights randomly
        for (int i = 0; i < numInputs; i++) {
            this.weights[i] = Math.random();
        }
    }

    public double predict(double[] inputs) {
        double activation = this.bias;

        for (int i = 0; i < inputs.length; i++) {
            activation += inputs[i] * this.weights[i];
        }

        return activation > 0 ? 1 : 0;
    }

    public void train(double[][] inputs, int[] labels, int epochs) {
        for (int i = 0; i < epochs; i++) {
            for (int j = 0; j < inputs.length; j++) {
                double prediction = predict(inputs[j]);
                double error = labels[j] - prediction;

                // Update weights and bias
                for (int k = 0; k < inputs[j].length; k++) {
                    this.weights[k] += error * inputs[j][k] * this.learningRate;
                }

                this.bias += error * this.learningRate;
            }
        }
    }

    public static void main(String[] args) {
        double[][] inputs = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int[] labels = {0, 0, 0, 1};

        NeuralNetwork nn = new NeuralNetwork(2, 0.1);
        nn.train(inputs, labels, 1000);

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(Arrays.toString(inputs[i]) + " -> " + nn.predict(inputs[i]));
        }
    }
}
