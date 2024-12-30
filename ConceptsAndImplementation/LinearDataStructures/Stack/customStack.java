package LinearDataStructures.Stack;

public class customStack<I>{
    private Item ptr=null;
    private int SIZE=0;
    private class Item{
        I item;
        Item ref=null;
        private Item(I item){
            this.item=item;
        }
    }
    public String toString(){
        if(ptr == null) return "Empty Stack";
        System.out.println("Top to Bottom");
        Item temp=ptr;
        while(temp != null){
            String arrow=" -->";
            if(temp.ref == null) arrow="";
            System.out.print(temp.item+arrow);
            temp=temp.ref;
        }
        return "";
    }


    //Operations
    void push(I item){
        Item newItem = new Item(item);
        newItem.ref=ptr;
        ptr=newItem;
        SIZE++;
    }

    I pop(){
        if(ptr == null) return null;
        I item=ptr.item;
        ptr=ptr.ref;
        SIZE--;
        return item;
    }

    I peek(){
        return ptr.item;
    }

    boolean isEmpty(){
        return ptr == null;
    }

    int size(){
        return SIZE;
    }

    void clear(){
        ptr=null;
    }


}
