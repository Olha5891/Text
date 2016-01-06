package text;

import java.util.ArrayList;
import java.util.List;

public final class TextString {
    private final char[] arrText;

    private TextString(final char[] arrText) {
        this.arrText = arrText;
    }

    public TextString(final String text) {
        this.arrText = text.toCharArray();
    }

    public static TextString concatString(String[] strings, String delimiter) {
        TextString result = new TextString("");
        TextString delimiters = new TextString(delimiter);
        String s;
        for (int i =0 ; i<strings.length; i++) {
            s = strings[i];
            if (i != strings.length-1)
                result = result.concatTextString(new TextString(s)).concatTextString(delimiters);
            else
                result = result.concatTextString(new TextString(s));
        }
        return result;
    }

    public static List<String> divideToArrayString(String text, String delimiter) {
        ArrayList<String> result = new ArrayList<>();
        TextString textString = new TextString(text);
        TextString delim = new TextString(delimiter);

        int textLength = textString.getArrText().length;
        int delimiterLength = delim.getArrText().length;
        int startEntry = 0;
        int findIndex = 0;

        while (findIndex < textLength) {
            findIndex = textString.findTextFirstPlace(delimiter, findIndex);
            if (findIndex > -1) {
                TextString textAdd = textString.textFromTo(startEntry, findIndex - 1);
                result.add(textAdd.contents());
                findIndex += delimiterLength;
                startEntry = findIndex;
            } else {
                break;
            }

        }

        TextString textAdd = textString.textFromTo(startEntry, textLength - 1);
        result.add(textAdd.contents());

        return result;
    }

    private Boolean isLetter(int index) {
        boolean isLetter = true;
        char[] delimiter = {' ', ',', '.', '!', '?', ':', ';', '"', '\''};
        char ch = this.getArrText()[index];
        for (int j = 0; j < delimiter.length; j++) {
            if (ch == delimiter[j]) {
                isLetter = false;
                break;
            }
        }
        return isLetter;
    }

    public char lowerCase(int index) {
        char ch = this.getArrText()[index];
        char delta = '\40';
        if ((ch > 1041 && ch < 1072) || (ch > 64) && (ch < 91))
            ch += delta;
        return ch;
    }
    public char upperCase(int index) {
        char ch = this.getArrText()[index];
        char delta = '\40';
        if ((ch > 1071 && ch < 1104) || (ch > 96) && (ch < 123))
            ch -= delta;
        return ch;
    }

    public TextString concatTextString(TextString text2) {
        char[] arrTextResult = new char[this.getArrText().length + text2.getArrText().length];
        //char[] arrTextResult = new char[this.getArrText().length + text2.getArrText().length + 1];
        //char delimiter = ' ';

        int i = 0;
        if (i < arrTextResult.length) {
            for (int j = 0; j < this.getArrText().length; j++) {
                arrTextResult[i] = this.getArrText()[j];
                i++;
            }
            // arrTextResult[this.getArrText().length] = delimiter;
            // i++;
            for (int k = 0; k < text2.getArrText().length; k++) {
                arrTextResult[i] = text2.getArrText()[k];
                i++;
            }
        }
        return new TextString(arrTextResult);
    }

    public TextString textFromTo(int beginIndex, int endIndex) {
        char[] ch = new char[endIndex - beginIndex + 1];
        int j = 0;
        if (j < ch.length) {
            for (int i = beginIndex; i < endIndex + 1; i++) {
                ch[j] = this.getArrText()[i];
                j++;
            }
        }
        return new TextString(ch);
    }

    public TextString itemByIndex(int index) {
        if (index < this.getArrText().length)
            return new TextString(new char[]{this.getArrText()[index]});
        else
            return null;
    }

    public TextString reverseText() {
        char[] mirror = new char[this.getArrText().length];
        for (int i = 0; i < mirror.length; i++) {
            mirror[i] = this.getArrText()[this.getArrText().length - 1 - i];
        }
        return new TextString(mirror);
    }

    public Boolean isPalindrome() {
        boolean isPalindrome = true;
        int j = this.getArrText().length - 1;
        int d = 0;

        for (int i = 0; i < (this.getArrText().length - d) / 2; i++) {
            while (!this.isLetter(i)) {
                i++;
                d++;
            }
            while (!this.isLetter(j)) {
                j--;
                d++;
            }
            if (this.lowerCase(i) != this.lowerCase(j)) {
                isPalindrome = false;
                break;
            }
            j--;
        }
        return isPalindrome;
    }

    public int findCharFirstPlace(char ch) {
        int i;
        for (i = 0; i < this.getArrText().length; i++) {
            if (this.getArrText()[i] != ch) {
            } else break;
        }
        return i;
    }

    public List<Integer> findChar(char ch) {
        ArrayList<Integer> index = new ArrayList<>();
        int i = 0;
        while (i < this.getArrText().length) {
            if (this.getArrText()[i] == ch) {
                index.add(i);
            }
            i++;
        }
        return index;
    }

    public int findTextFirstPlace(String text) {
        return findTextFirstPlace(text, 0);
    }

    public int findTextFirstPlace(String text, int from) {
        TextString t = new TextString(text);
        if (from < 0 || from > this.getArrText().length)
            return -1;
        int result = -1, j = 0;
        char x, y;
        boolean isFind = false;

        if (t.getArrText().length - 1 < this.getArrText().length) {

            for (int i = from; i < this.getArrText().length; i++) {

                if (isFind)
                    break;

                int k = i;
                if (result != -1)
                    j = 0;

                while (j < t.getArrText().length) {

                    if (this.isLetter(k))
                        x = this.lowerCase(k);
                    else x = this.getArrText()[k];

                    if (t.isLetter(j))
                        y = t.lowerCase(j);
                    else y = t.lowerCase(j);

                    if (y == x) {
                        result = i;
                        k++;
                        j++;
                        if (j == t.getArrText().length) {
                            isFind = true;
                            break;
                        }
                    } else
                        break;
                }
            }
        }

        if(!isFind)
            result = -1;

        return result;
    }

    public List<Integer> findText(String text) {
        ArrayList<Integer> index = new ArrayList<>();
        TextString t = new TextString(text);
        int i, j = 0, k, result = -1;
        char x, y;

        if (t.getArrText().length - 1 < this.getArrText().length) {
            for (i = 0; i < this.getArrText().length; i++) {

                k = i;
                if (result != -1)
                    j = 0;

                while (j < t.getArrText().length) {

                    if (this.isLetter(k))
                        x = this.lowerCase(k);
                    else x = this.getArrText()[k];

                    if (t.isLetter(j))
                        y = t.lowerCase(j);
                    else y = t.lowerCase(j);

                    if (y == x) {
                        result = i;
                        k++;
                        j++;
                        if (j == t.getArrText().length) {
                            index.add(i);
                            break;
                        }
                    } else
                        break;
                }
            }
        }

        return index;
    }

    public String contents() {
        return new String(this.getArrText());
    }

    @Override
    public String toString() {
        return new String(this.getArrText());
    }

    public char[] getArrText() {
        return arrText;
    }

}
