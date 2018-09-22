#!/usr/bin/python
# -*- coding: UTF-8 -*-
from __future__ import print_function

from sklearn.datasets import load_iris
from scipy import sparse
from ML.TrainData import train

if __name__ == "__main__":
    a = [1, 2, 3, 4]
    print (a[4])
    # iris = load_iris()
    # for data in iris.data:
    #     for x in data:
    #         print(x, end=' ')
    #     print("")
    # print iris.data
    # target = iris.target
    # print type(target)
    # result = train(iris.data, iris.target)
    # print result