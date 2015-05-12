package laba.add6_1;

//Проверка формул
public class TestFormulas {
    public static void main(String[] args) {
        int argX = 3;
        TwoFormulas firstFormulaValue = new TwoFormulas(argX);
        System.out.println("Первое значение формулы при x = " + argX + " равно " + firstFormulaValue.getResultFirst());
        int paramS = 1;
        int paramT = 1;
        System.out.println("Второе значение формулы при x = " + argX + ",s = " + paramS + " и t = "
                + paramT + " равно " + firstFormulaValue.getResultSecond(paramS, paramT));
    }
}
