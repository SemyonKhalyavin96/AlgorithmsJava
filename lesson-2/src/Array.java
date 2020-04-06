public class Array {
    private int[] array;
    private int size;

    public Array(int size){ // конструктор
        this.array = new int[size];
        this.size = size;
    }

    public int getSize(){ // вывести размер массива
        return this.size;
    }

    public void insert(int index, int value){ // вставка элемента массива
        Array new_arr = new Array(this.size + 1);
        for(int i = 0; i < index; i++){
            new_arr.array[i] = this.array[i];
        }
        new_arr.array[index] = value;
        for(int i = index; i < this.size; i++){
            new_arr.array[i + 1] = this.array[i];
        }
        this.array = new_arr.array;
        this.size = new_arr.size;
    }

    public void replace(int index, int value){ // замена элемента массива
        this.array[index] = value;
    }

    public void add(int value){ // добавление в конец массива
        Array new_arr = new Array(this.size + 1);
        for(int i = 0; i < this.size; i++){
            new_arr.array[i] = this.array[i];
        }
        new_arr.array[new_arr.size - 1] = value;
        this.array = new_arr.array;
        this.size = new_arr.size;
    }

    public void printArray(){ // распечатать массив
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public void delete(int index){ // удалить элемент массива
        Array new_arr = new Array(this.size -1);
        for(int i = 0; i < index; i++){
            new_arr.array[i] = this.array[i];
        }
        for(int i = index; i < new_arr.size; i ++){
            new_arr.array[i] = this.array[i+1];
        }
        this.array = new_arr.array;
        this.size = new_arr.size;
    }

    public boolean find(int value) { // поиск элемента массива
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return true;
            }
        }
        return false;
    }


    public void sortBubble(){ // сортировка пузырьком
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (this.array[in] > this.array[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b){
        int tmp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = tmp;
    }


    public void sortSelect(){ // сортировка выбором
        int out, in, mark;
        for(out=0;out<this.size;out++){
            mark = out;
            for(in = out+1;in<this.size;in++){
                if (this.array[in]< this.array[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
    }


    public void sortInsert(){ // сортировка вставкой
        int in, out;
        for(out = 1;out < this.size; out++){
            int temp = this.array[out];
            in = out;
            while(in > 0 && this.array[in-1] >=temp){
                this.array[in] = this.array[in-1];
                --in;
            }
            this.array[in] = temp;
        }
    }





}
