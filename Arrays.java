import java.util.*;

public class Arrays {
    public static int[][] test(int[] test1, int target){
        if(test1 == null || test1.length == 0){
            return new int[0][2];
        }
        List<int[]> array = new ArrayList<>();


        //HashMap 
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<test1.length;i++){
            if(test1[i] == 0){
                throw new ArithmeticException();
            }
            int b = target/test1[i];
            if(map.containsKey(b)){
                int a = map.get(b);
                array.add(new int[]{a,i});

            }
            map.put(test1[i],i);
        }

        int[][] res = new int[array.size()][2];

        for (int i = 0; i < array.size(); i++) {

            res[i] = array.get(i);
        }

        return res;

    }
    //Time : O(n)
    //Space : O(n)

    public static void main(String[] args) {
        System.out.println("Hello Java ! ");
        int[] s = new int[]{3,5,8,4,6};
        int[][] a = test(s,24);

        for (int i = 0; i < a.length; i++) {
            System.out.print("(" + a[i][0] + ", " + a[i][1] + ") ");
        }
        System.out.println();

        System.out.println("test is :");

        int test = Integer.bitCount(3);
       String test2 = Integer.toBinaryString(2);
        System.out.println(test);
        System.out.println(test2);

        int[] arr3 = new int[]{4,4,3,5,2};
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(Integer.bitCount(arr3[i]));
        }
        int[] arr3_test = new int[5+1];
        for(int i : arr3){
            arr3_test[i]++;
        }
        System.out.println("The test 3 is :");
        for(int i : arr3_test){
            System.out.println(i);
        }







        //{3,5,8,4,6}
        //[[0,2],[3,4]], i < j





        // Array
        System.out.println("Array VS ArrayList ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i);
        }
        System.out.println("Array : ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println("ArrayList: ");
        int[] arr2 = new int[] {1,2,3,4,5};
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        //LinkedList

        //HashMap
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"jii");
        map.put(5,"bib");

        for (Map.Entry<Integer,String> set: map.entrySet()) {
            System.out.println(set.getKey() + " "+set.getValue());

        }
        //Stack : First-in ,last-out
        System.out.println("Stack : First-in ,last-out");
        Stack<Integer> stack = new Stack<>();
        stack.push(2);stack.push(5);stack.push(1);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        //Queue : Fist-in , first-out
        System.out.println("Queue : Fist-in,first-out");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(6);
        queue.offer(2);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        //Priority Queue
        System.out.println("Min Heap ");
        Queue<Integer> queue2 = new PriorityQueue<>(java.util.Arrays.asList(3,2,6,1,8));
        while(!queue2.isEmpty()){
            System.out.println(queue2.poll());
        }
        System.out.println("Max Heap");
        Queue<Integer> queue3 = new PriorityQueue<>(Collections.reverseOrder());
        queue3.offer(5);queue3.offer(90);queue3.offer(67);
        while (! queue3.isEmpty()){
            System.out.println(queue3.poll());
        }

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        q.add(23);
        int s2 = q.size();


        //TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("CC", 34);
        treeMap.put("AA", 67);
        treeMap.put("BB", 3);
        treeMap.put("GG", 343);
        treeMap.put("JJ", 356);
        System.out.println(treeMap.toString());

        //TreeSet
        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(4);
        treeSet.add(9);

        Iterator<Integer> interator = treeSet.iterator();
        while(interator.hasNext()){
            int next = interator.next();
            System.out.println(next);

        }
        System.out.println("Second iterate ");
        for(int i : treeSet){
            System.out.println(i);
        }


        System.out.println(treeSet.toString());
        System.out.println(treeSet.size());
        System.out.println(treeSet.isEmpty());


    }



    //Binary Search Tree
    //Search : O(logN)
    public TreeNode binarySearch(TreeNode root, int num){
        TreeNode cur = root;

        while(cur != null){
            if(num > cur.val){
                cur = cur.right;
            }if(num < cur.val){
                cur = cur.left;
            }else{
                break;
            }

        }

        return cur;
    }
    //insert : O(logN)
    public void insert(TreeNode root, int num){
        if(root== null){
            root =  new TreeNode(num);
            return ;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null){
            if(cur.val == num){
                return;
            }
            pre = cur;
            if(cur.val < num){
                cur = cur.right;
            }

            if(cur.val > num){
                cur = cur.left;
            }
        }

        if(pre.val > num){
            TreeNode newNode = new TreeNode(num);
            newNode = pre.left;
        }else{
            TreeNode newNode = new TreeNode(num);
            newNode = pre.right;
        }


    }



}
