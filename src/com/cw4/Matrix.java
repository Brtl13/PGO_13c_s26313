package com.cw4;

public class Matrix {
    private int[][] matrix;

    // Temporary structure for new Matrix construction:
    private static class MatrixAllocator {
        public int[][] matrix;
        public int currRow;

        public MatrixAllocator(int rowCount, int columnCount) {
            matrix = new int[rowCount][columnCount];
            currRow = 0;
        }
    }
    // Static variable used for create new Matrix object:
    private static MatrixAllocator tmpMatrix = null;

    // Private constructor (copy data from temporary object):
    private Matrix(MatrixAllocator a) {
        matrix = new int[a.matrix.length][a.matrix[0].length];
        for (int i = 0; i < a.matrix.length; ++i) {
            for (int j = 0; j < a.matrix[i].length; ++j) {
                matrix[i][j] = a.matrix[i][j];
            }
        }
    }

    // Public:
    public static void setUpMatrix(int rowCount, int columnCount) {
        tmpMatrix = new MatrixAllocator(rowCount, columnCount);
    }

    public static void insertRow(int[] row) {
        if (row != null && row.length == tmpMatrix.matrix[0].length) {
            if (tmpMatrix.currRow < tmpMatrix.matrix.length) {
                for (int i = 0; i < row.length; ++i) {
                    tmpMatrix.matrix[tmpMatrix.currRow][i] = row[i];
                }
                ++tmpMatrix.currRow;
            } else {
                throw new RuntimeException("insertRow: Rows out of bounds!");
            }
        } else {
            throw new RuntimeException("insertRow: There is no row or row has invalid size!");
        }
    }

    public static Matrix create() {
        // Create Matrix from temporary object:
        Matrix newMatrix = new Matrix(tmpMatrix);
        // Delete temporary Object:
        tmpMatrix = null;
        // Return created Matrix:
        return newMatrix;
    }

    public void print() {
        for (int i = 0; i < matrix.length; ++i) {
            System.out.printf("  | ");
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.printf("% 3d ", matrix[i][j]);
            }
            System.out.printf("|%n");
        }
    }

    public Matrix add(Matrix m) {
        if (m != null && matrix.length == m.matrix.length && matrix[0].length == m.matrix[0].length) {
            for (int i = 0; i < m.matrix.length; ++i) {
                for (int j = 0; j < m.matrix[i].length; ++j) {
                    matrix[i][j] += m.matrix[i][j];
                }
            }
        } else {
            throw new RuntimeException("add(matrix): argument with invalid size!");
        }
        return this;
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        Matrix result = null;
        if (m1 != null && m2 != null && m1.matrix.length == m2.matrix.length
                && m1.matrix[0].length == m2.matrix[0].length) {
            setUpMatrix(m1.matrix.length, m1.matrix[0].length);
            result = create();
            for (int i = 0; i < m1.matrix.length; ++i) {
                for (int j = 0; j < m1.matrix[i].length; ++j) {
                    result.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
                }
            }
        } else {
            throw new RuntimeException("add(matrix, matrix): matrix sizes are null or not equal!");
        }
        return result;
    }

    public Matrix subtract(Matrix m) {
        if (m != null && matrix.length == m.matrix.length && matrix[0].length == m.matrix[0].length) {
            for (int i = 0; i < m.matrix.length; ++i) {
                for (int j = 0; j < m.matrix[i].length; ++j) {
                    matrix[i][j] -= m.matrix[i][j];
                }
            }
        } else {
            throw new RuntimeException("substract(matrix): argument with invalid size!");
        }
        return this;
    }

    public static Matrix subtract(Matrix m1, Matrix m2) {
        Matrix result = null;
        if (m1 != null && m2 != null && m1.matrix.length == m2.matrix.length
                && m1.matrix[0].length == m2.matrix[0].length) {
            setUpMatrix(m1.matrix.length, m1.matrix[0].length);
            result = create();
            for (int i = 0; i < m1.matrix.length; ++i) {
                for (int j = 0; j < m1.matrix[i].length; ++j) {
                    result.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
                }
            }
        } else {
            throw new RuntimeException("substract(matrix, matrix): matrix sizes are null or not equal!");
        }
        return result;
    }

    public Matrix multiply(Matrix m) {
        if (m != null && m.matrix.length == matrix[0].length) {
            // Result array will have same size as this.matrix:
            int rows = matrix.length;
            int cols = matrix[0].length;

            setUpMatrix(rows, cols);
            Matrix result = create();
//          matrix[ROWS = i][COLS = j]:     --- j --->
//                                       |   ________
//                                       i  |__|__|__|
//                                       |  |__|__|__|
//                                       V  |__|__|__|

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    result.matrix[i][j] = 0;
                    for (int k = 0; k < cols; ++k) {
                        result.matrix[i][j] += matrix[i][k] * m.matrix[k][j];
                    }
                }
            }
            matrix = result.matrix;
        } else {
            throw new RuntimeException(
                    "multiply(matrix): the number of columns of the first matrix should be equal " +
                            "to the number of rows of the second matrix!"
            );
        }
        return this;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        Matrix result = null;
        if (m1 != null && m2 != null && m1.matrix.length == m2.matrix[0].length) {
            // Result array will have size as m1.matrix:
            int rows = m1.matrix.length;
            int cols = m1.matrix[0].length;

            setUpMatrix(rows, cols);
            result = create();

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    result.matrix[i][j] = 0;
                    for (int k = 0; k < cols; ++k) {
                        result.matrix[i][j] += m1.matrix[i][k] * m2.matrix[k][j];
                    }
                }
            }
        } else {
            throw new RuntimeException(
                    "multiply(matrix, matrix): the number of columns of the first matrix " +
                            "should be equal to the number of rows of the second matrix!"
            );
        }
        return result;
    }
}
