# binary-classification

This program defines a neural network with two input nodes, one output node, and a single layer of weights. 
It trains the network to perform binary classification on the XOR problem (i.e. the output is 1 if the inputs are not equal, and 0 otherwise).
The predict method calculates the activation of the output node by summing the products of the inputs and the weights, 
and applying the step function to the result. The train method uses stochastic gradient descent to update the weights and 
bias based on the error between the predicted output and the true label.
The main method initializes the inputs and labels for the XOR problem, 
creates a new neural network with a learning rate of 0.1, trains the network for 1000 epochs, and prints the predicted output for each input.
