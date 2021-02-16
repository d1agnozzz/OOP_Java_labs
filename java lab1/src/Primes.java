// Программа вывода всех простых чисел от 0 до 100

public class Primes{
    public static void main(String[] args){ // Проверка и вывод простых чисел
        for (int i = 2; i <= 100; i++){
            if (isPrime(i)) System.out.println(i);
        }
    }

    public static boolean isPrime(int n){ // проверка числа на простоту
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}