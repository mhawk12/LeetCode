public class MergeSortedArray {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        if (m == 0) {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
        }

        int l = nums1.length - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {

            if (nums1[m] < nums2[n]) {
                nums1[l--] = nums2[n--];
            } else if (nums1[m] > nums2[n]) {
                nums1[l--] = nums1[m--];
            } else {
                nums1[l--] = nums1[m--];
                nums1[l--] = nums2[n--];
            }
        }


        if (n > -1) {
            for (int i = 0; i <= n; i++)
                nums1[i] = nums2[i];
        }

    }

    public static void main(String args[]) {

        int[] nums1 = {2, 0};
        int[] nums2 = {1};


        merge(nums1, 1, nums2, 1);

        for (int e : nums1)
            System.out.println(e);
    }
}
