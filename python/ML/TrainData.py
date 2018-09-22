# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import pickle

from sklearn.datasets import load_iris
from sklearn.neural_network import MLPClassifier


def train(data,target):
    clf=MLPClassifier()
    clf.fit(data,target)
    return str(clf)


if __name__== "__main__":
    iris = load_iris()
    clf=train(iris.data, iris.target)
    # print str(clf)
    with open("model.m", "wb") as fw:
        pickle.dump(clf,fw)
    # s=pickle.dumps(clf)
    # print(s)
    # a=[[6.3, 2.7, 4.9, 1.8]]
    # with open("model.m", "rb") as fr:
    #     clf= pickle.load(fr)
    #     b= clf.predict(a)
    #     print(b)