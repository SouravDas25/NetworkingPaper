from main.arrays.LargestNumber import LargestNumber


def test_largest_number():
    ln = LargestNumber()
    n = ln.largestNumber([9,39,3])  # "343234323"
    print(n)
