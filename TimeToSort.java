package timetosort;

public class TimeToSort {

    
    public static void quickSort(int[] list, int start, int last) {
        
        int temp;
        int pivot = list[start];
        int r = last;
        int l = start;
        
        
        if ((r-l) < 2) {
            return;
        }
        
        do {
            
            do {
            l = l +1;
            
        } while (list[l] <= pivot && (l < last));
        
        do {
            r = r-1;
            
        } while (list[r] >= pivot && (r > start));
        
        temp = list[l];
        list[l] = list[r];
        list[r] = temp;
        
        } while (l < r);

        if (l >= r) {
            temp = list[l];
            list[l] = list[r];
            list[r] = temp;
        }
        
        temp = list[r];
        list[r] = pivot;
        list[start] = temp;
        
        if (r > start + 1) {
            quickSort(list, start, r);
        }
        if (l < last) {
            quickSort(list, l, last);
        }
    }
    
    public static void printList(int[] list) {
        
        for (int i = 0; i <list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int [] list = new int [10];
        
        list[0] = 4;
        list[1] = 10;
        list[2] = 5;
        list[3] = 1;
        list[4] = 9;
        list[5] = 7;
        list[6] = 2;
        list[7] = 6;
        list[8] = 3;
        list[9] = 8;
        
        System.out.println("List to be sorted.");
        printList(list);
        System.out.println();
        
        quickSort(list, 0 , list.length);
        System.out.println();
        System.out.println("Sorted list");
        printList(list);
    }
    
}