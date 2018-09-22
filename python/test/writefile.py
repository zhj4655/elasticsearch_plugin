#!/usr/bin/python
# -*- coding: UTF-8 -*-
import pickle

from sklearn.datasets import load_iris

if __name__ == "__main__":
    iris = load_iris()
    with open("data.m", "wb") as fw:
        pickle.dump(str(iris.data), fw)
