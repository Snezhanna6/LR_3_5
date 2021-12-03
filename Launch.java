package Main;

import java.io.File;
import java.io.FileReader;

public class Launch {

    private File file;
    private String numbers;

    public void start(){

        String filePath = "text.bat";
        file = new File(filePath);

        try {
            System.out.print("Набиольшая последовательность подряд идущих чисел = ");
            System.out.println(manyNumbers(readFile(file)));
            System.out.println(numbers);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private int manyNumbers(String str){

        int max = 0;
        int kol = 0;
        char[] sl = str.toCharArray();

        for (int i = 0; i < sl.length; i++){
            String sl2 = "";
            if (Character.isDigit(sl[i])){
                sl2 += sl[i] + "";
                kol = 1;
                for (int j = i + 1; j < sl.length; j++)
                    if (Character.isDigit(sl[j])) {
                        sl2 += sl[j] + "";
                        kol++;
                    }
                    else {
                        i = i + (j - i);
                        break;
                    }
                if (max < kol) {
                    numbers = sl2;
                    max = kol;
                }

            }
        }

        return max;
    }

    /**
     * Считывает текст из файле и возвращает строку с текстом
     * @param file - файл, в котором будем считывать текст
     * @return - текст из файла
     */
    private String readFile(File file) {
        String textFile = "";
        try {
            FileReader reader = new FileReader(file);
            textFile = "";
            int c;
            while ((c = reader.read()) != -1) {
                textFile += (char) c;
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return textFile;
    }
}
