def findMedianSortedArrays(num1, num2) -> float:
    if len(num2) < len(num1):
        num1, num2 = num2, num1

    x = len(num1)
    y = len(num2)

    l = 0
    h = x

    midOfMerged = (x + y + 1) // 2

    while l <= h:
        mid = (h + l) // 2
        print(l, mid, h, midOfMerged)

        leftUp = num1[mid - 1] if mid > 0 else float("-inf")
        leftDown = num2[midOfMerged - mid - 1] if midOfMerged - mid > 0 else float("-inf")

        rightUp = num1[mid] if mid < x else float("inf")
        rightDown = num2[midOfMerged - mid] if midOfMerged - mid < y else float("inf")

        if leftUp < rightDown and leftDown < rightUp:
            if (x + y) % 2 == 0:
                return (max(leftUp, leftDown) + min(rightDown, rightUp)) / 2
            else:
                return max(leftUp, leftDown)
        elif leftUp > leftDown:
            h = mid - 1
        else:
            l = mid + 1
    return 0


nums1 = [1]
nums2 = [1]

print(findMedianSortedArrays(nums1, nums2))
