# -*- coding: utf-8 -*-
import numpy as np


# 将接收到的java String转换成float类型数组
def toArr(data):
    arr = data.split(' ')
    np_arr = np.array(arr, dtype=float)
    return np_arr


if __name__ == "__main__":
    str1 = "1 2 3 4"
    arr = toArr(str1)
    # print(arr)
    # arr=np.array(arr,dtype=float)
    print(arr)
