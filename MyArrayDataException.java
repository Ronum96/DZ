class MyArrayDataException extends CustomException {

    MyArrayDataException(int row, int col) {
        super(String.format("Неверные данные находятся в ячейке [%d, %d]\n", row, col));
    }
}