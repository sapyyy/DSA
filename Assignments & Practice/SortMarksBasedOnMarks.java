class Students implements Comparable <Students> {
    private String name;
    private int marks;

    Students(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Students o) {
       return Integer.compare(marks, marks);
    }

    @Override
    public String toString(){
        return this.name + " -> " + this.marks;
    }
}

public class SortMarksBasedOnMarks {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr){
        int n = arr.length;
        for (int i=0; i<n; i++){
            for (int j=0; j<n-i-1; j++){
                if (arr[j].compareTo(arr[j+1])>0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (T ele : arr){
            System.out.print(ele + ", ");
        }
    }
    public static void main(String[] args) {
        Students[] arr = new Students[]{
            new Students("Saptadeep", 67),
            new Students("Debanjan", 70),
            new Students("Tapasi", 90),
            new Students("Swapan", 100),
            new Students("Rimi", 89)
        };

        bubbleSort(arr);
    }
}
