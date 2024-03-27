public class Sorting {


        public static void main(String[] args) {
            int[] test = new int[]{2,1,34,6};
            selectionSort(test);

            for(int i : test){
                System.out.print(i+" ");
            }
        }

        //selection sorting: N^2, N(1)
        public static void selectionSort(int[] nums){
            int n = nums.length;

            for(int i  = 0; i < n; i++){
                 int k = i;
                for (int j = i+1; j < n; j++) {
                    if(nums[j] < nums[k]){
                        k = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

            }
        }
        //buble sort : N^2, N(1)
    public void bubbleSort(int[] nums){
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    //insertion Sort : N^2, N(1)
    public void insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i], j = i - 1;
            // 内循环：将 base 插入到已排序部分的正确位置
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j]; // 将 nums[j] 向右移动一位
                j--;
            }
            nums[j + 1] = base;        // 将 base 赋值到正确位置
        }
    }

    //Quick Sort : N^2, O(N)
        public void quickSort(int[] nums , int left, int right){
            // 子数组长度为 1 时终止递归
            if (left >= right)
                return;
            // 哨兵划分
            int pivot = partition(nums, left, right);
            // 递归左子数组、右子数组
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);

        }
    /* 元素交换 */
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /* 哨兵划分 */
    int partition(int[] nums, int left, int right) {
        // 以 nums[left] 为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left])
                j--;          // 从右向左找首个小于基准数的元素
            while (i < j && nums[i] <= nums[left])
                i++;          // 从左向右找首个大于基准数的元素
            swap(nums, i, j); // 交换这两个元素
        }
        swap(nums, i, left);  // 将基准数交换至两子数组的分界线
        return i;             // 返回基准数的索引
    }

        public void heapSort(int[] arr) {
            // Mutates elements in lst by utilizing the heap data structure
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                maxHeapify(arr, arr.length, i);
            }

            for (int i = arr.length - 1; i > 0; i--) {
                // swap last element with first element
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                // note that we reduce the heap size by 1 every iteration
                maxHeapify(arr, i, 0);
            }
        }

        private void maxHeapify(int[] arr, int heapSize, int index) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            if (left < heapSize && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                maxHeapify(arr, heapSize, largest);
            }
        }
}

