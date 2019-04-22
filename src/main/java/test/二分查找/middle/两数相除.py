def divide(dividend: int, divisor: int) -> int:
    # True 代表它们符号位相同
    pos = (dividend < 0) is (divisor < 0)
    res, dividend, divisor = 0, abs(dividend), abs(divisor)
    while dividend >= divisor:
        temp, i = divisor, 1
        while dividend >= temp:
            res += i
            dividend -= temp
            temp <<= 1
            i <<= 1

    if not pos:
        res = -res

    return min(max(-2147483648, res), 2147483647)


if __name__ == '__main__':
    print(divide(10, 3))
