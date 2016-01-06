package text;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        TextString tt = new TextString("abaccaba");
        System.out.println(tt.isPalindrome());


        // конкатенация
        TextString t1 = new TextString("Today "), t2 = new TextString("is "), t3 = new TextString("monday, ");
        TextString t4 = new TextString("the "), t5 = new TextString("weather "), t6 = new TextString("fine! ");
        TextString textString1 = t1.concatTextString(t2.concatTextString(t3));
        TextString textString2 = t4.concatTextString(t5.concatTextString(t2.concatTextString(t6)));
        TextString textString3 = textString1.concatTextString(textString2);


        //возвращать подстроку по указанным индексам (от и до)
        System.out.println(textString3.textFromTo(9, 14));
        System.out.println(textString3.textFromTo(8, 33));

        //возвращать элемент по индексу или null, если такого элемента нет
        System.out.println(textString3.itemByIndex(0));
        System.out.println(textString3.itemByIndex(36));
        System.out.println(textString3.itemByIndex(37));

        // Делать реверс строки
        System.out.println(textString3.reverseText());

        // Делать проверку, является ли строка палиндромом
        TextString word1 = new TextString("Was, it,,\" a car!!! o:r a cat i saw!");
        TextString word2 = new TextString("Madam I'm Adam");
        TextString word3 = new TextString("A man, a plan a canal Panama");
        TextString word4 = new TextString("aslfjklajgFJLKj");
        System.out.println("Is this a palindrome?\n" +word1+"\n"+word1.isPalindrome());
        System.out.println("******************");
        System.out.println("Is this a palindrome?\n" +word2+"\n"+word2.isPalindrome());
        System.out.println("******************");
        System.out.println("Is this a palindrome?\n" +word3+"\n"+word3.isPalindrome());
        System.out.println("******************");
        System.out.println("Is this a palindrome?\n" +word4+"\n"+word4.isPalindrome());

        // Искать символ и выдавать индекс первого места, где он встретился;
        System.out.println(textString3);
        System.out.println(textString3.findCharFirstPlace('a'));
        System.out.println(textString3.findCharFirstPlace('i'));

        // Искать символ и выдавать все позиции, где он встречается;
        System.out.println(textString3.findChar('a'));
        System.out.println(textString3.findChar('i'));

        // Искать подстроку (последовательность символов) так же как в 6 и 7 пунктах для символа
        TextString textString = new TextString("moondday ond on on n");
        System.out.println(textString);
        System.out.println(textString.findTextFirstPlace("ond"));
        System.out.println(textString.findText("on"));
        System.out.println(textString.findText("o"));

        // Возвращать строку (в виде String), которую содержит на данный момент.
        System.out.println(textString.contents());
        System.out.println(textString2.contents());
        System.out.println(textString1.contents());

        // Реализовать статические методы
        // 1) Метод возвращает экземпляр TextString, который составлен из массива переданных String,
        // соединённых разделителем, переданным тоже в виде String

        String[] strings = {"qwerty", "asdf", "zxcv", "jkl;", "uiop"};
        System.out.println(TextString.concatString(strings, "123"));


        // 2) Метод возвращает массив String, который получается разделением исходной строки по заданному разделителю.

        String s = "Взрослые посоветовали мне не рисовать змей ни снаружи, ни изнутри, а побольше интересоваться географией, историей, арифметикой и правописанием. Вот как случилось, что шести лет я отказался от блестящей карьеры художника. Потерпев неудачу с рисунками №1 и №2, я утратил веру в себя. Взрослые никогда ничего не понимают сами, а для детей очень утомительно без конца им все объяснять и растолковывать.\n" +
                "\n" +
                "Итак, мне пришлось выбирать другую профессию, и я выучился на летчика.";
        System.out.println(s);
        System.out.println(TextString.divideToArrayString(s, "взрослые"));


    }
}
