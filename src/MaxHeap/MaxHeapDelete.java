package MaxHeap;

public class MaxHeapDelete {


    public int delete()
    {
        MaxHeapImpl m = MaxHeapImpl.instance;
        int popped = m.Heap[m.FRONT];
        m.Heap[m.FRONT] = m.Heap[m.size--];
        m.maxHeapify(m.FRONT);
        return popped;
    }
}
