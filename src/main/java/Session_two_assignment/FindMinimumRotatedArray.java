package Session_two_assignment;

public class FindMinimumRotatedArray {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {

                // Minimum is on the right side
                left = mid + 1;

            } else {

                // Minimum is on the left side
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(findMin(nums));
    }
}