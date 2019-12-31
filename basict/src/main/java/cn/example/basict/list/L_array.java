package cn.example.basict.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Author：created by SugarT
 * Time：2019/11/7 10
 */
public class L_array {

    public static void main(String args[]) {

//        int[] array = {2, 2, 1};
//        System.out.println(singleNumber(array));

        int[] arr = {3, 2, 4, 4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

//        for (Integer disappearedNumber : findDisappearedNumbers(arr)) {
//            System.out.println(disappearedNumber);
//        }

//        findUnsortedSubarray(arr);

    }


    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * <p>
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * <p>
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [5,6]
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null)
            return list;

        Arrays.sort(nums);


        List<Integer> listComp = new ArrayList<>();

        for (int num : nums) {
            listComp.add(num);
        }

        for(int i=0;i<nums.length;i++){

            if(nums[i] != i+1 && !listComp.contains(i+1)){
                list.add(i+1);
            }
        }
      return list;




//        List<Integer> list = new ArrayList<>();
//        if (nums == null)
//            return list;
//        for (int i = 0; i < nums.length; ) {
//            if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]) {
//                i++;
//            } else {
//                swap(nums, i, nums[i] - 1);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i + 1)
//                list.add(i + 1);
//        }
//        return list;
    }

//    public static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] + arr[j];
//        arr[j] = arr[i] - arr[j];
//        arr[i] = arr[i] - arr[j];
//    }


    /**
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int[] numsClone = nums.clone();
        Arrays.sort(numsClone);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numsClone[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start > 0 ? (end - start) + 1 : 0;
    }


    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */

    public static int singleNumber(int[] nums) {

        /**
         * 异或运算的特点：两个相同的数字异或，结果为0。
         * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次，如果把所有的数都异或，相同的数字异或为0，最后只剩下出现一次的数字，它和0异或，结果就是它本身
         */
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            result = result ^ nums[i];
//        }
//        return result;


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) == null) {
                hashMap.put(nums[i], 1);
            } else {
                int value = hashMap.get(nums[i]);
                hashMap.put(nums[i], ++value);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterable = hashMap.entrySet().iterator();
        while (iterable.hasNext()) {

            Map.Entry<Integer, Integer> map = iterable.next();
            int key = map.getKey();
            int value = map.getValue();
            if (value == 1) {
                return key;
            }
        }

        return -1;
    }


}
