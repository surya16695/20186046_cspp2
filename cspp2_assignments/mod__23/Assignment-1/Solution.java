import java.io.*;
import java.util.*;
// class Inpfromfolder {
//     Inpfromfolder() {

//     }
//     public ArrayList<String> listFilesForFolder(final File folder) {
//         ArrayList<String> files = new ArrayList<String>();
//         for (final File fileEntry : folder.listFiles()) {
//             if (fileEntry.isDirectory()) {
//                 listFilesForFolder(fileEntry);
//             } else {
//                 files.add(fileEntry.getName());
//             }
//         }
//         return files;
//     }
// }
class Frequency {
    Frequency() {

    }
    public Hashtable<String,Integer> loadWordstodict (File f)
    throws Exception {
        FileInputStream fileinp = new FileInputStream(f);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(fileinp));
        String str;
        Hashtable<String,Integer> dictionary = new Hashtable<String,Integer>();
        try {
            int c = 0;
            while ((str = reader.readLine()) != null) {
                // String s = str.replaceAll("[;:.,\"\\[\\]/!@#$%^&*()]","");
                String s = str.replaceAll("[^a-z A-Z 0-9 _]","").toLowerCase();
                String[] line = s.split(" ");
                for (int i = 0; i < line.length; i++) {
                    if (dictionary.containsKey(line[i])) {
                        dictionary.put(line[i], dictionary.get(line[i]) + 1);
                    } else {
                        dictionary.put(line[i], 1);
                    }
                c++;
                }
            }
            // System.out.println("Words loaded" + c);
        } catch (Exception e) {
            throw new Exception("File not found");
        }
        return dictionary;
    }
}

class Distance {
    Distance() {

    }
    public double Euclidean(Hashtable<String,Integer> dict1) {
        long sum = 0;
        for(Map.Entry<String, Integer> m: dict1.entrySet()) {
            // int val = (int)m.getValue();
            sum += m.getValue()*m.getValue();
        }
        double prod = Math.sqrt(sum);
        return prod;
    }
    public double DotProduct(Hashtable<String,Integer> dict1,
        Hashtable<String,Integer> dict2) {
        String key;
        int sum = 0;
        for (Map.Entry<String, Integer> m: dict1.entrySet()) {
            key = m.getKey();
            if (dict2.containsKey(key)) {
                int val1 = dict1.get(key);
                int val2 = dict2.get(key);
                sum += (val1*val2);
            }
        }
        return sum;
    }
    public double similarity(Hashtable<String,Integer> dictionary1,
        Hashtable<String,Integer> dictionary2) {
        double a = Euclidean(dictionary1);
        double b = Euclidean(dictionary2);
        double num = a*b;
        double deno = DotProduct(dictionary1, dictionary2);
        double result = deno/num;
        result = result * 100;
        return Math.round(result);
    }
}

class Solution {
    Solution () {

    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String foldername = scan.nextLine();
        Inpfromfolder i = new Inpfromfolder();
        final File folder = new File(foldername);
        // ArrayList<String> filenames= i.listFilesForFolder(folder);
        File[] allfiles = folder.listFiles();
        // System.out.println(Arrays.toString(allfiles));
        String s = "\t";
        for (File fil: allfiles) {
            s += fil.getName() + "\t";
        }
        // s = s.trim();
        // s = s.substring(0, s.length()-4);
        s += "\n";
        if (allfiles.length != 0) {
            // System.out.println("Entered if");
            for (File file1: allfiles) {
                s += file1.getName() + "\t";
                for (File file2: allfiles) {
                    Frequency f = new Frequency();
                    Distance d = new Distance();
                    s += d.similarity(f.loadWordstodict(file1), f.loadWordstodict(file2)) + "" + "\t";
                }
                s = s.trim();
                s += "\n";
            }
            System.out.println(s);
        } else {
            System.out.println("empty directory");
        }
        // f.loadWordstodict(filename1);
        // f.loadWordstodict(filename2);
    }
}