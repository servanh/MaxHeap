package MaxHeap;

public class MaxHeapInsert {


    public void insert(int element)
    {
        MaxHeapImpl m = MaxHeapImpl.instance;
        m.Heap[++m.size] = element;
        int current = m.size;

        while(m.Heap[current] > m.Heap[m.parent(current)])
        {
            m.swap(current,m.parent(current));
            current = m.parent(current);
        }
    }
}
