package cccc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

interface BufferedReaderCallback{
    Integer doSomethingWithReader(BufferedReader bufferedReader) throws IOException;
}

interface LineCallback {
    Integer doSomethingWithLine(String line, Integer res);
}

public class Calculator {
    public Integer lineReadTemplate(String filepath, LineCallback callback, int initVal){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer res = initVal;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public Integer calcSum(String filepath) {
        return lineReadTemplate(filepath, new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer res) {
                return res + Integer.valueOf(line);
            }
        }, 0);
    }

    public Integer calcMultiply(String filepath){
        return lineReadTemplate(filepath, new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer res) {
                return res * Integer.valueOf(line);
            }
        }, 1);
    }
}
