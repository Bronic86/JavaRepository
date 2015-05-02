package lab04;

/* Имеется прямоугольное отверстие размерами a и b, определить, можно ли его полностью закрыть круглой картонкой радиусом r. */
public class Task04 {
    public static void main(String[] args) {
        double a = 14.2;
        double b = 18.3;
        double r = 12.4;
        if ((4 * r * r) >= (a * a + b * b)) {
            System.out.println("Круглой картонкой радиусом r = " + r + " можно полностью закрыть прямоугольное отверстие размерами " + a + " и " + b);
        } else {
            System.out.println("Круглой картонкой радиусом r = " + r + " невозможно полностью закрыть прямоугольное отверстие размерами " + a + " и " + b);
        }
    }
}