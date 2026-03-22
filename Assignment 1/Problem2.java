// Develop Matrix class with constructors, transpose and multiplication  

import java.util.Scanner;

class Matrix {
    int rows, cols;
    int[][] mat;

    // Constructor
    Matrix(int r, int c) {
        rows = r;
        cols = c;
        mat = new int[rows][cols];
    }

    // Input Matrix (Space-separated input)
    void inputMatrix(Scanner sc) {
        System.out.println("Enter " + (rows * cols) + " elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt(); // accepts space-separated values
            }
        }
    }

    // Display Matrix
    void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Transpose of Matrix
    Matrix transpose() {
        Matrix t = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t.mat[j][i] = mat[i][j];
            }
        }
        return t;
    }

    // Matrix Multiplication
    Matrix multiply(Matrix m2) {
        if (this.cols != m2.rows) {
            System.out.println("Multiplication not possible");
            return null;
        }

        Matrix result = new Matrix(this.rows, m2.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                result.mat[i][j] = 0;
                for (int k = 0; k < this.cols; k++) {
                    result.mat[i][j] += this.mat[i][k] * m2.mat[k][j];
                }
            }
        }
        return result;
    }
}

// Main Class
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First Matrix
        System.out.print("Enter rows and columns of Matrix 1: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        Matrix m1 = new Matrix(r1, c1);
        m1.inputMatrix(sc);

        // Second Matrix
        System.out.print("Enter rows and columns of Matrix 2: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        Matrix m2 = new Matrix(r2, c2);
        m2.inputMatrix(sc);

        // Display matrices
        System.out.println("\nMatrix 1:");
        m1.displayMatrix();

        System.out.println("\nMatrix 2:");
        m2.displayMatrix();

        // Transpose
        System.out.println("\nTranspose of Matrix 1:");
        Matrix t1 = m1.transpose();
        t1.displayMatrix();

        // Multiplication
        System.out.println("\nMultiplication Result:");
        Matrix result = m1.multiply(m2);

        if (result != null) {
            result.displayMatrix();
        }

        sc.close();
    }
}