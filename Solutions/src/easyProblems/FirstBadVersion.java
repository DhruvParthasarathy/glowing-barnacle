package easyProblems;

// This code cannot be run on a different environment as we don't have information about the first bad verison
// The below code works on leetCode Platform
/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

/**
 * https://leetcode.com/problems/first-bad-version/
 * @author dhruv
 *
 */
public class FirstBadVersion extends VersionControl {

// First bad version is like finding the first occurance of a number in a sorted array
// here we have versions sorted from 1 to n
	public int firstBadVersion(int n) {

		int ans = -1; // in case there are no bad versions

		// there is minimum 1 version of the product that we have to check

		// now we have the version number as n

		int start = 1;
		int end = n;

		while (start <= end) {

			int middle = start + (end - start) / 2;

			if (isBadVersion(middle)) {
				// the middle element is a bad verison, further bad versions are present in
				// towards the left

				ans = middle;
				end = middle - 1;

			} else {
				// this means the bad versions are towards the right
				start = middle + 1;
			}

		}

		return ans;

	}
}