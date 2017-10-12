package MaxHeap;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MaxHeapImpl implements MaxHeap{


        public int[] Heap;
        public static int size ;
        public int maxsize;
    public static ArrayList<Integer> values = new ArrayList<Integer>();
    public static ArrayList<String> instructions = new ArrayList<String>();

        public static final int FRONT = 1;

    public static void parseInput(String fileName)
    {


        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            System.out.println(line);

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        String[] lineArray = line.split(" ");
        String[] charArray = line.split("");

        for(int i=0;i<lineArray.length;i++)
        {

            for(int k=0;k<lineArray[i].length()-1;k++) {


                if(lineArray[i].length() < 3)
                {
                    i++;
                }
                if(lineArray[i].equals("del"))
                {
                    values.add(0);
                    instructions.add(lineArray[i]);
                    i++;
                }
                else if (Character.isDigit(lineArray[i].charAt(k)))
                {
                    String append = "";
                    int insert = 0;
                    StringBuilder sb = new StringBuilder();
                    while(Character.isDigit(lineArray[i].charAt(k)))
                    {
                        sb.append(lineArray[i].charAt(k));
                        k++;

                    }
                    append = (sb.toString());
                    insert = Integer.parseInt(append);
                    values.add(insert);

                }
                else if(Character.isAlphabetic(lineArray[i].charAt(k)))
                {
                    String append = "";
                    StringBuilder sb = new StringBuilder();
                    while(k<lineArray[i].length() &&  Character.isAlphabetic(lineArray[i].charAt(k)) )
                    {
                        sb.append(lineArray[i].charAt(k));
                        k++;

                    }
                    append = (sb.toString());
                    instructions.add(append);
                }
            }
        }



    }


       public static MaxHeapImpl instance = new MaxHeapImpl();

        public void initiator()
        {
            int maxsize = values.size();
            this.maxsize = maxsize;
            this.size = 0;
            Heap = new int[this.maxsize + 1];
            Heap[0] = Integer.MAX_VALUE;
        }

        public int parent(int pos)
        {
            return pos / 2;
        }

        public int leftChild(int pos)
        {
            return (2 * pos);
        }

        public int rightChild(int pos)
        {
            return (2 * pos) + 1;
        }

        public boolean isLeaf(int pos)
        {
            if (pos >=  (size / 2)  &&  pos <= size)
            {
                return true;
            }
            return false;
        }

        public void swap(int fpos,int spos)
        {
            int tmp;
            tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }
    @SuppressWarnings("Duplicates")
        public void maxHeapify(int pos)
        {
            if (!isLeaf(pos))
            {
                if ( Heap[pos] < Heap[leftChild(pos)]  || Heap[pos] < Heap[rightChild(pos)])
                {
                    if (Heap[leftChild(pos)] > Heap[rightChild(pos)])
                    {
                        swap(pos, leftChild(pos));
                        maxHeapify(leftChild(pos));
                    }else
                    {
                        swap(pos, rightChild(pos));
                        maxHeapify(rightChild(pos));
                    }
                }
            }
        }



        public void print()
        {
            for (int i = 1; i <= size / 2; i++ )
            {
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                        + " RIGHT CHILD :" + Heap[2 * i  + 1]);
                System.out.println();
            }
        }

        public void maxHeap()
        {
            for (int pos = (size / 2); pos >= 1; pos--)
            {
                maxHeapify(pos);
            }
        }

    public void runInstructions()
    {
        initiator();
        MaxHeapDelete d = new MaxHeapDelete();
        MaxHeapInsert s = new MaxHeapInsert();
        for(int i=0;i<values.size();i++)
        {
            if(instructions.get(i).equals("in"))
            {
                s.insert(values.get(i));
            }
            else if(instructions.get(i).equals("del"))
            {
                d.delete();
            }
        }
    }


}
