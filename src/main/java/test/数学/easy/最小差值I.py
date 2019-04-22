class Solution:
    '''
    原数组的最大值和最小值 无论怎么操作 都不能比其他数 距离它们更近 ，所以 原数组的最大值和最小值 还会是新数组的最大值和最小值

    又因为题目要求新数组里最大值和最小值的最小距离，所以 拿出A数组里最大值 减去 A数组里最小值 再减去 2*K(它们最多能靠近的距离)，就是最小距离了

    '''

    def smallestRangeI(self, A, K):
        return max(0, max(A) - min(A) - 2 * K)


if __name__ == '__main__':
    A = [1,3,6]
    K = 3

    print(Solution().smallestRangeI(A, K))