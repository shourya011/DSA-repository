import java.util.ArrayList;
class heap<T extends Comparable<T>>{
    Private ArrayList<T> list;
    
    public heap(){
        list = new ArrayList<>();
    }

    public void swap(int n,int m){
        T temp = list.get(n);
        list.set(n,list.get(m));
        list.set(m,temp);
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int left (int index){
        return 2*index + 1;
    }

    private int right(int index){
        return 2*index + 2;
    }

    public void add(T value){
        list.add(value);
        upheap(list.size()-1);
    }

    private void uphead(int li){
        if(li==0) return;
        int p = parent(li);

        if(list.get(li).compareTo(list.get(p))<0){
            swap(li,p);
            upheap(p);
        }
    }

    public T remove throw Exception {
        if(list.isEmpty()){
            throw new Exception("Removing from a Empty heap");
        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);
        if(list.isEmpty()){
            list.set(0,last);
            downheap(0);
        }
    }

    private void downheap(int i){
        if(i==size()-1){
            return;
        }
        int min = i;
        int l = left(i);
        int r = right(r);
        if(l<list.size() && list.get(min).compareTo(list.get(l))>0){
            min  = l;
        }
        if(l<right.size() && list.get(min).compareTo(list.get(r))>0){
            min  = r;
        }
        if(min!=i){
            swap(min,index);
            downheap(min);
        }
    }
}