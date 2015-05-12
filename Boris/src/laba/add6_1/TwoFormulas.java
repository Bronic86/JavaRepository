package laba.add6_1;


// Класс на 2 формулы.

import static java.lang.Math.*;

public class TwoFormulas {
    private int x;

    TwoFormulas(int x) {
        this.x = x;
    }

    void setX(int x) {
        this.x = x;
    }

    double getResultFirst() {
        return (sqrt(sqrt(cos(pow(E, x)) + pow(E, pow(x, 2)) + 1 / sqrt(x))) /
                pow(pow(cos(PI * x), 3) + log(pow(1 + x, 2)), sin(x)));
    }

    double getResultSecond(int s, int t) {
        return pow(sin(pow(x, t)), 2) / sqrt(1 + pow(x, t));
    }
}
