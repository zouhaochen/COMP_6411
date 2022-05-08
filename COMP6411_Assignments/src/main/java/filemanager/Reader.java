package filemanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private BufferedReader bufferedReader;

    public int[] read(String path) {
        File file = new File(path);
        int[] result = new int[0];
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            result = txtToArrayList(bufferedReader).stream().mapToInt(i -> i).toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int[] readDefaultFile() {
        InputStream inputStream = getClass().getResourceAsStream("/rand.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        return txtToArrayList(bufferedReader).stream().mapToInt(i -> i).toArray();
    }

    /**
     * Transfer txt file into array list
     *
     * @param file file contain random number
     * @return array list with file number
     */
    public List<Integer> txtToArrayList(File file) {
        List<Integer> arrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                int number = 0;
                try {
                    number = Integer.parseInt(s);
                } catch (Exception e) {
                    System.out.println("Fail to parse string into integer");
                }
                arrayList.add(number);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<Integer> txtToArrayList(BufferedReader bufferedReader) {
        List<Integer> arrayList = new ArrayList<>();

        String s = "";
        while (true) {
            try {
                if ((s = bufferedReader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            int number = 0;
            try {
                number = Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Fail to parse string into integer");
            }
            arrayList.add(number);
        }

        return arrayList;
    }
}
